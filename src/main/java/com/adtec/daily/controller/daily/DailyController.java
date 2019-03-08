package com.adtec.daily.controller.daily;

import com.adtec.daily.bean.common.Msg;
import com.adtec.daily.bean.daily.*;
import com.adtec.daily.bean.project.Department;
import com.adtec.daily.bean.project.Project;
import com.adtec.daily.bean.project.ProjectTemplate;
import com.adtec.daily.bean.project.ProjectTemplateExample;
import com.adtec.daily.bean.user.User;
import com.adtec.daily.bean.user.UserExample;
import com.adtec.daily.service.daily.DailyDetailService;
import com.adtec.daily.service.daily.DailyService;
import com.adtec.daily.service.daily.OverWorkService;
import com.adtec.daily.service.project.CompanyService;
import com.adtec.daily.service.project.ProjectService;
import com.adtec.daily.service.project.ProjectTemplateService;
import com.adtec.daily.service.user.UserService;
import com.adtec.daily.util.Constants;
import com.adtec.daily.util.DateUtil;
import com.adtec.daily.util.TemplateParseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

import static com.adtec.daily.util.DateUtil.StrToDate;
import static com.adtec.daily.util.DateUtil.getWeek;

/**
 * @version V1.0
 * @Description: 日报信息类
 * @author: 胡浪
 * @date: 2018/4/8
 * @Copyright:
 */
@Controller
public class DailyController {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    DailyService dailyService;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    OverWorkService overWorkService;

    @Autowired
    CompanyService companyService;

    @Autowired
    ProjectTemplateService projectTemplateService;

    @Autowired
    DailyDetailService dailyDetailService;

    /**
     * 查询日报列表信息
     *
     * @param daily
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/daily/getDailyList", method = RequestMethod.POST)
    public Msg getDailyList(Daily daily, String userId) {

        PageHelper.startPage(daily.getPn(), 5);
        daily.setUserId(userId);
        List<Daily> tdList = dailyService.getDailyList(daily);
        String week = "";
        if (tdList.size() > 0) {
            for (Daily td : tdList) {
                week = getWeek(td.getDailyDate());
                td.setWeek(week);
            }
        }
        PageInfo page = new PageInfo(tdList, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 日报保存
     *
     * @param daily
     * @param result
     * @return
     */
    /*@RequestMapping(value = "/daily/saveDaily/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveDaily(@Valid Daily daily, @PathVariable String userId, BindingResult result) {
        DailyExample example = new DailyExample();
        DailyExample.Criteria cri = example.createCriteria();

        cri.andDailyDateEqualTo(StrToDate(daily.getDailyDateStr()));
        cri.andUserIdEqualTo(userId);
        cri.andProjectIdEqualTo(Integer.valueOf(daily.getProjectName()));
        List<Daily> list = dailyService.getDailyAllList(example);
        //保存之前判断是否存在该用户当日日报数据
        if (list.size() > 0) {
            return Msg.dateExist();
        } else {
            //查询获取用户名称
            UserExample example1 = new UserExample();
            UserExample.Criteria cri1 = example1.createCriteria();
            cri1.andUserIdEqualTo(userId);
            List<User> userList = userService.getUserInfoList(example1);
            if (userList.size() > 0) {
                Date offDutyDate = DateUtil.StrToTime(DateUtil.getHourTime());
                //保存该用户的日报信息
                daily.setDailyId("RB" + String.valueOf(System.currentTimeMillis()));
                daily.setUserName(userList.get(0).getUserName());
                daily.setUserId(userId);
                daily.setProjectId(Integer.valueOf(daily.getProjectName()));
                daily.setDailyDate(StrToDate(daily.getDailyDateStr()));
                daily.setOffDutyTime(offDutyDate);
                daily.setCreateTime(new Date());
                daily.setCreateUserId(userId);
                dailyService.saveDaily(daily);
                overWork(Integer.valueOf(daily.getProjectName()), offDutyDate, userId, StrToDate(daily.getDailyDateStr()), daily.getDailyId());
                return Msg.success();
            } else {
                return Msg.fail();
            }
        }
    }*/

