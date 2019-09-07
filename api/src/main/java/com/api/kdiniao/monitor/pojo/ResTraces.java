package com.api.kdiniao.monitor.pojo;

import com.api.kdiniao.instantquery.returndata.Traces;

public class ResTraces extends Traces {
    private String Location;  //  当前城市
    private String Action;  //  当前状态

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    @Override
    public String toString() {
        return "ResTraces{" +
                "Location='" + Location + '\'' +
                ", Action='" + Action + '\'' +
                '}';
    }
}
