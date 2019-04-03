package com.example.librarymanagement;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.librarymanagement.Database.SQLite;
import com.example.librarymanagement.Fragment.VotesFragment;
import com.example.librarymanagement.TabLayout.TabControl;
import com.example.librarymanagement.User.BooksContact;
import com.example.librarymanagement.User.VotesContact;

public class CreateVote_VoteList extends AppCompatActivity {
    EditText edttennguoimuon, edtsluong;
    TextView txtDate;
    Spinner spintensach;
    Button btnDate, btnAdd_vote;

    static List<VotesContact> votes = new ArrayList<>();
   static VoteAdapter adapter;

    String dateFinish="";
    String mTen, mTensach, mSl;
    SQLite sqLite;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_vote__vote_list);
        Init();

        sqLite = new SQLite(this);
        setSpinner();
//        final Intent intent = getIntent();
//        edttennguoimuon.setText(intent.getStringExtra("ten"));
//        edtsluong.setText(intent.getStringExtra("soluong"));
//        edtdate.setText(intent.getStringExtra("ngay"));
        btnAdd_vote.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onValidateForm()){
                    sqLite.InsertSubject(mTen, mTensach, mSl, dateFinish);
                    Toast.makeText(CreateVote_VoteList.this, "Add item success", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(CreateVote_VoteList.this, TabControl.class));
                    finish();
                }
            }
        });

        btnDate.setOnClickListener(new OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                int mYear = cal.get(Calendar.YEAR);
                int mMonth = cal.get(Calendar.MONTH);
                int mDay = cal.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(CreateVote_VoteList.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        btnDate.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });

    }

    public boolean onValidateForm(){
       mTensach = spintensach.getSelectedItem().toString();
       mTen = edttennguoimuon.getText().toString();
        if(mTen.trim() == ""){
            edttennguoimuon.setError("Loai khong de null");
            return false;
        }
        mSl = edtsluong.getText().toString();
        if(mSl.trim() == ""){
            edtsluong.setError("Name cannot be null");
            return false;
        }
        dateFinish = txtDate.getText().toString();
        if(dateFinish.trim() == ""){
            txtDate.setError("Publishing cannot be null");
            return false;
        }

        return true;
    }

    void Init() {
        edttennguoimuon = findViewById(R.id.edithovaten);
        edtsluong = findViewById(R.id.editsosach);
        spintensach = findViewById(R.id.spintensach);
        btnDate = findViewById(R.id.btndate);
        btnAdd_vote = findViewById(R.id.btnadd_vote);
        txtDate = findViewById(R.id.txtdate);
    }


    void setSpinner() {
        List<BooksContact> contacts = sqLite.getAll();
        List<String> data = new ArrayList<>();
        Spinner spinner = findViewById(R.id.spintensach);
        for (int i = 0; i < contacts.size(); i++) {
            data.add(contacts.get(i).getTenSach());
        }
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, data));
//        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

    }

}



