package com.example.vuhoangnutrinh_1706020090;

public class UserContact {
   private String tenDT;
   private String maDT;
   private String Gia;
   private String Mota;

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public UserContact(String tenDT, String maDT, String gia, String mota) {
        this.tenDT = tenDT;
        this.maDT = maDT;
        Gia = gia;
        Mota = mota;
    }
}
