package com.api.kdiniao.controller;

import com.api.kdiniao.electron.responsedata.customernumapply.RespApplyCustNumber;
import com.api.kdiniao.electron.responsedata.customernumpush.RespCustPush;
import com.api.kdiniao.electron.responsedata.ordermargin.ResponseMargin;
import com.api.kdiniao.electron.responsedata.eleorder.RespEleData;
import com.api.kdiniao.electron.service.ElectronService;
import com.api.kdiniao.instantquery.returndata.ResInstantData;
import com.api.kdiniao.kdutils.KDNiaoUtil;
import com.api.kdiniao.monitor.pojo.ResMonitorData;
import com.api.kdiniao.service.KdnService;
import com.api.kdiniao.subscribe.pojo.ResSubcriData;
import com.api.kdiniao.subscribe.service.KdnSubscrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/kdn")
public class ElectronController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired private ElectronService electronService;
    @Autowired private KdnSubscrService kdnSubscrService;
    @Autowired private KdnService kdnService;

    //  在途监控物流信息
    @GetMapping("/getMon")
    public ResMonitorData getMonitroNode(){
        ResMonitorData monitorNode = kdnService.getMonitorNode();
        logger.info("在途监控物流信息：[{}]", monitorNode);
        return monitorNode;
    }

    //  即时查询物流信息
    @GetMapping("/findInst")
    public ResInstantData getInstranNode(){
        ResInstantData instanNode = kdnService.getInstanNode();
        logger.info("即时查询物流信息：[{}]", instanNode);
        return instanNode;
    }

    //   预约取件接口
    @GetMapping("/getsub")
    public ResSubcriData getSubcri(){
        return kdnSubscrService.subGetOrder();
    }


    //   客户号推送
    @GetMapping("/custPush")
    public RespCustPush custPush(){
        RespCustPush custPush = electronService.custPush();
        logger.info("客户号推送返回参数：[{}]", custPush);
        return custPush;
    }

    //  客户号申请接口
    @GetMapping("/applycust")
    public RespApplyCustNumber applyCustNumber(){
        RespApplyCustNumber custNumber = electronService.applyCustNumber();
        logger.info("客户号申请返回参数：[{}]", custNumber);
        return custNumber;
    }

    //   单号余量查询
    @GetMapping("/findMargin")
    public ResponseMargin finMargin(){
        ResponseMargin margin = electronService.findMargin();
        logger.info("单号余量返回参数：[{}]", margin);
        return margin;
    }

    //  电子页面接口测试
    @GetMapping("/get")
    public RespEleData get(HttpServletRequest request){
        String ipAddress = KDNiaoUtil.getIpAddress(request);
        logger.info("ip地址：[{}]", ipAddress);
        RespEleData elereturnData = electronService.pushElectron();
        logger.info("电子页面返回参数：[{}]", elereturnData);
        return elereturnData;
    }
}
