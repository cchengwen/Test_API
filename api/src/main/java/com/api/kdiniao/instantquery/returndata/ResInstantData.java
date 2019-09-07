package com.api.kdiniao.instantquery.returndata;

import com.api.kdiniao.publicpojo.ResLogistic;

import java.util.List;

/**
 *   即时查询返回参数实体
 */
public class ResInstantData extends ResLogistic {
    private List<Traces> Traces;  //  物流节点信息

    public List<Traces> getTraces() {
        return Traces;
    }

    public void setTraces(List<Traces> traces) {
        Traces = traces;
    }

    @Override
    public String toString() {
        return "ResInstantData{" +
                "Traces=" + Traces +
                '}';
    }
}
