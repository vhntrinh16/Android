package com.example.librarymanagement.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.librarymanagement.ContactAdapter;
import com.example.librarymanagement.CreateVote_VoteList;
import com.example.librarymanagement.Database.SQLite;
import com.example.librarymanagement.HistoryActivity;
import com.example.librarymanagement.R;
import com.example.librarymanagement.TabLayout.TabControl;
import com.example.librarymanagement.User.VotesContact;
import com.example.librarymanagement.VoteAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static java.util.Calendar.AM;
import static java.util.Calendar.PM;

public class VotesFragment extends Fragment {
    Button btncreate, btnhistory;
    static VoteAdapter adapter;
    ListView listView;
    static List<VotesContact> votesContacts = new ArrayList<>();
    static List<VotesContact>voteforAdapter = new ArrayList<>();
    static SQLite sqLite;
    public VotesFragment(){

    }
    @Override
    public void onResume(){
        super.onResume();
        Update();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_votes, container, false);
        listView = (ListView) view.findViewById(R.id.lv_vote1);
        btncreate = (Button) view.findViewById(R.id.btnCreate);
        btnhistory = (Button) view.findViewById(R.id.btnHistory);
        sqLite = new SQLite(getContext());
        votesContacts = sqLite.getAllSubject();
        if(votesContacts.isEmpty()){
            setValue();
            votesContacts = sqLite.getAllSubject();
        }
        adapter = new VoteAdapter(getContext(), R.layout.votelist, votesContacts);
        listView.setAdapter(adapter);
        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CreateVote_VoteList.class);
                startActivity(i);

            }
        });

        btnhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), HistoryActivity.class);
                startActivity(i);
            }
        });

        return view;
    }
    public static void Update(){
        votesContacts.clear();
        votesContacts.addAll(sqLite.getAllSubject());
        voteforAdapter.clear();
        for (int i = 0; i < votesContacts.size(); i++){
            if(votesContacts.isEmpty()){
                voteforAdapter.add(votesContacts.get(i));
            }
        }
        adapter.notifyDataSetChanged();
    }
    private void setValue() {
        sqLite.InsertSubject("abc", "cde", "5", "1/4/2019");
        sqLite.InsertSubject("ưdưe", "sds", "5", "1/4/2019");
    }

}
