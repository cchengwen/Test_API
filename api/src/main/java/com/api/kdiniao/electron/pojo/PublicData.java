package com.api.kdiniao.electron.pojo;

/**
 *   发/收件人（公司）信息
 */
public class PublicData {
    private String Company;  //  收件人公司
    private String Name;  //  收件人
    private String Tel;  //  电话与手机，必填一个
    private String Mobile;  //  电话与手机，必填一个
    private String PostCode;  //  收件人邮编
    private String ProvinceName;
    private String CityName;
    private String ExpAreaName;
    private String Address;

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

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getExpAreaName() {
        return ExpAreaName;
    }

    public void setExpAreaName(String expAreaName) {
        ExpAreaName = expAreaName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "Company='" + Company + '\'' +
                ", Name='" + Name + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", PostCode='" + PostCode + '\'' +
                ", ProvinceName='" + ProvinceName + '\'' +
                ", CityName='" + CityName + '\'' +
                ", ExpAreaName='" + ExpAreaName + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
