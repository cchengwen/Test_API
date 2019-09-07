package com.api.kdiniao.electron.pojo.eleorder;

import com.api.kdiniao.electron.pojo.Commoditys;

import java.util.Date;
import java.util.List;

/**
 *   电子面单参数实体
 */
public class RequestData {
    private String MemberID;
    private String CustomerName;
    private String CustomerPwd;
    private String SendSite;
    private String SendStaff;
    private String MonthCode;
    private String CustomArea;
    private String WareHouseID;  //  发货仓编码
    private Integer TransType;  //  运输方式 1-	陆运 2-	空运 不填默认为1
    private String ShipperCode;  //  快递公司编码
    private String LogisticCode;  //  快递单号(仅宅急送可用)
    private String ThrOrderCode;
    private String OrderCode;  //  订单编号(自定义，不可重复)
    private Integer PayType;  //  邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付(仅SF支持)
    private Integer ExpType;  //   快递类型：1-标准快件
    private Integer IsReturnSignBill;  //  是否要求签回单 1-	要求 0-不要求
    private String OperateRequire;  //  签回单操作要求(如：签名、盖章、身份证复印件等)
    private Double Cost;  //  快递运费
    private Double OtherCost;  //  其他费用
    private com.api.kdiniao.electron.pojo.eleorder.Receiver Receiver;  //  收件人信息
    private com.api.kdiniao.electron.pojo.eleorder.Sender Sender;  //  发件人信息
    private Integer IsNotice;  //  是否通知快递员上门揽件 0-	通知 1-	不通知 不填则默认为1
    private Date StartDate;
    private Date EndDate;
    private Double Weight;  //  包裹总重量kg
    private Integer Quantity;  //  包裹数(最多支持30件) 一个包裹对应一个运单号
    private Double Volume;
    private String Remark;
    private String IsReturnPrintTemplate;  //  返回电子面单模板：0-不需要；1-需要
    private List<Commoditys> Commodity;  //  商品信息集合
    private com.api.kdiniao.electron.pojo.AddService AddService;  //  增值服务

    public String getMemberID() {
        return MemberID;
    }

    public void setMemberID(String memberID) {
        MemberID = memberID;
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

    public String getSendSite() {
        return SendSite;
    }

    public void setSendSite(String sendSite) {
        SendSite = sendSite;
    }

    public String getSendStaff() {
        return SendStaff;
    }

    public void setSendStaff(String sendStaff) {
        SendStaff = sendStaff;
    }

    public String getMonthCode() {
        return MonthCode;
    }

    public void setMonthCode(String monthCode) {
        MonthCode = monthCode;
    }

    public String getCustomArea() {
        return CustomArea;
    }

    public void setCustomArea(String customArea) {
        CustomArea = customArea;
    }

    public String getWareHouseID() {
        return WareHouseID;
    }

    public void setWareHouseID(String wareHouseID) {
        WareHouseID = wareHouseID;
    }

    public Integer getTransType() {
        return TransType;
    }

    public void setTransType(Integer transType) {
        TransType = transType;
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

    public String getThrOrderCode() {
        return ThrOrderCode;
    }

    public void setThrOrderCode(String thrOrderCode) {
        ThrOrderCode = thrOrderCode;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
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

    public Integer getIsReturnSignBill() {
        return IsReturnSignBill;
    }

    public void setIsReturnSignBill(Integer isReturnSignBill) {
        IsReturnSignBill = isReturnSignBill;
    }

    public String getOperateRequire() {
        return OperateRequire;
    }

    public void setOperateRequire(String operateRequire) {
        OperateRequire = operateRequire;
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

    public Integer getIsNotice() {
        return IsNotice;
    }

    public void setIsNotice(Integer isNotice) {
        IsNotice = isNotice;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
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

    public String getIsReturnPrintTemplate() {
        return IsReturnPrintTemplate;
    }

    public void setIsReturnPrintTemplate(String isReturnPrintTemplate) {
        IsReturnPrintTemplate = isReturnPrintTemplate;
    }

    public List<com.api.kdiniao.electron.pojo.Commoditys> getCommodity() {
        return Commodity;
    }

    public void setCommodity(List<com.api.kdiniao.electron.pojo.Commoditys> commoditys) {
        Commodity = commoditys;
    }

    public com.api.kdiniao.electron.pojo.AddService getAddService() {
        return AddService;
    }

    public void setAddService(com.api.kdiniao.electron.pojo.AddService addService) {
        AddService = addService;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "MemberID='" + MemberID + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerPwd='" + CustomerPwd + '\'' +
                ", SendSite='" + SendSite + '\'' +
                ", SendStaff='" + SendStaff + '\'' +
                ", MonthCode='" + MonthCode + '\'' +
                ", CustomArea='" + CustomArea + '\'' +
                ", WareHouseID='" + WareHouseID + '\'' +
                ", TransType=" + TransType +
                ", ShipperCode='" + ShipperCode + '\'' +
                ", LogisticCode='" + LogisticCode + '\'' +
                ", ThrOrderCode='" + ThrOrderCode + '\'' +
                ", OrderCode='" + OrderCode + '\'' +
                ", PayType=" + PayType +
                ", ExpType=" + ExpType +
                ", IsReturnSignBill=" + IsReturnSignBill +
                ", OperateRequire='" + OperateRequire + '\'' +
                ", Cost=" + Cost +
                ", OtherCost=" + OtherCost +
                ", Receiver=" + Receiver +
                ", Sender=" + Sender +
                ", IsNotice=" + IsNotice +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", Weight=" + Weight +
                ", Quantity=" + Quantity +
                ", Volume=" + Volume +
                ", Remark='" + Remark + '\'' +
                ", IsReturnPrintTemplate='" + IsReturnPrintTemplate + '\'' +
                ", Commodity=" + Commodity +
                ", AddService=" + AddService +
                '}';
    }
}
