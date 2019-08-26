package com.api.test.kkl.pojo;

public class Item {
    private String productCode;
    private String productName;
    private String productSpec;
    private String className;
    private Integer qty;
    private String serviceType;
    private String warrantyType;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(String warrantyType) {
        this.warrantyType = warrantyType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productSpec='" + productSpec + '\'' +
                ", className='" + className + '\'' +
                ", qty=" + qty +
                ", serviceType='" + serviceType + '\'' +
                ", warrantyType='" + warrantyType + '\'' +
                '}';
    }
}
