package com.adtec.daily.controller.demand;

import com.adtec.daily.bean.demand.DemandDetail;
import com.adtec.daily.service.demand.DemandDetailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 处理项目CRUD请求
 */
@Controller
public class DemandDetailController {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    DemandDetailService demandDetailService;

    /**
     * 检查项目编号是否可用
     *
     * @param demandDetail
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/demandDetail/getDemandDetail/{demandId}", method = RequestMethod.GET)
    public String getDemandDetail(DemandDetail demandDetail, HttpServletRequest request) {
        System.out.println("请求体中的值：" + request.getParameter("demandId"));
        demandDetail.setDemandIds("DT00001");
        List<DemandDetail> tddList = demandDetailService.getDemandDetail(demandDetail);
        return tddList.toString();
    }

}