    /**
     * 导出个人日报
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/daily/dailyExport", method = RequestMethod.GET)
    public void dailyExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("导出日报开始");
        String start = request.getParameter("dailyStartDateStr");
        String end = request.getParameter("dailyEndDateStr");
        logger.info("开始日期:"+start+",结束日期:"+end);
        List<User> users = new ArrayList<>();
        User user = (User)request.getSession().getAttribute("user");
        users.add(user);
        List<Map<String, Object>> reportList = dailyService.dailyExport(users,start,end);
        Map<String, Object> sheetMap = new HashMap<>();
        sheetMap.put("sheets", reportList);
        String fileName = "_工作日报_"+start+"_"+end;
        TemplateParseUtil templateParseUtil = new TemplateParseUtil();
        templateParseUtil.downloadExcel(response, sheetMap, Constants.CAITC_DAILY,fileName);
        logger.info("导出日报结束");
    }

    /**
     * 导出个人周报
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/daily/weeklyExport", method = RequestMethod.GET)
    public void weeklyExport(HttpServletRequest request, HttpServletResponse response, @RequestParam("preFinishDate") String preFinishDate) throws IOException {
        logger.info("导出个人周报开始");
        String start = "";
        String end = "";
        if (!"".equals(preFinishDate) && preFinishDate != null) {
            String[] preFinishDates = preFinishDate.split(" - ");
            start = preFinishDates[0].trim();
            end = preFinishDates[1].trim();
        }
//        String start = request.getParameter("dailyStartDateStr");
//        String end = request.getParameter("dailyEndDateStr");
        logger.info("开始日期:"+start+",结束日期:"+end);
        List<User> users = new ArrayList<>();
        User user = (User)request.getSession().getAttribute("user");
        //1.获取该项目模板名称
        Project project = (Project)request.getSession().getAttribute("project");
        Department department = (Department)request.getSession().getAttribute("department");
        user.setProjectLeaderName(project.getUserName());
        user.setDeptName(department.getDeptName());
        user.setProjectCode(project.getProjectCode());
        users.add(user);
        ProjectTemplateExample projectTemplateExample = new ProjectTemplateExample();
        ProjectTemplateExample.Criteria criteria = projectTemplateExample.createCriteria();
        criteria.andProjectIdEqualTo(project.getId());
        criteria.andTemplateTypeEqualTo(Constants.PERSONAL_WEEKLY);
        List<ProjectTemplate> templates = projectTemplateService.selectByExample(projectTemplateExample);
        if(templates!=null&&templates.size()>0){
            ProjectTemplate  template = templates.get(0);
            String fileName = "";
            Map<String, Object> sheetMap = new HashMap<>();
            List<Map<String, Object>> reportList = new ArrayList<>();
            if(Constants.CAITC_WEEKLY.equals(template.getTemplateFileName())){//
                reportList = dailyService.caitcWeeklyExport(users,start,end);
                fileName = "工作周报_"+user.getUserName()+"_"+start.replaceAll("-","")+"_"+end.replaceAll("-","");
            }else if(Constants.ADTEC_WEEKLY.equals(template.getTemplateFileName())){//
                reportList = dailyService.adtecWeeklyExport(users,start,end);
                fileName = "EAI-"+user.getUserName()+"-"+start.replaceAll("-","")+"-"+end.replaceAll("-","");
            }
            sheetMap.put("sheets", reportList);
            TemplateParseUtil templateParseUtil = new TemplateParseUtil();
            templateParseUtil.downloadExcel(response, sheetMap, template.getTemplateFileName(),fileName);
        }else{
            logger.info("周报模板未配置，请配置模板！");
        }
        logger.info("导出个人周报结束");
    }

    /**
     * 导出项目周报
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/daily/projectWeeklyExport", method = RequestMethod.GET)
    public void projectWeeklyExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("导出项目周报开始");
        String startDate = request.getParameter("dailyStartDateStr");
        String endDate = request.getParameter("dailyEndDateStr");
        logger.info("开始日期:"+startDate+",结束日期:"+endDate);
        //1.查询当前用户所属项目下的所有用户
        Project project = (Project)request.getSession().getAttribute("project");
        Department department = (Department)request.getSession().getAttribute("department");
        //TCompany company =  tCompanyService.selectByDeptId(department.getDeptId());
        //TUser user = (TUser)request.getSession().getAttribute("user");
        List<User> users = userService.getAllUserByProjectIdAndCompanyId(project.getId(),0, Constants.ROLE_TYPE_PROJECT);
        Map<String, Object> sheetMap = dailyService.caitcProjectWeeklyExport(users,startDate,endDate);
        String fileName = "工作周报-项目_"+startDate.replaceAll("-","")+"_"+endDate.replaceAll("-","");;
        TemplateParseUtil templateParseUtil = new TemplateParseUtil();
        templateParseUtil.downloadExcel(response, sheetMap, Constants.CAITC_PROJECT_WEEKLY,fileName);
        logger.info("导出项目周报结束");
    }

    /**
     * 根据不同场景判断计算加班时间规则
     *
     * @param projectId     项目ID
     * @param offDutyDate   下班时间
     * @param userId        用户ID
     * @param dailyDate     日报日期
     * @param dailyId       日报
     */
    public void overWork(int projectId, Date offDutyDate, String userId, Date dailyDate, String dailyId){
        //判断当前是否属于0-工作日，1-周末，2-节假日
        String toDayType = DateUtil.checkHoliday(new Date());
        logger.info("当前时间属性：" + toDayType);
        //查询项目的上午下班时间、下午开始上班时间、加班开始时间
        Project project = projectService.getProject(Integer.valueOf(projectId));
        if (toDayType != null && "0".equals(toDayType)) {
            if (project != null && !"".equals(project.getOverworkStartTime())) {
                //开始加班时间
                Date overWorkStartTime = project.getOverworkStartTime();
                //判断是否属于加班
                if (offDutyDate.getTime() > overWorkStartTime.getTime()) {
                    //属于加班，计算获取加班时长
                    Long overWorkLong = offDutyDate.getTime() - overWorkStartTime.getTime();
                    overWorkTime(overWorkLong, userId, dailyDate, dailyId,toDayType);
                }
            }
        } else if ("1".equals(toDayType ) || "2".equals(toDayType) ) {
            //计算周末或者节假日加班时间，加班时间
            if (project != null && !"".equals(project.getMorningEndTime()) && !"".equals(project.getAfterStartTime())) {
                //开始上班时间
                Date workStartTime = project.getWorkStartTime();
                //上午下班时间
                Date morningEndTime = project.getMorningEndTime();
                //下午开始上班时间
                Date afterStartTime= project.getAfterStartTime();
                //需要判断是上午下班了还是下午下班了
                //上午下班时间-开始上班时间
                Long overWorkLongMorning = morningEndTime.getTime() -workStartTime.getTime();
                //下班时间-上午下班时间
                Long overWorkLong = offDutyDate.getTime() - morningEndTime.getTime();
                //下午开始上班时间-下班时间
                Long overWorkLongNoon = afterStartTime.getTime() - offDutyDate.getTime();
                //下班时间-下午开始上班时间
                Long overWorkLongAfter = offDutyDate.getTime() - afterStartTime.getTime();
                //下午上班时间+上午上班时间
                Long overWorkLongSubtract = overWorkLongAfter + overWorkLongMorning;
                OverWork overWork = new OverWork();
                if (overWorkLong < 0) {
                    //若在上午下班之前提交了日报
                    overWorkTime(overWorkLong, userId, dailyDate, dailyId,toDayType);
                } else if (overWorkLongNoon < 0) {
                    //若在上午下班和下午上班之前，填写了日报，提前下班，加班时间=下班时间-上午下班时间
                    overWorkTime(overWorkLongMorning, userId, dailyDate, dailyId,toDayType);
                } else if (overWorkLongAfter > 0) {
                    //在下午上班之后下班
                    overWorkTime(overWorkLongSubtract, userId, dailyDate, dailyId,toDayType);
                }
            }
        }
    }

