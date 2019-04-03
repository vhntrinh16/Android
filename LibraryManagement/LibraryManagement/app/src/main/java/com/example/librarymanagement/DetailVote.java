package com.example.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.librarymanagement.User.BooksContact;
import com.example.librarymanagement.User.VotesContact;

public class DetailVote extends AppCompatActivity {
    TextView ten;
    TextView tensach;
    TextView soluong;
    TextView date;

    Button btnb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vote);
        Init();
        onGetIntent();

        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void onGetIntent() {
        Intent intent = getIntent();
        VotesContact model = (VotesContact) intent.getSerializableExtra("VotesContacts");
        ten.setText(model.getTenNguoiMuon());
        tensach.setText(model.getTenSach());
        soluong.setText(model.getSluong());
        date.setText(model.getDatefinish());
    }
    void Init(){
        ten = findViewById(R.id.detail_ten);
        tensach = findViewById(R.id.detail_tensach);
        soluong = findViewById(R.id.detail_sl);
        date = findViewById(R.id.detail_date);
        btnb = findViewById(R.id.p_btnback);
    }
}
