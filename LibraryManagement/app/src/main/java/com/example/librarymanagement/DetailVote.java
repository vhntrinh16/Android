package com.example.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.librarymanagement.User.BooksContact;
import com.example.librarymanagement.User.VotesContact;

public class DetailVote extends AppCompatActivity {
    TextView ten;
    TextView tensach;
    TextView soluong;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vote);
        Init();
        onGetIntent();
    }
    private void onGetIntent() {
        Intent intent = getIntent();
        VotesContact model = (VotesContact) intent.getSerializableExtra("VotesContacts");
        ten.setText("Tên: " + model.getTenNguoiMuon());
        tensach.setText("Tên sách: " + model.getTenSach());
        soluong.setText("Số lượng: " + model.getSluong());
        date.setText("Ngày: " + model.getDatefinish());
    }
    void Init(){
        ten = findViewById(R.id.detail_ten);
        tensach = findViewById(R.id.detail_tensach);
        soluong = findViewById(R.id.detail_sl);
        date = findViewById(R.id.detail_date);
    }
}
