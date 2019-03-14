package com.example.vuhoangnutrinh_1706020090;

public class UserContact {
    private String TênĐT;
    private String Mã;
    private String Giá;
    private String HovaTen;
    private String MaSv;
    private String Nganh;
    private String TenSP;
    private String MaSP;
    private String Gia;
    private String Mota;

    public String getHovaTen() {
        return HovaTen;
    }

    public void setHovaTen(String hovaTen) {
        HovaTen = hovaTen;
    }

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String maSv) {
        MaSv = maSv;
    }

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String nganh) {
        Nganh = nganh;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
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



    public String getTênĐT() {
        return TênĐT;
    }

    public void setTênĐT(String tênĐT) {
        TênĐT = tênĐT;
    }

    public String getMã() {
        return Mã;
    }

    public void setMã(String mã) {
        Mã = mã;
    }

    public String getGiá() {
        return Giá;
    }

    public void setGiá(String giá) {
        Giá = giá;
    }

    public UserContact(String tênĐT, String mã, String giá,
                       String hovaTen, String maSv, String nganh,
                       String tenSP, String maSP, String gia, String mota) {
        TênĐT = tênĐT;
        Mã = mã;
        Giá = giá;
        HovaTen = hovaTen;
        MaSv = maSv;
        Nganh = nganh;
        TenSP = tenSP;
        MaSP = maSP;
        Gia = gia;
        Mota = mota;
    }
}
