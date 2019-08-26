package com.api.newtest.realizeapi.applyparts.pojo;


import java.util.List;

public class ApplyParts {
    private String order_number;  //  工单单据编号
    private String remark;  //  备注
    private Integer need_return;  //  是否需要返回旧配件：（ 0需要、1不需要 ）
    private String return_address; // 旧配件需要返回的地址：（省-市-区-镇-详细地址）不返回旧配件不需要填
    private String express_company;  //  快递公司
    private String express_order;  //  快递单号
    private Integer payment;  //  邮费付款方式：（0厂家包邮、1买家自付、2师傅垫付）
    private String time;  //  发货时间
    private List<Parts> parts;  //  申请的备件信息和审核状态

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getNeed_return() {
        return need_return;
    }

    public void setNeed_return(Integer need_return) {
        this.need_return = need_return;
    }

    public String getReturn_address() {
        return return_address;
    }

    public void setReturn_address(String return_address) {
        this.return_address = return_address;
    }

    public String getExpress_company() {
        return express_company;
    }

    public void setExpress_company(String express_company) {
        this.express_company = express_company;
    }

    public String getExpress_order() {
        return express_order;
    }

    public void setExpress_order(String express_order) {
        this.express_order = express_order;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "ApplyParts{" +
                "order_number='" + order_number + '\'' +
                ", remark='" + remark + '\'' +
                ", need_return=" + need_return +
                ", return_address='" + return_address + '\'' +
                ", express_company='" + express_company + '\'' +
                ", express_order='" + express_order + '\'' +
                ", payment=" + payment +
                ", time='" + time + '\'' +
                ", parts=" + parts +
                '}';
    }
}
