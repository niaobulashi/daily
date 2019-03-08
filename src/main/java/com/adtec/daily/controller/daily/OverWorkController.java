package com.adtec.daily.controller.daily;

import com.adtec.daily.bean.common.Message;
import com.adtec.daily.bean.common.Msg;
import com.adtec.daily.bean.daily.OverWork;
import com.adtec.daily.bean.project.Company;
import com.adtec.daily.bean.project.Department;
import com.adtec.daily.bean.project.Project;
import com.adtec.daily.bean.user.User;
import com.adtec.daily.bean.user.UserRole;
import com.adtec.daily.bean.user.UserRoleExample;
import com.adtec.daily.service.daily.OverWorkService;
import com.adtec.daily.service.project.CompanyService;
import com.adtec.daily.service.user.UserRoleService;
import com.adtec.daily.service.user.UserService;
import com.adtec.daily.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 处理加班补贴
 */
@Controller
public class OverWorkController {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    UserService userService;

    @Autowired
    OverWorkService overWorkService;

    @Autowired
    CompanyService companyService;

    @Autowired
    UserRoleService userRoleService;

    /**
     * 导出加班补贴表
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/overWork/overWorkExport", method = RequestMethod.GET)
    public void dailyExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("导出加班补贴表开始");
        String startDate = request.getParameter("workStartDateStr");
        String endDate = request.getParameter("workEndDateStr");
        logger.info("开始日期:"+startDate+",结束日期:"+endDate);

        //1.算出所选月份所有日期
        List<String> dateList =  DateUtil.getDayListOfDateSegment(startDate,endDate);

        //2.查询当前用户所属项目下的所有用户
        Project project = (Project)request.getSession().getAttribute("project");
        Department department = (Department)request.getSession().getAttribute("department");
        Company company =  companyService.selectByDeptId(department.getDeptId());
        //User user = (User)request.getSession().getAttribute("user");
        List<User> users = userService.getAllUserByProjectIdAndCompanyId(project.getId(),company.getCompanyId(), Constants.ROLE_TYPE_PROJECT);

        //3.查询每个用户的加班情况
        //所有用户的总加班时长
        BigDecimal sumOverWork = BigDecimal.ZERO;
        //所有用户的总加班费
        BigDecimal sumOvertimePay = BigDecimal.ZERO;
        List<OverWork> overWorkList = new ArrayList<>();
        List<OverWork> overWorkDetailList = new ArrayList<>();
        for(int i=0;i<users.size();i++){
            //根据用户id及上班日期查询加班总时长
            OverWork overWork = overWorkService.selectOverWorkByUserIdAndWorkDate(users.get(i).getUserId(),startDate,endDate);
            if(overWork!=null){
                sumOverWork = sumOverWork.add(overWork.getSumOverWork());
            }else {
                overWork = new OverWork();
            }
            overWorkList.add(overWork);

            //初始化加班明细数据
            Map<String,OverWork> overWorkMap = new HashMap<>();
            for(int x=0;x<dateList.size();x++){
                overWorkMap.put(dateList.get(x),new OverWork());
            }

            //根据用户id及上班日期查询加班明细列表
            List<OverWork> overWorks = overWorkService.selectOverWorkDetailListByUserIdAndWorkDate(project.getId(),users.get(i).getUserId(),"1",startDate,endDate);
            for(int j=0;j<overWorks.size();j++){
                OverWork ow = overWorks.get(j);
                overWorkMap.put(ToolUtil.doubRecFormateDateString(ow.getWorkDate()),ow);
            }

            //重组加班补贴数据
            List<OverWork> owList = new ArrayList<>();
            TreeMap<String, OverWork> treeMap = new TreeMap<>(overWorkMap);
            //当月加班费
            BigDecimal monthOvertimePay = BigDecimal.ZERO;
            for(String key:treeMap.keySet()){
                OverWork ow = treeMap.get(key);
                String checkHolidayCode = ow.getHolidayFlag();
                //由于之前的加班老数据可能没有存节假日标识，值为null，这里手动赋值0，加班费按工作日计算
                //由于周末节假日不加班就不会存节假日标识，值为null，这里手动赋值0，导出报表时按工作日显示
                //为了不影响加班费请尽量补齐加班表老数据的节假日标识
                if(StringUtils.isEmpty(checkHolidayCode)){
                    ow.setHolidayFlag("0");
                }
                //加班费基数
                BigDecimal overtimePay = ow.getOvertimePay();
                if(overtimePay==null){
                    overtimePay = BigDecimal.ZERO;
                }
                //节假日加班费系数
                BigDecimal holidayOvertimeCoefficient = ow.getHolidayOvertimeCoefficient();
                if(holidayOvertimeCoefficient==null){
                    holidayOvertimeCoefficient = BigDecimal.ZERO;
                }
                //周末加班费系数
                BigDecimal weekendOvertimeCoefficient = ow.getWeekendOvertimeCoefficient();
                if(weekendOvertimeCoefficient==null){
                    weekendOvertimeCoefficient = BigDecimal.ZERO;
                }
                //加班时长
                BigDecimal tow = ow.getOverWork();
                if(tow==null){
                    tow = BigDecimal.ZERO;
                }
                //当日加班费
                BigDecimal dayOvertimePay = BigDecimal.ZERO;
                if("0".equals(checkHolidayCode)){//工作日
                    dayOvertimePay = tow.multiply(overtimePay);
                }else if("1".equals(checkHolidayCode)){//周末
                    dayOvertimePay = (tow.multiply(overtimePay)).multiply(weekendOvertimeCoefficient);
                }else if("2".equals(checkHolidayCode)){//节假日
                    dayOvertimePay = (tow.multiply(overtimePay)).multiply(holidayOvertimeCoefficient);
                }else{
                    dayOvertimePay = tow.multiply(overtimePay);
                }
                ow.setSumOvertimePay(dayOvertimePay);
                monthOvertimePay = monthOvertimePay.add(dayOvertimePay);
                owList.add(ow);
            }
            sumOvertimePay = sumOvertimePay.add(monthOvertimePay);
            overWork.setSumOvertimePay(monthOvertimePay);
            overWork.setOverWorkList(owList);
            overWorkDetailList.add(overWork);
        }

        Map<String, Object> sheetMap = new HashMap<>();
        sheetMap.put("companyName", company.getCompanyName());
        sheetMap.put("sumOverWork", sumOverWork);
        sheetMap.put("sumOvertimePay", sumOvertimePay);
        sheetMap.put("dateList", dateList);
        sheetMap.put("overWorkList", overWorkList);
        sheetMap.put("overWorkDetailList", overWorkDetailList);
        String fileName = department.getDeptName()+ "_项目补贴表（"+endDate.substring(0,4)+"年"+endDate.substring(5,7)+"月）_"+project.getProjectCode()+"_" + users.get(0).getUserName();
        TemplateParseUtil templateParseUtil = new TemplateParseUtil();
        templateParseUtil.downloadExcel(response, sheetMap, Constants.OVER_WORK,fileName);
        logger.info("导出加班补贴表结束");
    }

    /**
     * 查询加班明细
     *
     * @return
     */
    @RequestMapping(value = "/overWork/getOverWorkList", method = RequestMethod.GET)
    @ResponseBody
    public Message getOverWorkList(int page,int limit, String userId, String approvalStatus, String workDateStr, HttpServletRequest request, HttpServletResponse response) {
        logger.info("查询加班明细开始");
        String workDateStartStr = "";
        String workDateEndStr = "";
        if (!"".equals(workDateStr) && workDateStr != null) {
            String[] preFinishDates = workDateStr.split(" - ");
            workDateStartStr = preFinishDates[0].trim();
            workDateEndStr = preFinishDates[1].trim();
        }
        User user = (User)request.getSession().getAttribute("user");
        Project project = (Project)request.getSession().getAttribute("project");
        //1.查询该用户是不是项目经理
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria cri = example.createCriteria();
        cri.andUserIdEqualTo(user.getUserId());
        cri.andRoleIdEqualTo(5);
        List<UserRole> userRoleList = userRoleService.selectUserRole(example);
        PageHelper.startPage(page, limit);
        List<OverWork> pros = new ArrayList<>();
        if(userRoleList!=null && userRoleList.size()>0){//项目经理角色
            // 根据用户id加班日期及审核状态查询加班明细
            pros = overWorkService.selectOverWorkDetailListByUserIdAndWorkDate(project.getId(),userId,approvalStatus,workDateStartStr,workDateEndStr);

        }else{
            // 根据用户id加班日期及审核状态查询加班明细
            pros = overWorkService.selectOverWorkDetailListByUserIdAndWorkDate(project.getId(),user.getUserId(),approvalStatus,workDateStartStr,workDateEndStr);
        }
        //PageInfo pageInfo = new PageInfo(pros);
        Message message = Message.success().add(pros);
        logger.info("查询加班明细结束");
        return message;
    }

