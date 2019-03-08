package com.adtec.daily.service.daily.impl;

import com.adtec.daily.bean.daily.Daily;
import com.adtec.daily.bean.daily.DailyExample;
import com.adtec.daily.bean.user.User;
import com.adtec.daily.dao.daily.DailyMapper;
import com.adtec.daily.service.daily.DailyService;
import com.adtec.daily.util.Constants;
import com.adtec.daily.util.StringUtil;
import com.adtec.daily.util.ToolUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @version V1.0
 * @Description: 日报信息实现类
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright:
 */
@Service
public class DailyServiceImpl implements DailyService {

	@Autowired
    DailyMapper dailyMapper;

	/**
	 * 日报列表查询
	 */
    @Override
	public List<Daily> getDailyList(Daily record) {
        List<Daily> dailyList = dailyMapper.selectDailyListByUserId(record);
		return dailyList;
	}

    /**
     * 日报保存
     */
    @Override
	public void saveDaily(Daily daily) {
	    dailyMapper.insertSelective(daily);
    }

    /**
     * 条件查询日报信息
     */
    @Override
    public List<Daily> getDailyAllList(DailyExample example){
        List<Daily> dailyList = dailyMapper.selectByExample(example);
        return dailyList;
    }

	/**
	 * 导出个人日报
	 */
    @Override
	public List<Map<String, Object>> dailyExport(List<User> users, String startDate, String endDate){
		List<Map<String, Object>> reportList = new ArrayList<>();
		for(int i=0;i<users.size();i++){
			//1.获取日报数据
			List<Daily> dailyList = dailyMapper.selectDailyListByUserIdAndDailyDate(users.get(i).getUserId(),startDate,endDate);

			//2.组装日报数据
			List<Daily> nextWeekList = new ArrayList<>();
			Map<String,Daily> dailyMap = new HashMap<>();
			for(int j=0;j<dailyList.size();j++){
				Daily daily = dailyList.get(j);

				//组装下周计划数据
				if(StringUtils.isNotEmpty(daily.getNextWorkPlan())){
					Daily nextDaily = new Daily();
					nextDaily.setNextWorkPlan(daily.getNextWorkPlan());
					nextDaily.setLineNumber(StringUtil.stringRowNum(daily.getNextWorkPlan(),45));
					nextWeekList.add(nextDaily);
				}

				String dailyDate = ToolUtil.dateToString(daily.getDailyDate(),"yyyy-MM-dd");
				if(dailyMap.get(dailyDate)!=null){
					dailyMap.put(dailyDate,dailyMap.get(dailyDate));
				}else{
					dailyMap.put(dailyDate,new Daily());
				}
				//遍历map判断日期是否存在map中，若存在则取出list里面的数据放到map中
				Iterator keys = dailyMap.keySet().iterator();
				while(keys.hasNext()){
					String key = (String)keys.next();
					if(dailyDate.equals(key)){
						int[] lineNumberArray = {24,12,45};
						dailyToWeekly(key,dailyMap,daily,lineNumberArray);
					}
				}

			}

			List<Daily> thisWeekList = new ArrayList<>();
			TreeMap<String, Daily> treeMap = new TreeMap<>(dailyMap);
			for(String key:treeMap.keySet()){
				thisWeekList.add(treeMap.get(key));
			}

			Map<String, Object> data = new HashMap<>();
			data.put("thisWeeks", thisWeekList);
			data.put("nextWeeks", nextWeekList);
			data.put("name", users.get(i).getUserName());
			data.put("startDate",startDate);
			data.put("endDate", endDate);
			data.put("sheetTitle",users.get(i).getUserName());
			reportList.add(data);
		}
		return reportList;
	}

