package com.api.kdiniao.electron.responsedata.eleorder;

import com.api.kdiniao.electron.pojo.ResponseParams;

import java.util.Date;

/**
 *   打印面单返回参数实体
 */
public class RespEleData extends ResponseParams {
    private String SignWaybillCode;  //  签回单单号
    private String UniquerRequestNumber;  //  唯一标识
    private String PrintTemplate;  //  面单打印模板内容(html格式)
    private Date EstimatedDeliveryTime;  //  订单预计到货时间yyyy-mm-dd
    private Integer SubCount;  //  子单数量
    private String SubOrders;  //  子单单号
    private String SubPrintTemplates;  //  子单模板内容(html格式)
    private String SignBillPrintTemplate;  //  签回单模板内容(html格式)
    private String ReceiverSafePhone;  //  收件人安全电话
    private String SenderSafePhone;  //  收件人安全电话
    private String DialPage;  //  拨号页面网址(转换成二维码可扫描拨号)
    private EleOrder Order;  //  订单信息

    public String getSignWaybillCode() {
        return SignWaybillCode;
    }

    public void setSignWaybillCode(String signWaybillCode) {
        SignWaybillCode = signWaybillCode;
    }


    public String getUniquerRequestNumber() {
        return UniquerRequestNumber;
    }

    public void setUniquerRequestNumber(String uniquerRequestNumber) {
        UniquerRequestNumber = uniquerRequestNumber;
    }

    public String getPrintTemplate() {
        return PrintTemplate;
    }

    public void setPrintTemplate(String printTemplate) {
        PrintTemplate = printTemplate;
    }

    public Date getEstimatedDeliveryTime() {
        return EstimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(Date estimatedDeliveryTime) {
        EstimatedDeliveryTime = estimatedDeliveryTime;
    }

    public Integer getSubCount() {
        return SubCount;
    }

    public void setSubCount(Integer subCount) {
        SubCount = subCount;
    }

    public String getSubOrders() {
        return SubOrders;
    }

    public void setSubOrders(String subOrders) {
        SubOrders = subOrders;
    }

    public String getSubPrintTemplates() {
        return SubPrintTemplates;
    }

    public void setSubPrintTemplates(String subPrintTemplates) {
        SubPrintTemplates = subPrintTemplates;
    }

    public String getSignBillPrintTemplate() {
        return SignBillPrintTemplate;
    }

    public void setSignBillPrintTemplate(String signBillPrintTemplate) {
        SignBillPrintTemplate = signBillPrintTemplate;
    }

    public String getReceiverSafePhone() {
        return ReceiverSafePhone;
    }

    public void setReceiverSafePhone(String receiverSafePhone) {
        ReceiverSafePhone = receiverSafePhone;
    }

    public String getSenderSafePhone() {
        return SenderSafePhone;
    }

    public void setSenderSafePhone(String senderSafePhone) {
        SenderSafePhone = senderSafePhone;
    }

    public String getDialPage() {
        return DialPage;
    }

    public void setDialPage(String dialPage) {
        DialPage = dialPage;
    }

    public EleOrder getOrder() {
        return Order;
    }

    public void setOrder(EleOrder order) {
        Order = order;
    }

    @Override
    public String toString() {
        return "ElereturnData{" +
                ", SignWaybillCode='" + SignWaybillCode + '\'' +
                ", UniquerRequestNumber='" + UniquerRequestNumber + '\'' +
                ", PrintTemplate='" + PrintTemplate + '\'' +
                ", EstimatedDeliveryTime=" + EstimatedDeliveryTime +
                ", SubCount=" + SubCount +
                ", SubOrders='" + SubOrders + '\'' +
                ", SubPrintTemplates='" + SubPrintTemplates + '\'' +
                ", SignBillPrintTemplate='" + SignBillPrintTemplate + '\'' +
                ", ReceiverSafePhone='" + ReceiverSafePhone + '\'' +
                ", SenderSafePhone='" + SenderSafePhone + '\'' +
                ", DialPage='" + DialPage + '\'' +
                ", Order=" + Order +
                '}';
    }
}
