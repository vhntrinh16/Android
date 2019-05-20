package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Product_DetailActivity extends AppCompatActivity {
    EditText editname, editproducer, editprice, editdes;
    Button btnedit, btnsave, btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__detail);
        init();
        Enable();
        Intent i = getIntent();
        editname.setText(i.getStringExtra("product_name"));
        editproducer.setText(i.getStringExtra("producer"));
        editprice.setText(String.valueOf(i.getStringExtra("price")));
        editdes.setText(i.getStringExtra("description"));
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disable();
            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disable();
                MainActivity.myRef = MainActivity.database.getReference("AdvancedAndroidFinalTest");
                MainActivity.myRef.child(editname.getText().toString()).child("product_name").setValue(editname.getText().toString());
                MainActivity.myRef.child(editname.getText().toString()).child("producer").setValue(editproducer.getText().toString());
                MainActivity.myRef.child(editname.getText().toString()).child("price").setValue(Integer.parseInt(editprice.getText().toString()));
                MainActivity.myRef.child(editname.getText().toString()).child("description").setValue(editdes.getText().toString());
                finish();
            }
        });
    }

    void init(){
        editname = findViewById(R.id.d_edtname);
        editproducer = findViewById(R.id.d_edtproducer);
        editprice = findViewById(R.id.d_edtprice);
        editdes = findViewById(R.id.d_edtdes);
        btnback = findViewById(R.id.d_btnback);
        btnedit = findViewById(R.id.d_btnedit);
        btnsave = findViewById(R.id.d_btnsave);
    }
    private void Enable(){
        editname.setEnabled(false);
        editproducer.setEnabled(false);
        editprice.setEnabled(false);
        editdes.setEnabled(false);
    }
    private void Disable(){
        editname.setEnabled(true);
        editproducer.setEnabled(true);
        editprice.setEnabled(true);
        editdes.setEnabled(true);
    }
}
