package com.api.test.kkl.pojo;

import java.util.List;

public class Kkl {
    private String orderNo;
    private String userName;
    private String userMobile;
    private String userProvince;
    private String userCity;
    private String userCounty;
    private String userStreet;
    private String userAddress;
    private String serviceType;
    private String warrantyType;
    private String shopId;
    private String brand;
    private String receiveDate;
    private String description;
    private String remarks;
    private Long status;
    private String issueBy; //   负责人
    private List<Item> items;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserCounty() {
        return userCounty;
    }

    public void setUserCounty(String userCounty) {
        this.userCounty = userCounty;
    }

    public String getUserStreet() {
        return userStreet;
    }

    public void setUserStreet(String userStreet) {
        this.userStreet = userStreet;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
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

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getIssueBy() {
        return issueBy;
    }

    public void setIssueBy(String issueBy) {
        this.issueBy = issueBy;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Kkl{" +
                ", orderNo='" + orderNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userProvince='" + userProvince + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userCounty='" + userCounty + '\'' +
                ", userStreet='" + userStreet + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", warrantyType='" + warrantyType + '\'' +
                ", shopId='" + shopId + '\'' +
                ", brand='" + brand + '\'' +
                ", receiveDate='" + receiveDate + '\'' +
                ", description='" + description + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                ", issueBy='" + issueBy + '\'' +
                ", items=" + items +
                '}';
    }
}
