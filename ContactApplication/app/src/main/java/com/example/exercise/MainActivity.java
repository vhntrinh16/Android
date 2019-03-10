package com.example.exercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<UserContact> userContacts = new ArrayList<>();
    static CustomAdapter adapter;
    ListView listView;
    Button btnAddNumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.ListView);
        btnAddNumb =  findViewById(R.id.btnAdd);
        btnAddNumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, Main_AddContactActivity.class);
               startActivity(intent);

            }
        });

        AddContacts();

        adapter = new CustomAdapter(this,R.layout.etxt, userContacts);
        listView.setAdapter(adapter);
        listView.setClickable(true);
    }

    void ShowContact(){
        Intent intent = new Intent(this, Main_AddContactActivity.class);
        startActivity(intent);
    }

    private void AddContacts(){
        userContacts.add(new UserContact("Trinh", "123", "Quận 12", "TPHCM"));
        userContacts.add(new UserContact("Khoa Doggy", "111", "Tân Hiệp", "TPHCM"));
        userContacts.add(new UserContact("Tốn Lù", "222", "Tam Bình", "Vĩnh Long"));
        userContacts.add(new UserContact("NoName", "333", "No", "No"));
    }

}
