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


        Addcontact();
        adapter = new ContactAdapter(this, R.layout.listproducer, userContacts);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Addcontact(){
        userContacts.add(new UserContact("SamsungGalaxy J6", "SSG11", "3.595.000đ", "2GB"));
        userContacts.add(new UserContact("SamsungGalaxy A7", "DCG008", "5.950.000đ", "2"));
        userContacts.add(new UserContact("Xiaomi Redmi 6A", "2TH127", "2.029.000đ", "2"));
        userContacts.add(new UserContact("Xiaomi Redmi Note 7", "2TH130", "4.580.000đ","2"));
    }
}
