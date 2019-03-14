package com.example.vuhoangnutrinh_1706020090;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactProducer extends AppCompatActivity {
    EditText tenSP;
    EditText maSP;
    EditText gia;
    EditText mota;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_producer);
        Init();
        final Intent intent = getIntent();
        tenSP.setText(intent.getStringExtra("tenDT"));
        maSP.setText(intent.getStringExtra("maDT"));
        gia.setText(intent.getStringExtra("gia"));
        mota.setText(intent.getStringExtra("mo ta"));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Init(){
        tenSP = findViewById(R.id.edttensp);
        maSP = findViewById(R.id.edtmasp);
        gia = findViewById(R.id.edtgia);
        mota = findViewById(R.id.edtmota);
        btnback = findViewById(R.id.btnBack);
    }
}
