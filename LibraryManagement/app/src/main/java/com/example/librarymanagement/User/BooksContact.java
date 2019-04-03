package com.example.librarymanagement.User;

import com.example.librarymanagement.BooksList;

import java.io.Serializable;

public class BooksContact implements Serializable {
    public BooksContact(){

    }
    private String tenSach;
    private String maSach;
    private String loaiSach;
    private String NXB;
    private String SoLuong;
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String soLuong) {
        SoLuong = soLuong;
    }

    public BooksContact(int ID, String tenSach, String maSach, String loaiSach, String NXB, String soLuong) {
        this.Id = ID;
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.loaiSach = loaiSach;
        this.NXB = NXB;
        SoLuong = soLuong;
    }
}