    /**
     * 计算加班时间方法
     *
     * @param overWorkLong  加班时间
     * @param userId        用户ID
     * @param dailyDate     日报日期
     * @param dailyId       日报ID
     * @param holidayFlag  节假日标识 0-工作日 1-周末 2-节假日
     */
    public void overWorkTime(Long overWorkLong, String userId, Date dailyDate, String dailyId,String holidayFlag) {
        OverWork overWork = new OverWork();
        BigDecimal overWorkDecimal = new BigDecimal(overWorkLong);
        BigDecimal total = new BigDecimal(1000);
        BigDecimal cycle = new BigDecimal(60);
        BigDecimal overWorkTime = ((overWorkDecimal.divide(total,1, BigDecimal.ROUND_HALF_UP)).divide(cycle, 1, BigDecimal.ROUND_HALF_UP)).divide(cycle, 1, BigDecimal.ROUND_HALF_UP);
        //0.5为最小单位，不满0.5的不要；不满1的记为0.5。使用ROUND_HALF_DOWN有点问题，这里硬写
        DecimalFormat oneMit = new DecimalFormat("0.0");
        //获取整数部分
        String overWorkTimeOneMitFirst = oneMit.format(overWorkTime).split("\\.")[0];
        String overWorkTimeOneMitSecond = oneMit.format(overWorkTime).split("\\.")[1];
        BigDecimal mixOverWorkTime = new BigDecimal("0.5");
        BigDecimal overWorkTimeOneMitFirstDouble = new BigDecimal(overWorkTimeOneMitFirst);
        if (overWorkTimeOneMitFirst.compareTo("0") == 0) {
            if (overWorkTimeOneMitSecond.compareTo("5") >= 0) {
                overWork.setOverWork(mixOverWorkTime);
            }
        } else if(overWorkTimeOneMitFirst.compareTo("0") > 0) {
            if (overWorkTimeOneMitSecond.compareTo("5") >= 0) {
                overWork.setOverWork(overWorkTimeOneMitFirstDouble.add(mixOverWorkTime));
            } else {
                overWork.setOverWork(overWorkTimeOneMitFirstDouble);
            }
        }
        //查询加班数据是否存在
        OverWorkExample example = new OverWorkExample();
        OverWorkExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andRemark1EqualTo(dailyId);
        List<OverWork> list = overWorkService.getAll(example);
        if (list.size() > 0) {
            //更新t_over_work
            OverWorkExample example2 = new OverWorkExample();
            OverWorkExample.Criteria cri2 = example2.createCriteria();
            cri2.andUserIdEqualTo(userId);
            cri2.andRemark1EqualTo(dailyId);

            overWork.setWorkDate(dailyDate);
            overWork.setUpdateUserId(userId);
            overWork.setUpdateTime(new Date());
            overWork.setRemark1(dailyId);
            overWork.setHolidayFlag(holidayFlag);
            overWorkService.updateOverWorkByDailyId(overWork, example2);
        } else {
            //插表t_over_work
            overWork.setUserId(userId);
            overWork.setWorkDate(dailyDate);
            overWork.setApprovalStatus(Constants.APPROVAL_STATUS_UNCHECK);
            overWork.setCreateUserId(userId);
            overWork.setCreateTime(new Date());
            overWork.setUpdateUserId(userId);
            overWork.setUpdateTime(new Date());
            overWork.setRemark1(dailyId);
            overWork.setHolidayFlag(holidayFlag);
            overWorkService.saveOverWork(overWork);
        }
    }

