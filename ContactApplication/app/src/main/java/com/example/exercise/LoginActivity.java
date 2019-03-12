package com.example.exercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtuser, edtpass;
    Button btnLg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        onInit();

        btnLg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin();
            }
        });
    }

    private void onLogin() {
        if (edtuser.getText().toString().equals("admin") && edtpass.getText().toString().equals("123")) {
            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }

        else{
            Toast.makeText(LoginActivity.this, "Login fail", Toast.LENGTH_LONG).show();
        }

    }

    private boolean ValidateForm(){
        if (edtuser.getText().toString().length() < 1){
            edtuser.setError("Please fill user");
            return false;
        }
        if (edtpass.getText().toString().length() < 1){
            edtpass.setError("Please fill pass");
            return false;
        }
        return true;
    }

    private void onInit(){
        edtuser = findViewById(R.id.edtUser);
        edtpass = findViewById(R.id.edtPass);
        btnLg = findViewById(R.id.btnLogin);
    }
}
