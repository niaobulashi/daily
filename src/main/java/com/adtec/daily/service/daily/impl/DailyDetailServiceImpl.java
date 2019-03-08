package com.adtec.daily.service.daily.impl;

import com.adtec.daily.bean.daily.DailyDetail;
import com.adtec.daily.dao.daily.DailyDetailMapper;
import com.adtec.daily.service.daily.DailyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @version V1.0
 * @Description: 日报详情内容实现类
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright:
 */
@Service
public class DailyDetailServiceImpl implements DailyDetailService {

	@Autowired
    DailyDetailMapper dailyDetailMapper;

	/**
	 * 查询日报详细列表
	 */
    @Override
	public List<DailyDetail> getDailyList(DailyDetail record) {
        List<DailyDetail> dailyDetaillist = dailyDetailMapper.selectDailyDetailByDailyId(record);
		return dailyDetaillist;
	}

    /**
     * 保存日报详情
     */
    @Override
	public void saveDailyDetail(DailyDetail dailyDetail) {
	    dailyDetailMapper.insertSelective(dailyDetail);
    }

    /**
     * 删除日报详情
     */
    @Override
    public void deleteDailyDetail(String id) {
        dailyDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键查询日报内容
     */
    @Override
    public DailyDetail getDailyDetailInfo(String dailyDetailId) {
        return dailyDetailMapper.selectByPrimaryKey(dailyDetailId);
    }

    /**
     * 角色更新
     */
    @Override
    public void updateDailyDetail(DailyDetail dailyDetail) {
        dailyDetailMapper.updateByPrimaryKeySelective(dailyDetail);
    }

    /**
     * 查询某用户的未完成日报任务
     */
    @Override
    public List<DailyDetail> getDailyDetailUnDone(String userId) {
        return dailyDetailMapper.selectDailyDetailUnDone(userId);
    }

    @Override
    public List<DailyDetail> getDailyDetailByUserId(String userId, String preFinishDate, String completeProgress) {
        String preFinishDateStart = null;
        String preFinishDateEnd = null;
        if (!"".equals(preFinishDate) && preFinishDate != null) {
            String[] preFinishDates = preFinishDate.split(" - ");
            preFinishDateStart = preFinishDates[0].trim();
            preFinishDateEnd = preFinishDates[1].trim();
        }
        List<DailyDetail> dailyDetails = dailyDetailMapper.selectDailyDetailByUserId(userId, preFinishDateStart, preFinishDateEnd, completeProgress);

        return dailyDetails;
    }

    /**
     * 点击修改，查询日报具体信息
     */
    @Override
    public DailyDetail getDailyDetailByDailyDetailId(String dailyDetailId) {
        return dailyDetailMapper.selectDailyDetailByDailyDetailId(dailyDetailId);
    }
}