    /**
     * 首页：按天统计用户的上班时长、加班时长
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/daily/getWorkTimeAtYear", method = RequestMethod.POST)
    public Msg getWorkTimeAtYear(String userId) {
        List<Daily> tdList = dailyService.getWorkTimeAtYear(userId);
        if (tdList.size() > 0) {
            PageInfo page = new PageInfo(tdList, 0);
            return Msg.success().add("workTimeYearList", page);
        } else {
            return Msg.fail().add("workTimeYearList", 0);
        }
    }

    /**
     * 首页：按天统计用户的上班时长、加班时长
     *
     * @param userId    用户编号
     * @param yearMonth '2018-5'格式类型数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/daily/getWorkTimeAtMonth", method = RequestMethod.POST)
    public Msg getWorkTimeAtMonth(String userId, String yearMonth) {
        List<Daily> tdList = dailyService.getWorkTimeAtMonth(userId, yearMonth);
        if (tdList.size() > 0) {
            PageInfo page = new PageInfo(tdList, 0);
            return Msg.success().add("workTimeMonthList", page);
        } else {
            return Msg.fail().add("workTimeMonthList", 0);
        }
    }

//    /**
//     * 导出个人公司周报
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @ResponseBody
//    @RequestMapping(value = "/daily/weeklyExport", method = RequestMethod.GET)
//    public void adtecWeeklyExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        logger.info("导出日报开始");
//        String start = request.getParameter("dailyStartDateStr");
//        String end = request.getParameter("dailyEndDateStr");
//        logger.info("开始日期:"+start+",结束日期:"+end);
//        List<User> users = new ArrayList<>();
//        User user = (User)request.getSession().getAttribute("user");
//        Project project = (Project) request.getSession().getAttribute("project");
//        Department department = (Department)request.getSession().getAttribute("department");
//        user.setProjectLeaderName(project.getUserName());
//        user.setDeptName(department.getDeptName());
//        user.setProjectCode(project.getProjectCode());
//        users.add(user);
//        List<Map<String, Object>> reportList = dailyService.adtecWeeklyExport(users,start,end);
//        Map<String, Object> sheetMap = new HashMap<>();
//        sheetMap.put("sheets", reportList);
//        String fileName = "EAI-"+user.getUserName()+"-"+start.replaceAll("-","")+"-"+end.replaceAll("-","");
//        TemplateParseUtil templateParseUtil = new TemplateParseUtil();
//        templateParseUtil.downloadExcel(response, sheetMap, TemplateParseUtil.Type.AdtecWeekly,fileName);
//        logger.info("导出日报结束");
//    }

    /**
     * 新版日报保存
     *
     * @param dailyDetail
     * @param result
     * @return
     */
    @RequestMapping(value = "/daily/dailyManage/saveDaily", method = RequestMethod.POST)
    @ResponseBody
    public Msg dailySaveManage(@Valid DailyDetail dailyDetail, BindingResult result) {
        Daily daily = new Daily();
        //根据传入的完成百分比0=未开始，1-99=正在进行，100=已完成（01：未开始，02：正在进行，03：已完成）
        if (dailyDetail.getDailyPercent() != null) {
            if (dailyDetail.getDailyPercent() == 0) {
                dailyDetail.setExecution("01");
            } else if (dailyDetail.getDailyPercent() == 100) {
                dailyDetail.setExecution("03");
            } else {
                dailyDetail.setExecution("02");
            }
        }
        //获取当前时间
        Date offDutyDate = DateUtil.StrToTime(DateUtil.getHourTime());

        try {
            //首先查询表t_daily是否存在
            DailyExample example = new DailyExample();
            DailyExample.Criteria cri = example.createCriteria();

            cri.andDailyDateEqualTo(StrToDate(dailyDetail.getDailyDateStr()));
            cri.andUserIdEqualTo(dailyDetail.getUserId());
            cri.andProjectIdEqualTo(Integer.valueOf(dailyDetail.getProjectName()));
            List<Daily> list = dailyService.getDailyAllList(example);
            //保存之前判断是否存在该用户当日日报数据
            if (list.size() > 0) {
                //如果当日的t_daily表存在数据，则只添加t_daily_detail详细数据
                dailyDetail.setDailyDetailId("RBD" + String.valueOf(System.currentTimeMillis()));
                dailyDetail.setDailyId(list.get(0).getDailyId());
                dailyDetail.setDoneDate(DateUtil.StrToDate(dailyDetail.getDoneDateStr()));
                dailyDetail.setCreateTime(new Date());
                dailyDetail.setCreateUserId(dailyDetail.getUserId());
                dailyDetail.setUpdateTime(new Date());
                dailyDetail.setUpdateUserId(dailyDetail.getUserId());

                //保存日报详细内容
                dailyDetailService.saveDailyDetail(dailyDetail);

                //更新加班时间
                overWork(Integer.valueOf(dailyDetail.getProjectName()), offDutyDate, dailyDetail.getUserId(), DateUtil.StrToDate(dailyDetail.getDailyDateStr()), list.get(0).getDailyId());
            } else {
                //查询获取用户名称
                UserExample example2 = new UserExample();
                UserExample.Criteria cri2 = example2.createCriteria();
                cri2.andUserIdEqualTo(dailyDetail.getUserId());
                List<User> userList = userService.getUserInfoList(example2);
                if (userList.size() > 0) {
                    String dailyId = "RB" + String.valueOf(System.currentTimeMillis());
                    //保存该用户的日报信息
                    daily.setDailyId(dailyId);
                    daily.setDailyDate(StrToDate(dailyDetail.getDailyDateStr()));
                    daily.setUserId(dailyDetail.getUserId());
                    daily.setUserName(userList.get(0).getUserName());
                    daily.setProjectId(Integer.valueOf(dailyDetail.getProjectName()));
                    daily.setOffDutyTime(offDutyDate);
                    daily.setCreateTime(new Date());
                    daily.setCreateUserId(dailyDetail.getUserId());
                    daily.setUpdateTime(new Date());
                    daily.setUpdateUserId(dailyDetail.getUserId());
                    dailyService.saveDaily(daily);

                    //保存日报详细信息
                    dailyDetail.setDailyDetailId("RBD" + String.valueOf(System.currentTimeMillis()));
                    dailyDetail.setDailyId(dailyId);
                    dailyDetail.setDoneDate(DateUtil.StrToDate(dailyDetail.getDoneDateStr()));
                    dailyDetail.setCreateTime(new Date());
                    dailyDetail.setCreateUserId(dailyDetail.getUserId());
                    dailyDetail.setUpdateTime(new Date());
                    dailyDetail.setUpdateUserId(dailyDetail.getUserId());

                    //保存日报详细内容
                    dailyDetailService.saveDailyDetail(dailyDetail);
                    //更新加班时间
                    overWork(Integer.valueOf(dailyDetail.getProjectName()), offDutyDate, dailyDetail.getUserId(), DateUtil.StrToDate(dailyDetail.getDailyDateStr()), dailyId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.success();
    }
}
