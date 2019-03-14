package com.example.vuhoangnutrinh_1706020090;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ContactProducer extends AppCompatActivity {
    EditText hovaten;
    EditText nganh;
    EditText maSV;
    EditText tenSP;
    EditText maSP;
    EditText gia;
    EditText mota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_producer);
        Init();
        final Intent intent = getIntent();
        hovaten.setText(intent.getStringExtra("name"));
        nganh.setText(intent.getStringExtra("nganh"));
        maSV.setText(intent.getStringExtra("ma SV"));
        tenSP.setText(intent.getStringExtra("ten SP"));
        maSP.setText(intent.getStringExtra("ma SP"));
        gia.setText(intent.getStringExtra("gia"));
        mota.setText(intent.getStringExtra("mo ta"));
    }

    private void Init(){
        hovaten = findViewById(R.id.edtName);
        nganh = findViewById(R.id.edtnganh);
        maSV = findViewById(R.id.edtmaSV);
        tenSP = findViewById(R.id.edttensp);
        maSP = findViewById(R.id.edtmasp);
        gia = findViewById(R.id.edtgia);
        mota = findViewById(R.id.edtmota);
    }
}
