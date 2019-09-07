package com.api.kdiniao.electron.pojo.ordermargin;

/**
 *   余量请求参数实体
 */
public class RequestMargin {
    private String ShipperCode;   //  快递公司编码
    private String CustomerName;   //  	电子面单客户号
    private String CustomerPwd;   //  电子面单密码
    private String StationCode;   //  网点编码
    private String StationName;   //  网点名称

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerPwd() {
        return CustomerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        CustomerPwd = customerPwd;
    }

    public String getStationCode() {
        return StationCode;
    }

    public void setStationCode(String stationCode) {
        StationCode = stationCode;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    @Override
    public String toString() {
        return "RequstMargin{" +
                "ShipperCode='" + ShipperCode + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerPwd='" + CustomerPwd + '\'' +
                ", StationCode='" + StationCode + '\'' +
                ", StationName='" + StationName + '\'' +
                '}';
    }
}
