package com.example.exercise;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class Main_AddContactActivity extends AppCompatActivity  implements Serializable {
    EditText name;
    EditText Number;
    EditText Address;
    Button btnB;
    Button btnSave;
    String mName = "";
    String mPhone = "";
    String mAddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__add_contact);
        Init();
        final Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        Number.setText(intent.getStringExtra("phone"));
        Address.setText(intent.getStringExtra("address"));

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Main_AddContactActivity.this, MainActivity.class));
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidateForm()){
                    int id = UserContact.userContacts.get(MainActivity.userContacts.size() - 1).getId() + 1;
                    UserContact.adapter.add(new UserContact(id, mName, mPhone, mAddress));
                    UserContact.adapter.notifyDataSetChanged();
                    Toast.makeText(Main_AddContactActivity.this,"Add item success",Toast.LENGTH_LONG).show();
                    onClearForm();
                }
            }
        });
    }

    private boolean ValidateForm(){
        mName = name.getText().toString();
        if(mName.length() < 1){
            name.setError("Name cannot be null");
            return false;
        }
        mAddress = Address.getText().toString();
        if(mAddress.length() < 1){
            Address.setError("Address cannot be null");
            return false;
        }
        mPhone = Number.getText().toString();
        if(mPhone.length() < 1){
            Number.setError("Number cannot be null");
            return false;
        }
        return true;
    }

    private void onClearForm(){
        name.clearComposingText();
        Address.clearComposingText();
        Number.clearComposingText();
    }


    public void Init(){
        name = findViewById(R.id.txt2);
        Number = findViewById(R.id.txt3);
        Address = findViewById(R.id.txt4);
        btnB = findViewById(R.id.btnBack);
        btnSave =findViewById(R.id.Add);
    }

}
