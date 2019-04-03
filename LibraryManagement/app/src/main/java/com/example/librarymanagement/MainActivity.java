package com.example.librarymanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.example.librarymanagement.TabLayout.TabControl;

public class MainActivity extends AppCompatActivity {
    EditText edtUser;
    EditText edtPass;
    Button btnLogin;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        CheckLoged();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

    }

    private void Login() {
        if(edtUser.getText().toString().equals("1706020090") && edtPass.getText().toString().equals("123")){
            Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this, TabControl.class);
            editor.putBoolean("login", true);
            editor.commit();
            startActivity(i);
        }else {
            Toast.makeText(MainActivity.this, "Login fail", Toast.LENGTH_LONG).show();
        }
    }

    public void Init(){
        edtUser = findViewById(R.id.edt_user);
        edtPass = findViewById(R.id.edt_pass);
        btnLogin = findViewById(R.id.btnSign);
        sharedPreferences = getSharedPreferences("save", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    void CheckLoged(){
        if(sharedPreferences.getBoolean("login", false)){
            startActivity(new Intent(MainActivity.this, TabControl.class));
        }
    }
}