	/**
	 * 导出个人周报
	 */
    @Override
	public List<Map<String, Object>> caitcWeeklyExport(List<User> users, String startDate, String endDate){
		List<Map<String, Object>> reportList = new ArrayList<>();
		for(int i=0;i<users.size();i++){
			//1.获取周报数据
			List<Daily> dailyList = dailyMapper.selectDailyListByUserIdAndDailyDate(users.get(i).getUserId(),startDate,endDate);

			//2.组装周报数据
			Map<String, Daily> weeklyData = new HashMap<>();
			//初始化需求分析数据
			Daily analysis = new Daily();
			analysis.setWorkType(Constants.WORK_TYPE_ANALYSIS);
			analysis.setLineNumber(1);
			analysis.setPlanLineNumber(1);
			weeklyData.put(Constants.WORK_TYPE_ANALYSIS,analysis);
			//初始化设计数据
			Daily design = new Daily();
			design.setWorkType(Constants.WORK_TYPE_DESIGN);
			design.setLineNumber(1);
			design.setPlanLineNumber(1);
			weeklyData.put(Constants.WORK_TYPE_DESIGN,design);
			//初始化开发数据
			Daily development = new Daily();
			development.setWorkType(Constants.WORK_TYPE_DEVELOPMENT);
			development.setLineNumber(1);
			development.setPlanLineNumber(1);
			weeklyData.put(Constants.WORK_TYPE_DEVELOPMENT,development);
			//初始化测试数据
			Daily test = new Daily();
			test.setWorkType(Constants.WORK_TYPE_TEST);
			test.setLineNumber(1);
			test.setPlanLineNumber(1);
			weeklyData.put(Constants.WORK_TYPE_TEST,test);
			//初始化版本发布数据
			Daily version = new Daily();
			version.setWorkType(Constants.WORK_TYPE_VERSION);
			version.setLineNumber(1);
			version.setPlanLineNumber(1);
			weeklyData.put(Constants.WORK_TYPE_VERSION,version);
			//初始化运维支持数据
			Daily operation = new Daily();
			operation.setWorkType(Constants.WORK_TYPE_OPERATION);
			operation.setLineNumber(1);
			operation.setPlanLineNumber(1);
			weeklyData.put(Constants.WORK_TYPE_OPERATION,operation);
			//初始化会议数据
			Daily meeting = new Daily();
			meeting.setWorkType(Constants.WORK_TYPE_MEETING);
			meeting.setLineNumber(1);
			meeting.setPlanLineNumber(1);
			weeklyData.put(Constants.WORK_TYPE_MEETING,meeting);
			//初始化其他数据
			Daily other = new Daily();
			other.setWorkType(Constants.WORK_TYPE_OTHER);
			other.setLineNumber(1);
			other.setPlanLineNumber(1);
			weeklyData.put(Constants.WORK_TYPE_OTHER,other);

			for(int j=0;j<dailyList.size();j++){
				Daily weekly = dailyList.get(j);
				int[] lineNumberArray = {52,42,114};
				if(Constants.WORK_TYPE_ANALYSIS.equals(weekly.getWorkType())){//需求分析
					dailyToWeekly(Constants.WORK_TYPE_ANALYSIS,weeklyData,weekly,lineNumberArray);
				}else if(Constants.WORK_TYPE_DESIGN.equals(weekly.getWorkType())){//设计
					dailyToWeekly(Constants.WORK_TYPE_DESIGN,weeklyData,weekly,lineNumberArray);
				}else if(Constants.WORK_TYPE_DEVELOPMENT.equals(weekly.getWorkType())){//开发
					dailyToWeekly(Constants.WORK_TYPE_DEVELOPMENT,weeklyData,weekly,lineNumberArray);
				}else if(Constants.WORK_TYPE_TEST.equals(weekly.getWorkType())){//测试
					dailyToWeekly(Constants.WORK_TYPE_TEST,weeklyData,weekly,lineNumberArray);
				}else if(Constants.WORK_TYPE_VERSION.equals(weekly.getWorkType())){//版本发布
					dailyToWeekly(Constants.WORK_TYPE_VERSION,weeklyData,weekly,lineNumberArray);
				}else if(Constants.WORK_TYPE_OPERATION.equals(weekly.getWorkType())){//运维支持
					dailyToWeekly(Constants.WORK_TYPE_OPERATION,weeklyData,weekly,lineNumberArray);
				}else if(Constants.WORK_TYPE_MEETING.equals(weekly.getWorkType())){//会议
					dailyToWeekly(Constants.WORK_TYPE_MEETING,weeklyData,weekly,lineNumberArray);
				}else if(Constants.WORK_TYPE_OTHER.equals(weekly.getWorkType())){//其他
					dailyToWeekly(Constants.WORK_TYPE_OTHER,weeklyData,weekly,lineNumberArray);
				}
			}

			List<Daily> thisWeekList = new ArrayList<>();
			for (String key : weeklyData.keySet()) {
				thisWeekList.add(weeklyData.get(key));
			}

			Map<String, Object> data = new HashMap<>();
			data.put("thisWeeks", thisWeekList);
			data.put("name", users.get(i).getUserName());
			data.put("startDate",startDate);
			data.put("endDate", endDate);
			data.put("sheetTitle",users.get(i).getUserName());
			reportList.add(data);
		}
		return reportList;
	}

