package com.api.newtest.dianyong.workstatus.pojo;

public class StatusPush {
    private String order_number;
    private String status;
    private String principal_name;
    private String principal_phone;

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrincipal_name() {
        return principal_name;
    }

    public void setPrincipal_name(String principal_name) {
        this.principal_name = principal_name;
    }

    public String getPrincipal_phone() {
        return principal_phone;
    }

    public void setPrincipal_phone(String principal_phone) {
        this.principal_phone = principal_phone;
    }

    @Override
    public String toString() {
        return "StatusPush{" +
                "order_number='" + order_number + '\'' +
                ", status='" + status + '\'' +
                ", principal_name='" + principal_name + '\'' +
                ", principal_phone='" + principal_phone + '\'' +
                '}';
    }
}
