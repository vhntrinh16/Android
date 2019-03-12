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
    Button btnA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.ListView);
        btnA = findViewById(R.id.btnAdd);
        btnA.setOnClickListener(new View.OnClickListener() {
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
        userContacts.add(new UserContact(0,"Trinh", "123", "Quận 12"));
        userContacts.add(new UserContact(1,"Khoa Doggy", "111", "Tân Hiệp"));
        userContacts.add(new UserContact(2,"Tốn Lù", "222", "Tam Bình"));
        userContacts.add(new UserContact(3,"NoName", "333", "No"));
    }

}
