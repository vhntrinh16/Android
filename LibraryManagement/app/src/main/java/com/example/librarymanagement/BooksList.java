package com.example.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.librarymanagement.User.BooksContact;

import java.util.ArrayList;
import java.util.List;

public class BooksList extends AppCompatActivity {
    static List<BooksContact> booksContacts = new ArrayList<>();
    static ContactAdapter adapter;
    ListView listview;
    Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        listview = (ListView) findViewById(R.id.listView);
        btnadd = findViewById(R.id.btnAdd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BooksList.this, EditContactActivity.class);
                startActivity(intent);
            }
        });

        AddContact();

        adapter = new ContactAdapter(this, booksContacts, R.layout.bookslist2);
        listview.setAdapter(adapter);
        listview.setClickable(true);

    }

    public void AddContact(){
        booksContacts.add(new BooksContact(0,"Code Complete", "0001", "Programer", "Steve McConnell", "1"));
        booksContacts.add(new BooksContact(1,"The Mythical Man Month", "0002", "Sofware", "Edition", "2"));
    }

}
