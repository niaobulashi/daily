package com.adtec.daily.service.daily.impl;

import com.adtec.daily.bean.daily.OverWork;
import com.adtec.daily.bean.daily.OverWorkExample;
import com.adtec.daily.dao.daily.OverWorkMapper;
import com.adtec.daily.service.daily.OverWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Description: 加班时间处理实现类
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright:
 */
@Service
public class OverWorkServiceImpl implements OverWorkService {
	@Autowired
    OverWorkMapper overWorkMapper;

	/**
	 * 查询所有加班数据
	 */
    @Override
	public List<OverWork> getAll(OverWorkExample example) {
		return overWorkMapper.selectByExample(example);
	}

	/**
	 * 加班数据保存
	 */
    @Override
	public void saveOverWork(OverWork overWork) {
        overWorkMapper.insertSelective(overWork);
	}

    /**
     * 更新加班数据
     */
    @Override
    public void updateByDailyId(OverWork overWork) {
        overWorkMapper.updateByPrimaryKeySelective(overWork);
    }

	/**
	 * 根据用户id及上班日期查询加班明细列表
	 */
    @Override
	public List<OverWork> selectOverWorkDetailListByUserIdAndWorkDate(int id ,String userId, String approvalStatus,String startDate, String endDate) {
		return overWorkMapper.selectOverWorkDetailListByUserIdAndWorkDate(id,userId,approvalStatus,startDate,endDate);
	}

	/**
	 * 根据用户id及上班日期查询加班总时长
	 */
    @Override
	public OverWork selectOverWorkByUserIdAndWorkDate(String userId, String startDate, String endDate) {
		return overWorkMapper.selectOverWorkByUserIdAndWorkDate(userId,startDate,endDate);
	}

	/**
	 * 按照主键id查询加班信息
	 */
	@Override
	public OverWork getOverWork(int id) {
		OverWork overWork = overWorkMapper.selectInfoByPrimaryKey(id);
		return overWork;
	}

	/**
	 * 加班信息更新
	 */
	@Override
	public void updateOverWork(OverWork overWork) {
		overWorkMapper.updateByPrimaryKeySelective(overWork);
	}

    /**
     * 加班信息更新
     */
    @Override
    public void updateOverWorkByDailyId(OverWork overWork, OverWorkExample example) {
        overWorkMapper.updateByExampleSelective(overWork, example);
    }
}
