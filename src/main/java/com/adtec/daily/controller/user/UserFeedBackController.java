package com.adtec.daily.controller.user;

import com.adtec.daily.bean.common.Message;
import com.adtec.daily.bean.common.Msg;
import com.adtec.daily.bean.user.UserFeedBack;
import com.adtec.daily.bean.user.UserFeedBackExample;
import com.adtec.daily.service.user.UserFeedBackService;
import com.adtec.daily.util.Constants;
import com.github.pagehelper.Constant;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Description: 意见反馈
 * @author: 胡浪
 * @date: 2018/4/25
 * @Copyright:
 */
@Controller
public class UserFeedBackController {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    UserFeedBackService userFeedBackService;

    /**
     * 意见反馈
     * @param userFeedBack
     * @param result
     * @return
     */
    @RequestMapping(value = "/feedBack/putFeedBack", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveFeedBack(@Valid UserFeedBack userFeedBack, BindingResult result) {
        //查询意见反馈表是否存在该用户数据，如果存在，需要间隔5分钟再发，序号最大的
        UserFeedBack userFeedBack1 = userFeedBackService.queryUserFeedBack(userFeedBack.getFbUser());
        if (userFeedBack1 != null) {
            //若存在，则判断两者之间之间间隔
            double minute = ((double)(new Date().getTime()-userFeedBack1.getCreateDate().getTime()))/(60*1000);
            long m = (long) Math.ceil(minute);
            logger.info("分钟时间间隔：" + m);
            if (m < 5) {
                return Msg.intervalLsFive();
            }
        }
        userFeedBack.setFbUser(userFeedBack.getFbUser());
        userFeedBack.setFbType(userFeedBack.getFbType());
        userFeedBack.setFbInfo(userFeedBack.getFbInfo());
        userFeedBack.setFbEmail(userFeedBack.getFbEmail());
        userFeedBack.setCreateDate(new Date());
        userFeedBack.setResultFlag(Constants.RESULT_FLAG_UNCHECK);
        userFeedBackService.putFeedBack(userFeedBack);
        return Msg.success();
    }

    /**
     * 反馈列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/feedBack/getFeedbackList", method = RequestMethod.GET)
    public Message getFeedbackList(@RequestParam("page")int page, @RequestParam("limit")int limit, @RequestParam("fbDate") String fbDate, @RequestParam("fbType") String fbType, @RequestParam("resultFlag")String resultFlag) {
        PageHelper.startPage(page, limit);
        List<UserFeedBack> feedBackList = userFeedBackService.getUserFeedBackList(fbDate, fbType, resultFlag);
        for(UserFeedBack feedBack : feedBackList){
            if ("100001".equals(feedBack.getFbType())) {
                feedBack.setFbType("新需求");
            } else if ("100002".equals(feedBack.getFbType())) {
                feedBack.setFbType("功能意见");
            } else if ("100003".equals(feedBack.getFbType())) {
                feedBack.setFbType("界面意见");
            } else if ("100004".equals(feedBack.getFbType())) {
                feedBack.setFbType("操作意见");
            } else if ("100005".equals(feedBack.getFbType())) {
                feedBack.setFbType("其他意见");
            }
        }
        return Message.success().add(feedBackList);
    }

    /**
     * 忽略当前反馈信息
     */
    @ResponseBody
    @RequestMapping(value = "/feedBack/ignoreFeedback", method = RequestMethod.GET)
    public Message ignoreFeedback(@RequestParam("fdId")int fdId) {
        boolean isIgnoreSuccess = userFeedBackService.ignoreFeedback(fdId);
        if (isIgnoreSuccess) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }

    /**
     * 忽略当前反馈信息
     */
    @ResponseBody
    @RequestMapping(value = "/feedBack/fixedIssueFeedback", method = RequestMethod.GET)
    public Message fixedIssueFeedback(@RequestParam("fdId")int fdId) {
        boolean isIgnoreSuccess = userFeedBackService.fixedIssueFeedback(fdId);
        if (isIgnoreSuccess) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }
}
