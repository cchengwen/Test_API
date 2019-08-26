package com.api.test.shenzhou.res;

import java.util.List;

public class Datas {
    List<DataList> data_list;

    public List<DataList> getData_list() {
        return data_list;
    }

    public void setData_list(List<DataList> data_list) {
        this.data_list = data_list;
    }

    @Override
    public String toString() {
        return "Datas{" +
                "data_list=" + data_list +
                '}';
    }
}
