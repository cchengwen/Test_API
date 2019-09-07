package com.api.kdiniao.service;

import com.api.kdiniao.instantquery.returndata.ResInstantData;
import com.api.kdiniao.monitor.pojo.ResMonitorData;

public interface KdnService {

    /**
     *   即时查询物流信息
     * @return
     */
    ResInstantData getInstanNode();

    /**
     *   在途监控物流信息
     * @return
     */
    ResMonitorData getMonitorNode();
}