    /**
     * 根据id查询加班信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/overWork/getOverWorkById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getOverWork(@PathVariable("id") Integer id) {
        OverWork overWork = overWorkService.getOverWork(id);
        return Msg.success().add("id", overWork);
    }

    /**
     * 审核加班信息
     *
     * @param overWork
     * @return
     */
    @RequestMapping(value = "/overWork/updateOverWorkInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg updateOverWork(@Valid OverWork overWork, BindingResult result) {
        logger.info("审核加班信息开始");
        overWork.setUpdateTime(new Date());
        overWork.setUpdateUserId(overWork.getUserId());
        overWorkService.updateOverWork(overWork);
        logger.info("审核加班信息结束");
        return Msg.success();
    }

    /**
     * 批量审核加班信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/overWork/batchAuditOverWork", method = RequestMethod.POST)
    @ResponseBody
    public Message batchAuditOverWork(String[] idArray,String approvalStatus,String approvalOpinion,HttpServletRequest request, HttpServletResponse response) {
        logger.info("批量审核加班信息开始");
        User user = (User)request.getSession().getAttribute("user");
        OverWork overWork = new OverWork();
        //循环更新加班信息
        for(int i=0;i<idArray.length;i++){
            overWork.setId(Integer.parseInt(idArray[i]));
            overWork.setApprovalStatus(approvalStatus);
            overWork.setApprovalOpinion(approvalOpinion);
            overWork.setUpdateTime(new Date());
            overWork.setUpdateUserId(user.getUserId());
            overWorkService.updateOverWork(overWork);
        }
        logger.info("批量审核加班信息结束");
        return Message.success();
    }
}
