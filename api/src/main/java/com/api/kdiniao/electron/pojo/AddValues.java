package com.api.kdiniao.electron.pojo;

/**
 *   增值实体
 */
public class AddValues {
    private String Name;  //  增值服务名称 (数组形式，可以有多个增值服务)
    private String Value;  //  增值服务值
    private String CustomerID;  //  客户标识（选填）

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    @Override
    public String toString() {
        return "AddValues{" +
                "Name='" + Name + '\'' +
                ", Value='" + Value + '\'' +
                ", CustomerID='" + CustomerID + '\'' +
                '}';
    }
}
