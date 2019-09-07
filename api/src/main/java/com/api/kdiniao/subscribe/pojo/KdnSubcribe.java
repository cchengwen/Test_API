package com.api.kdiniao.subscribe.pojo;

import com.api.kdiniao.electron.pojo.Commoditys;
import com.api.kdiniao.electron.pojo.eleorder.Receiver;
import com.api.kdiniao.electron.pojo.eleorder.Sender;

import java.util.List;

/**
 *   预约取件实体
 */
public class KdnSubcribe {
    private String WarehouseID;  //  仓库标识
    private String WarehouseAddress;  //  仓库地址
    private String CallBack;  //   商户标识
    private String MemberID;  //  会员标识
    private String ShipperCode;  //  快递公司编码
    private String LogisticCode;  //  快递单号
    private String IsNotice;  //  发货方式：0-上门揽件，1-网点自寄，默认为1
    private String PackingType;  //  包装类型：包装类型(快运字段)默认为 0； 0- 纸 1- 纤 2- 木 3- 托膜 4- 木托 99-其他
    private String IsReturnSignBill;  //  签收回单：1-需要，0-不需要,默认为0
    private String DeliveryMethod;  //  送货方式：0-自提，1-送货上门（不含上楼）2-送货上楼。（适用于快运类型订单，物流公司可能会收取费用），默认为0
    private String OrderCode;  //  订单编号
    private String MonthCode;  //  月结编码
    private Integer PayType;  //  邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付
    private Integer ExpType;  //  快递类型：1-标准快件
    private Double Cost;  //  寄件费（运费）
    private Double OtherCost;  //  其他费用
    private Receiver Receiver;  //  收件人信息
    private Sender Sender;  //  发件人信息
    private String StartDate;  //  上门取货时间段:"yyyy-MM-dd HH:mm:ss"格式化，本文中所有时间格式相同
    private String EndDate;  //
    private Double Weight;  //  物品总重量kg
    private Integer Quantity;  //  件数/包裹数
    private Double Volume;     //物品总体积m3
    private String Remark;  //  备注
    private List<Commoditys> Commodity; //  商品信息集合

    public String getWarehouseID() {
        return WarehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        WarehouseID = warehouseID;
    }

    public String getWarehouseAddress() {
        return WarehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        WarehouseAddress = warehouseAddress;
    }

    public String getCallBack() {
        return CallBack;
    }

    public void setCallBack(String callBack) {
        CallBack = callBack;
    }

    public String getMemberID() {
        return MemberID;
    }

    public void setMemberID(String memberID) {
        MemberID = memberID;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    public String getIsNotice() {
        return IsNotice;
    }

    public void setIsNotice(String isNotice) {
        IsNotice = isNotice;
    }

    public String getPackingType() {
        return PackingType;
    }

    public void setPackingType(String packingType) {
        PackingType = packingType;
    }

    public String getIsReturnSignBill() {
        return IsReturnSignBill;
    }

    public void setIsReturnSignBill(String isReturnSignBill) {
        IsReturnSignBill = isReturnSignBill;
    }

    public String getDeliveryMethod() {
        return DeliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        DeliveryMethod = deliveryMethod;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getMonthCode() {
        return MonthCode;
    }

    public void setMonthCode(String monthCode) {
        MonthCode = monthCode;
    }

    public Integer getPayType() {
        return PayType;
    }

    public void setPayType(Integer payType) {
        PayType = payType;
    }

    public Integer getExpType() {
        return ExpType;
    }

    public void setExpType(Integer expType) {
        ExpType = expType;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }

    public Double getOtherCost() {
        return OtherCost;
    }

    public void setOtherCost(Double otherCost) {
        OtherCost = otherCost;
    }

    public com.api.kdiniao.electron.pojo.eleorder.Receiver getReceiver() {
        return Receiver;
    }

    public void setReceiver(com.api.kdiniao.electron.pojo.eleorder.Receiver receiver) {
        Receiver = receiver;
    }

    public com.api.kdiniao.electron.pojo.eleorder.Sender getSender() {
        return Sender;
    }

    public void setSender(com.api.kdiniao.electron.pojo.eleorder.Sender sender) {
        Sender = sender;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public Double getWeight() {
        return Weight;
    }

    public void setWeight(Double weight) {
        Weight = weight;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Double getVolume() {
        return Volume;
    }

    public void setVolume(Double volume) {
        Volume = volume;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public List<Commoditys> getCommodity() {
        return Commodity;
    }

    public void setCommodity(List<Commoditys> commodity) {
        Commodity = commodity;
    }

    @Override
    public String toString() {
        return "KdnSubcribe{" +
                "WarehouseID='" + WarehouseID + '\'' +
                ", WarehouseAddress='" + WarehouseAddress + '\'' +
                ", CallBack='" + CallBack + '\'' +
                ", MemberID='" + MemberID + '\'' +
                ", ShipperCode='" + ShipperCode + '\'' +
                ", LogisticCode='" + LogisticCode + '\'' +
                ", IsNotice='" + IsNotice + '\'' +
                ", PackingType='" + PackingType + '\'' +
                ", IsReturnSignBill='" + IsReturnSignBill + '\'' +
                ", DeliveryMethod='" + DeliveryMethod + '\'' +
                ", OrderCode='" + OrderCode + '\'' +
                ", MonthCode='" + MonthCode + '\'' +
                ", PayType='" + PayType + '\'' +
                ", ExpType='" + ExpType + '\'' +
                ", Cost='" + Cost + '\'' +
                ", OtherCost='" + OtherCost + '\'' +
                ", Receiver=" + Receiver +
                ", Sender=" + Sender +
                ", StartDate='" + StartDate + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", Weight=" + Weight +
                ", Quantity=" + Quantity +
                ", Volume=" + Volume +
                ", Remark='" + Remark + '\'' +
                ", Commodity=" + Commodity +
                '}';
    }
}
