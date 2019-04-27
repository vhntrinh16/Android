package com.example.testgknangcao;

public class MonhocModel {
    private int Id;
    private String TenMH;
    private String MaMH;
    private int Tinchi;
    private String Mota;


    public MonhocModel(int id, String tenMH, String maMH, int tinchi, String mota) {
        Id = id;
        TenMH = tenMH;
        MaMH = maMH;
        Tinchi = tinchi;
        Mota = mota;
    }

    public MonhocModel() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public int getTinchi() {
        return Tinchi;
    }

    public void setTinchi(int tinchi) {
        Tinchi = tinchi;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }
}
