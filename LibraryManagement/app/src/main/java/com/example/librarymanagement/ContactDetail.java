package com.example.librarymanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.librarymanagement.Database.SQLite;
import com.example.librarymanagement.User.BooksContact;

public class ContactDetail extends AppCompatActivity {
    TextView tvma;
    TextView tvloai;
    TextView tvten;
    TextView tvnxb;
    TextView tvsoluong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);


        Init();
        onGetIntent();

    }

    @SuppressLint("SetTextI18n")
    private void onGetIntent() {
        Intent intent = getIntent();
        BooksContact booksContact = (BooksContact) intent.getSerializableExtra("ct");
        if(booksContact ==null){
            Toast.makeText(this, "kạkjsakd", Toast.LENGTH_SHORT).show();
        }
        tvma.setText("Mã:" + booksContact.getMaSach());
        tvloai.setText("Loại: " + booksContact.getLoaiSach());
        tvten.setText("Tên: " + booksContact.getTenSach());
        tvnxb.setText("Nxb: " + booksContact.getNXB());
        tvsoluong.setText("Số lượng: " + booksContact.getSoLuong());
    }
    public void Init(){
        tvma = findViewById(R.id._txtMA);
        tvloai = findViewById(R.id._txtLOAI);
        tvten = findViewById(R.id.txtTEN);
        tvnxb = findViewById(R.id.txtNXB);
        tvsoluong = findViewById(R.id.txtSL);
    }
}
