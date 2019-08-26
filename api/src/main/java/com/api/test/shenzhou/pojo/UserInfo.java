package com.api.test.shenzhou.pojo;

public class UserInfo {
    private String contact_type;
    private String contact_number;
    private String contact_name;
    private String areas;
    private String area_detail;

    public String getContact_type() {
        return contact_type;
    }

    public void setContact_type(String contact_type) {
        this.contact_type = contact_type;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getArea_detail() {
        return area_detail;
    }

    public void setArea_detail(String area_detail) {
        this.area_detail = area_detail;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "contact_type='" + contact_type + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", contact_name='" + contact_name + '\'' +
                ", areas='" + areas + '\'' +
                ", area_detail='" + area_detail + '\'' +
                '}';
    }
}
