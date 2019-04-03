package com.example.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.librarymanagement.Database.SQLite;
import com.example.librarymanagement.Fragment.BooksFragment;
import com.example.librarymanagement.TabLayout.TabControl;
import com.example.librarymanagement.User.BooksContact;

public class EditContactActivity extends AppCompatActivity {

    EditText edtma;
    EditText edtloai;
    EditText edtten;
    EditText edtnxb;
    EditText edtsoluong;

    Button btnsave;

    int Id;
    String mMa = "";
    String mLoai = "";
    String mTen = "";
    String mNxb = "";
    String mSoluong = "";
    SQLite sqLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        Init();
        sqLite = new SQLite(EditContactActivity.this);
//        final Intent intent = getIntent();
//        edtma.setText(intent.getStringExtra("masach"));
//        edtloai.setText(intent.getStringExtra("loaisach"));
//        edtten.setText(intent.getStringExtra("ten"));
//        edtnxb.setText(intent.getStringExtra("nxb"));
//        edtsoluong.setText(intent.getStringExtra("soluong"));
//        Id = intent.getIntExtra("ID", 0);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onValidateForm()) {
                    //Id = BooksList.booksContacts.get(BooksList.booksContacts.size() - 1).getId() + 1;
                    sqLite.Insert(mMa, mLoai, mTen, mNxb, mSoluong);
                    Toast.makeText(EditContactActivity.this,"Add item success",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(EditContactActivity.this, TabControl.class));
                    finish();
                    onClearForm();
                }
            }
        });
    }
    boolean onValidateForm(){
        mMa = edtma.getText().toString();
        if(mMa.length() < 1){
            edtma.setError(" Code cannot be null");
            return false;
        }
        mLoai = edtloai.getText().toString();
        if(mLoai.length() < 1){
            edtloai.setError("Loai khong de null");
            return false;
        }
        mTen = edtten.getText().toString();
        if(mTen.length() < 1){
            edtten.setError("Name cannot be null");
            return false;
        }
        mNxb = edtnxb.getText().toString();
        if(mNxb.length() < 1){
            edtnxb.setError("Publishing cannot be null");
            return false;
        }
        mSoluong = edtsoluong.getText().toString();
        if(mSoluong.length() < 1){
            edtsoluong.setError("Amount cannot be null");
            return false;
        }
        return true;
    }
    void onClearForm(){
        edtma.clearComposingText();
        edtloai.clearComposingText();
        edtten.clearComposingText();
        edtnxb.clearComposingText();
        edtsoluong.clearComposingText();
    }

    void Init(){
        edtma = findViewById(R.id.edtMa);
        edtloai = findViewById(R.id.edtLoai);
        edtten = findViewById(R.id.edtTEN);
        edtnxb = findViewById(R.id.edtNxb);
        edtsoluong = findViewById(R.id.edtSoluong);
        btnsave = findViewById(R.id.btnSave);
    }

}
