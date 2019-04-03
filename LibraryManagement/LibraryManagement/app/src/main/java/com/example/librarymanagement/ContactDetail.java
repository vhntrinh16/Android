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
    Button btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);


        Init();
        onGetIntent();

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void onGetIntent() {
        Intent intent = getIntent();
        BooksContact booksContact = (BooksContact) intent.getSerializableExtra("ct");
        if(booksContact ==null){
            Toast.makeText(this, "kạkjsakd", Toast.LENGTH_SHORT).show();
        }
        tvma.setText(booksContact.getMaSach());
        tvloai.setText(booksContact.getLoaiSach());
        tvten.setText(booksContact.getTenSach());
        tvnxb.setText(booksContact.getNXB());
        tvsoluong.setText(booksContact.getSoLuong());
    }
    public void Init(){
        tvma = findViewById(R.id._txtMA);
        tvloai = findViewById(R.id._txtLOAI);
        tvten = findViewById(R.id.txtTEN);
        tvnxb = findViewById(R.id.txtNXB);
        tvsoluong = findViewById(R.id.txtSL);
        btnback = findViewById(R.id.b_btnBack);
    }
}
