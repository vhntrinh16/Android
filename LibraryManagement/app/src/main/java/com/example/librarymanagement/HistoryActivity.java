package com.example.librarymanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.librarymanagement.Database.SQLite;
import com.example.librarymanagement.User.VotesContact;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity{
    Button btnout;
    ListView listView;
    static List<VotesContact> votesContacts = new ArrayList<>();
    SQLite sqLite;
    VoteAdapter adapter;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView = (ListView) findViewById(R.id.lv_history);
        btnout = (Button) findViewById(R.id.btnOut_lv);
        sqLite = new SQLite(HistoryActivity.this);
        votesContacts = sqLite.getAllSubject();
        if(votesContacts.isEmpty()){
            votesContacts = sqLite.getAllSubject();
        }
        adapter = new VoteAdapter(this, R.layout.votelist, votesContacts);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myPrefs = getSharedPreferences("Activity",
                        MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.clear();
                editor.commit();
                setLoginState(true);
                Intent i = new Intent(HistoryActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

    }
    private void setLoginState(boolean status) {
        sharedPreferences = getSharedPreferences("LoginState",
                MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean("setLoggingOut", status);
        editor.commit();
    }
}
