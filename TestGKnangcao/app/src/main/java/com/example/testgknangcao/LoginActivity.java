package com.example.testgknangcao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText edtusername;
    EditText edtpassword;
    Button btnLogin;
    String mUser="";
    String mPass="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidateForm()){
                    Map<String, String> mMap = new HashMap<>();
                    mMap.put("user_name", mUser);
                    mMap.put("password", mPass);
                    new LoginAsyncTask(mMap, new ILoginView() {
                        @Override
                        public void onLoginSuccess(String m) {
                            Toast.makeText(LoginActivity.this,m,Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onLoginFail(String m) {
                            Toast.makeText(LoginActivity.this,m,Toast.LENGTH_SHORT).show();
                        }
                    },LoginActivity.this).execute("http://www.vidophp.tk/api/account/signin");
                }
            }
        });

    }
    boolean ValidateForm(){
        mUser = edtusername.getText().toString();
        if(mUser.length() < 1){
            edtusername.setError("Null");
            return false;
        }
        mPass = edtpassword.getText().toString();
        if(mPass.length() < 1){
            edtpassword.setError("Null");
            return false;
        }
        return true;
    }
    void Init(){
        edtusername = findViewById(R.id.edt_username);
        edtpassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btnlogin);
    }
}
