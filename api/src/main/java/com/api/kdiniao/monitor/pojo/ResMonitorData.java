package com.api.kdiniao.monitor.pojo;

import com.api.kdiniao.publicpojo.ResLogistic;

import java.util.List;

/**
 *  在途监控实体
 */
public class ResMonitorData extends ResLogistic {
    private String StateEx;  //  增值物流状态
    private String Location;  //  增值所在城市
    private List<ResTraces> Traces;  //  物流节点信息

    public String getStateEx() {
        return StateEx;
    }

    public void setStateEx(String stateEx) {
        StateEx = stateEx;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public List<ResTraces> getTraces() {
        return Traces;
    }

    public void setTraces(List<ResTraces> traces) {
        Traces = traces;
    }

    @Override
    public String toString() {
        return "ResMonitorData{" +
                "StateEx='" + StateEx + '\'' +
                ", Location='" + Location + '\'' +
                ", Traces=" + Traces +
                '}';
    }
}
