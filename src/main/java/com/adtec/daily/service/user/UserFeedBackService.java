package com.adtec.daily.service.user;

import com.adtec.daily.bean.user.UserFeedBack;
import com.adtec.daily.bean.user.UserFeedBackExample;

import java.util.List;

/**
 * @version V1.0
 * @Description: 意见反馈
 * @author: 胡浪
 * @date: 2018/4/25
 * @Copyright:
 */
public interface UserFeedBackService {

    /**
     * 意见反馈
     *
     * @param userFeedBack
     */
    void putFeedBack(UserFeedBack userFeedBack);

    /**
     * 查询意见反馈信息
     */
    UserFeedBack queryUserFeedBack(String fbUser);

    /**
     * 获取反馈信息列表
     */
    List<UserFeedBack> getUserFeedBackList(final String fbDate, final String fbType, final String resultFlag);

    /**
     * 忽略反馈信息
     * @param fdId
     * @return
     */
    boolean ignoreFeedback(int fdId);

    /**
     * 处理反馈信息
     * @param fdId
     * @return
     */
    boolean fixedIssueFeedback(int fdId);
}
