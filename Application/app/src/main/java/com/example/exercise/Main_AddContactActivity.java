package com.example.exercise;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main_AddContactActivity extends AppCompatActivity {
    TextView name;
    TextView Number;
    TextView Address;
    TextView City;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__add_contact);
        Init();
        final Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        Number.setText(intent.getStringExtra("phone"));
        Address.setText(intent.getStringExtra("address"));
        City.setText(intent.getStringExtra("city"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_AddContactActivity.this, MainActivity.class));
            }
        });

    }

    public void Init(){
        name = findViewById(R.id.txt2);
        Number = findViewById(R.id.txt3);
        Address = findViewById(R.id.txt4);
        City = findViewById(R.id.txt5);
        btn = findViewById(R.id.btnBack);
    }

}
