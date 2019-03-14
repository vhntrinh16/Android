package com.example.vuhoangnutrinh_1706020090;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Pass;
    Button btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login(){
        if(Name.getText().toString().equals("admin") && Pass.getText().toString().equals("1")){
            Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, ListContact.class);
            startActivity(intent);
        }else {Toast.makeText(MainActivity.this, "Login fail", Toast.LENGTH_LONG).show();}
    }

    private boolean ValidateForm(){
        if(Name.getText().toString().length() < 1){
            Name.setError("Please fill user");
            return false;
        }
        if(Pass.getText().toString().length() < 1){
            Pass.setError("Please fill pass");
            return false;
        }
        return true;
    }

    private void Init(){
        Name = findViewById(R.id.edtname);
        Pass = findViewById(R.id.edtpass);
        btnLog = findViewById(R.id.btnLogin);
    }
}
