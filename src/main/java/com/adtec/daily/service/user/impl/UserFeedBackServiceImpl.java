package com.adtec.daily.service.user.impl;

import com.adtec.daily.bean.daily.DailyDetail;
import com.adtec.daily.bean.user.UserFeedBack;
import com.adtec.daily.bean.user.UserFeedBackExample;
import com.adtec.daily.dao.user.UserFeedBackMapper;
import com.adtec.daily.service.user.UserFeedBackService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/4/25
 * @Copyright:
 */
@Service
public class UserFeedBackServiceImpl implements UserFeedBackService {

    @Autowired
    UserFeedBackMapper userFeedBackMapper;

    /**
     * 意见反馈
     */
    @Override
    public void putFeedBack(UserFeedBack userFeedBack) {
        userFeedBackMapper.insertSelective(userFeedBack);
    }

    /**
     * 查询意见反馈信息
     */
    @Override
    public UserFeedBack queryUserFeedBack(String fbUser) {
        UserFeedBack userFeedBack = userFeedBackMapper.selectBySessionIdAndfbIdMax(fbUser);
        return userFeedBack;
    }

    @Override
    public List<UserFeedBack> getUserFeedBackList(final String fbDate, final String fbType, final String resultFlag) {
        String feedbackDateStart = null;
        String feedbackDateEnd = null;
        if (StringUtils.isNotBlank(fbDate)) {
            String[] feedbackDates = fbDate.split(" - ");
            feedbackDateStart = feedbackDates[0].trim();
            feedbackDateEnd = feedbackDates[1].trim();
        }

        List<UserFeedBack> userFeedBackList = userFeedBackMapper.selectFeedBackList(fbType, resultFlag, feedbackDateStart, feedbackDateEnd);

        return userFeedBackList;
    }

    @Override
    public boolean ignoreFeedback(int fdId) {
        userFeedBackMapper.updateResultFlagById(fdId, "2");
        return true;
    }

    @Override
    public boolean fixedIssueFeedback(int fdId) {
        userFeedBackMapper.updateResultFlagById(fdId, "1");
        return true;
    }
}
