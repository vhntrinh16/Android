package com.example.librarymanagement.User;

import android.widget.TimePicker;

import com.example.librarymanagement.BooksList;
import com.example.librarymanagement.CreateVote_VoteList;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

public class VotesContact implements Serializable {
    private String TenNguoiMuon;
    private String TenSach;
    private String Sluong;
    private String Datefinish;
    private int Status;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        ID = id;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getSluong() {
        return Sluong;
    }

    public void setSluong(String sluong) {
        Sluong = sluong;
    }

    public String getTenNguoiMuon() {
        return TenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        TenNguoiMuon = tenNguoiMuon;
    }

    public String getDatefinish() {
        return Datefinish;
    }

    public void setDatefinish(String datefinish) {
        Datefinish = datefinish;
    }

    public VotesContact(String tenNguoiMuon,String tenSach, String sluong, String datefinish) {
        TenNguoiMuon = tenNguoiMuon;
        TenSach = tenSach;
        Sluong = sluong;
        Datefinish = datefinish;
        Status = 0;
    }


    public VotesContact() {
        super();
    }
    /**
     * lấy định dạng ngày
     * @param d
     * @return
     */
    public String getDateFormat(Date d)
    {
        SimpleDateFormat dft=new
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dft.format(d);
    }


}


