package com.api.kdiniao.electron.pojo.customernumapply;

/**
 *   客户号申请请求参数实体
 */
public class ApplyCustNumber {
    private String ShipperCode;  //  快递公司编码
    private String StationCode;  //  网点编码
    private String StationName;  //  网点名称
    private String ApplyID;  //  申请ID(用户记录在快递公司的标识)
    private String Company;  //  	公司名称
    private String Name;  //   联系人
    private String Tel;  //  电话
    private String Mobile;  //   手机
    private String ProvinceName;  //  省份
    private String ProivnceCode;  //   省份编码
    private String CityName;  //   城市
    private String CityCode;  //  城市编码
    private String ExpAreaName;  //  区县
    private String ExpAreaCode;  //  区县编码
    private String Address;  //  	详细地址

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
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

    public String getApplyID() {
        return ApplyID;
    }

    public void setApplyID(String applyID) {
        ApplyID = applyID;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }

    public String getProivnceCode() {
        return ProivnceCode;
    }

    public void setProivnceCode(String proivnceCode) {
        ProivnceCode = proivnceCode;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public String getExpAreaName() {
        return ExpAreaName;
    }

    public void setExpAreaName(String expAreaName) {
        ExpAreaName = expAreaName;
    }

    public String getExpAreaCode() {
        return ExpAreaCode;
    }

    public void setExpAreaCode(String expAreaCode) {
        ExpAreaCode = expAreaCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "ApplyCustNumber{" +
                "ShipperCode='" + ShipperCode + '\'' +
                ", StationCode='" + StationCode + '\'' +
                ", StationName='" + StationName + '\'' +
                ", ApplyID='" + ApplyID + '\'' +
                ", Company='" + Company + '\'' +
                ", Name='" + Name + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", ProvinceName='" + ProvinceName + '\'' +
                ", ProivnceCode='" + ProivnceCode + '\'' +
                ", CityName='" + CityName + '\'' +
                ", CityCode='" + CityCode + '\'' +
                ", ExpAreaName='" + ExpAreaName + '\'' +
                ", ExpAreaCode='" + ExpAreaCode + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