	/**
	 * 导出项目周报
	 */
    @Override
	public Map<String, Object> caitcProjectWeeklyExport(List<User> users, String startDate, String endDate){
		Map<String, Object> sheetMap = new HashMap<>();
		List<Daily> thisWeekList = new ArrayList<>();
		List<Daily> list = new ArrayList<>();
		//1.获取项目周报数据
		for(int i=0;i<users.size();i++){
			List<Daily> dailyList = dailyMapper.selectDailyListByUserIdAndDailyDate(users.get(i).getUserId(),startDate,endDate);
			list.addAll(dailyList);
		}
		//2.组装项目周报数据
		List<Daily> analysisList = new ArrayList<>();
		List<Daily> designList = new ArrayList<>();
		List<Daily> devAndTestList = new ArrayList<>();
		List<Daily> versionList = new ArrayList<>();
		List<Daily> operationList = new ArrayList<>();
		List<Daily> manageList = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			Daily weekly = list.get(i);
			int[] lineNumberArray = {52,52,52};
			if(Constants.WORK_TYPE_ANALYSIS.equals(weekly.getWorkType())){//需求分析
				dailyToProjectWeekly(weekly,lineNumberArray);
				analysisList.add(weekly);
			}else if(Constants.WORK_TYPE_DESIGN.equals(weekly.getWorkType())){//设计
				dailyToProjectWeekly(weekly,lineNumberArray);
				designList.add(weekly);
			}else if(Constants.WORK_TYPE_DEVELOPMENT.equals(weekly.getWorkType())||Constants.WORK_TYPE_TEST.equals(weekly.getWorkType())){//开发及测试
				dailyToProjectWeekly(weekly,lineNumberArray);
				devAndTestList.add(weekly);
			}else if(Constants.WORK_TYPE_VERSION.equals(weekly.getWorkType())){//版本发布
				dailyToProjectWeekly(weekly,lineNumberArray);
				versionList.add(weekly);
			}else if(Constants.WORK_TYPE_OPERATION.equals(weekly.getWorkType())){//运维支持
				dailyToProjectWeekly(weekly,lineNumberArray);
				operationList.add(weekly);
			}else if(Constants.WORK_TYPE_MEETING.equals(weekly.getWorkType())||Constants.WORK_TYPE_OTHER.equals(weekly.getWorkType())){//项目管理
				dailyToProjectWeekly(weekly,lineNumberArray);
				manageList.add(weekly);
			}
		}
		sheetMap.put("startDate", startDate);
		sheetMap.put("endDate", endDate);
		sheetMap.put("analysisList", analysisList);
		sheetMap.put("designList", designList);
		sheetMap.put("devAndTestList", devAndTestList);
		sheetMap.put("versionList", versionList);
		sheetMap.put("operationList", operationList);
		sheetMap.put("manageList", manageList);
		return sheetMap;
	}

	/**
	 * 根据日报数据生成周报数据
	 */
    @Override
	public void dailyToWeekly(String key, Map<String,Daily> weeklyData, Daily weekly, int[] lineNumberArray){
		int workContentNum = 0;//日报内容所占行数
		int problemNum = 0;//问题所占行数
		//组装日报内容和完成情况数据（日报内容：一行只能放下26个字）
		if(StringUtils.isEmpty((weeklyData.get(key)).getDailyContent())){//没有数据
			if(StringUtils.isNotEmpty(weekly.getDailyContent())){
				weekly.setDailyContent("1、" + weekly.getDailyContent());
				//计算当前日报内容所占行数
				int lastNum = StringUtil.stringByteRowNum(weekly.getDailyContent(),lineNumberArray[0]);
				weekly.setExecutionJoint(weekly.getExecutionShow());
				for(int x=1;x<lastNum;x++){
					weekly.setExecutionJoint(weekly.getExecutionJoint() + "&#10;");
				}
			}
		}else{//有数据
			String workContent = (weeklyData.get(key)).getDailyContent();
			String executionJoint = (weeklyData.get(key)).getExecutionJoint();
			if(workContent.indexOf("&#10;")>0){//不止一条数据
				//计算出已有日报内容序号
				int dataNum = StringUtil.dailyNo(workContent);
				if(StringUtils.isNotEmpty(weekly.getDailyContent())){
					//计算出当前日报内容行数
					int lastNum = StringUtil.stringByteRowNum((dataNum+1) + "、"+ weekly.getDailyContent(),lineNumberArray[0]);
					weekly.setDailyContent(workContent+"&#10;"+ (dataNum+1) +"、"+weekly.getDailyContent());
					weekly.setExecutionJoint(executionJoint+"&#10;"+ weekly.getExecutionShow());
					for(int x=1;x<lastNum;x++){
						weekly.setExecutionJoint(weekly.getExecutionJoint() + "&#10;");
					}
				}

			}else{//只有一条数据
				if(StringUtils.isNotEmpty(weekly.getDailyContent())){
					//计算出当前日报内容行数
					int lastNum = StringUtil.stringByteRowNum("2、" + weekly.getDailyContent(),lineNumberArray[0]);
					weekly.setDailyContent(workContent+"&#10;2、"+weekly.getDailyContent());
					weekly.setExecutionJoint(executionJoint+"&#10;"+ weekly.getExecutionShow());
					for(int x=1;x<lastNum;x++){
						weekly.setExecutionJoint(weekly.getExecutionJoint() + "&#10;");
					}
				}
			}
		}

		//组装问题数据：一行只能放下21个字
		if(StringUtils.isEmpty((weeklyData.get(key)).getProblem())){//没数据
			if(StringUtils.isNotEmpty(weekly.getProblem())){
				weekly.setProblem("1、"+ weekly.getProblem());
			}
		}else{//有数据
			String problem = (weeklyData.get(key)).getProblem();
			if(problem.indexOf("&#10;")>0){//不止一条数据
				//计算出已有问题序号
				int dataNum = StringUtil.dailyNo(problem);
				if(StringUtils.isNotEmpty(weekly.getProblem())){
					weekly.setProblem(problem + "&#10;" + (dataNum + 1) + "、" + weekly.getProblem());
				}else{
					weekly.setProblem(problem);
				}
			}else{//只有一条数据
				if(StringUtils.isNotEmpty(weekly.getProblem())){
					weekly.setProblem(problem+"&#10;2、"+weekly.getProblem());
				}else{
					weekly.setProblem(problem);
				}
			}
		}

		//组装下周计划数据：一行只能放下57个字
		if(StringUtils.isEmpty((weeklyData.get(key)).getNextWorkPlan())){//没数据
			if(StringUtils.isNotEmpty(weekly.getNextWorkPlan())){
				weekly.setNextWorkPlan("1、"+ weekly.getNextWorkPlan());
				weekly.setPlanLineNumber(StringUtil.stringByteRowNum(weekly.getNextWorkPlan(),lineNumberArray[2]));
			}else{
				weekly.setPlanLineNumber(1);
			}
		}else{//有数据
			String plan = (weeklyData.get(key)).getNextWorkPlan();
			if(plan.indexOf("&#10;")>0){//不止一条数据
				//计算出已有计划序号
				int dataNum = StringUtil.dailyNo(plan);
				if(StringUtils.isNotEmpty(weekly.getNextWorkPlan())){
					weekly.setNextWorkPlan(plan + "&#10;" + (dataNum + 1) + "、" + weekly.getNextWorkPlan());
				}else{
					weekly.setNextWorkPlan(plan);
				}
			}else{//只有一条数据
				if(StringUtils.isNotEmpty(weekly.getNextWorkPlan())){
					weekly.setNextWorkPlan(plan+"&#10;2、"+weekly.getNextWorkPlan());
				}else{
					weekly.setNextWorkPlan(plan);
				}
			}
			weekly.setPlanLineNumber(StringUtil.stringByteRowNum(weekly.getNextWorkPlan(),lineNumberArray[2]));
		}


		//比较日报内容和问题所占行数，取出最大行数存入对象中。
		//计算出所有日报内容行数
		workContentNum = StringUtil.dailyRowNum(weekly.getDailyContent(),lineNumberArray[0]);
		//计算出所有问题内容行数
		problemNum = StringUtil.dailyRowNum(weekly.getProblem(),lineNumberArray[1]);
		if(workContentNum>=problemNum){
			weekly.setLineNumber(workContentNum);
		}else{
			weekly.setLineNumber(problemNum);
		}

		weeklyData.put(key,weekly);
	}

	/**
	 * 根据日报数据生成项目周报数据
	 */
    @Override
	public void dailyToProjectWeekly(Daily weekly, int[] lineNumberArray) {
		//组装日报内容（日报内容：一行只能放下26个字）
		if(StringUtils.isNotEmpty(weekly.getDailyContent())){
			//计算当前日报内容所占行数
			int lineNum = StringUtil.stringByteRowNum(weekly.getDailyContent(),lineNumberArray[0]);
			weekly.setLineNumber(lineNum);
		}else{
			weekly.setLineNumber(1);
		}

		//组装问题数据：一行只能放下26个字
		if(StringUtils.isNotEmpty(weekly.getProblem())){
			//计算问题内容所占行数
			int lineNum = StringUtil.stringByteRowNum(weekly.getProblem(),lineNumberArray[1]);
			weekly.setLineNumber(lineNum);
		}

		//组装下周计划数据：一行只能放下26个字
		if(StringUtils.isNotEmpty(weekly.getNextWorkPlan())){
			//计算下周计划所占行数
			int lineNum = StringUtil.stringByteRowNum(weekly.getNextWorkPlan(),lineNumberArray[2]);
			weekly.setPlanLineNumber(lineNum);
		}
	}

    /**
     * 首页：按天统计用户的上班时长、加班时长
     */
    public List<Daily> getWorkTimeAtYear(String userId) {
        List<Daily> dailyList = dailyMapper.selectWorkTimeAtYear(userId);
        return dailyList;
    }

    /**
     * 首页：按天统计用户的上班时长、加班时长
     */
    public List<Daily> getWorkTimeAtMonth(String userId, String yearMonth) {
        List<Daily> dailyList = dailyMapper.selectWorkTimeAtMonth(userId, yearMonth);
        return dailyList;
    }

	/**
	 * 导出个人周报
	 */
	@Override
	public List<Map<String, Object>> adtecWeeklyExport(List<User> users, String startDate, String endDate){
		List<Map<String, Object>> reportList = new ArrayList<>();

		for(int i=0;i<users.size();i++){
            Map<String,Object> reportMap = new HashMap<>();
			//1.获取周报数据
			List<Daily> dailyList = dailyMapper.selectDailyListByUserIdAndDailyDate(users.get(i).getUserId(),startDate,endDate);

			//2.拼接上周内容和本周计划
            List<String> planList = new ArrayList<>();
            //获取下周计划
            for (Daily daily : dailyList){
                if (StringUtils.isNotEmpty(daily.getNextWorkPlan())){
                    planList.add(daily.getNextWorkPlan());
                }
            }
            //拼接到日报内容
            for (int k=0;k<dailyList.size();k++){
                dailyList.get(k).setNextWorkPlan("");
                if (k<planList.size()){
                    dailyList.get(k).setNextWorkPlan(planList.get(k));
                }
            }
            //计算行数，取最大值
            for(int j=0;j<dailyList.size();j++) {
                int lineNumber = 1;//日报所在行数
                int workContentNum = 1;//日报内容所占行数
                int problemNum = 1;//问题所占行数
                int planNum = 1;//计划所占行数
                Daily weekly = dailyList.get(j);
                int[] lineNumberArray = {28, 38, 42};
                //组装日报内容（日报内容：一行只能放下14个字）
                if (StringUtils.isNotEmpty(weekly.getDailyContent())) {
                    workContentNum = StringUtil.stringByteRowNum(weekly.getDailyContent(), lineNumberArray[0]);
                }
				//组装日报内容（问题内容：一行只能放下19个字）
                if (StringUtils.isNotEmpty(weekly.getProblem())) {
                    problemNum = StringUtil.stringByteRowNum(weekly.getDailyContent(), lineNumberArray[1]);
                }
                //组装日报内容（计划内容：一行只能放下21个字）
                if (StringUtils.isNotEmpty(weekly.getNextWorkPlan())) {
                    planNum = StringUtil.stringByteRowNum(weekly.getDailyContent(), lineNumberArray[2]);
                }
                lineNumber = (workContentNum > problemNum ? (workContentNum > planNum ? workContentNum : planNum) : (problemNum > planNum ? problemNum : planNum));
                weekly.setLineNumber(lineNumber);
            }
            //数据的数量
            int dailyNum = dailyList.size();
			//周报数据
			Map<String, Object> data = new HashMap<>();
			data.put("thisWeeks", dailyList);
			data.put("name", users.get(i).getUserName());
			data.put("startDate",startDate);
			data.put("endDate", endDate);
			data.put("deptName",users.get(i).getDeptName());
			data.put("projectLeaderName",users.get(i).getProjectLeaderName());
			data.put("dailyNum",dailyNum);
			data.put("projectCode",users.get(i).getProjectCode());
            data.put("sheetTitle","工作周报");
			reportMap.put("data",data);
            //意见数据
            Map<String, Object> opinion = new HashMap<>();
            opinion.put("name", users.get(i).getUserName());
            opinion.put("startDate",startDate);
            opinion.put("endDate", endDate);
			opinion.put("deptName",users.get(i).getDeptName());
			opinion.put("projectLeaderName",users.get(i).getProjectLeaderName());
            opinion.put("sheetTitle","意见及建议");
            reportMap.put("opinion",opinion);
			reportList.add(reportMap);
		}
		return reportList;
	}

}
