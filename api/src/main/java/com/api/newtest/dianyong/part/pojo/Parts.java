package com.api.newtest.dianyong.part.pojo;

public class Parts {
    private String part_name;
    private Integer quantity;
    private String annex;

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "part_name='" + part_name + '\'' +
                ", quantity=" + quantity +
                ", annex='" + annex + '\'' +
                '}';
    }
}
