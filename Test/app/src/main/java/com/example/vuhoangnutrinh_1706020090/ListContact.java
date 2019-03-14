package com.example.vuhoangnutrinh_1706020090;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListContact extends AppCompatActivity {
    static List<UserContact> userContacts = new ArrayList<>();
    static ContactAdapter adapter;
    ListView listView;
    Button btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        listView = (ListView)findViewById(R.id.listview);
        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListContact.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Addcontact();
        adapter = new ContactAdapter(this, R.layout.listproducer, userContacts);
        listView.setAdapter(adapter);
        listView.setClickable(true);
    }

    private void Addcontact(){
        userContacts.add(new UserContact("SamsungGalaxy J6", "SSG11", "3.595.000đ",
                "Nguyễn Thành Đat", "123", "Tin học", "Xiaomi Redmi", "2TH127", "2.029.000đ", "2GB/16GB"));
        userContacts.add(new UserContact("SamsungGalaxy A7", "DCG008", "5.950.000đ",
                "Nguyễn Thành Đat", "123", "Tin học", "Xiaomi Redmi", "2TH127", "2.029.000đ", "2GB/16GB"));
        userContacts.add(new UserContact("Xiaomi Redmi 6A", "2TH127", "2.029.000đ",
                "Nguyễn Thành Đat", "123", "Tin học", "Xiaomi Redmi", "2TH127", "2.029.000đ", "2GB/16GB"));
        userContacts.add(new UserContact("Xiaomi Redmi Note 7", "2TH130", "4.580.000đ",
                "Nguyễn Thành Đat", "123", "Tin học", "Xiaomi Redmi", "2TH127", "2.029.000đ", "2GB/16GB"));
    }
}
