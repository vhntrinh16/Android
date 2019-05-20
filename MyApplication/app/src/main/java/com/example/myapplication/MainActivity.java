package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GoogleSignInClient signInClient;
    int RC_SIGN_IN;
    //private String TAG = "FireBase-Log";
    static FirebaseDatabase database;
    static DatabaseReference myRef;
    DatabaseReference userRef;
    private static String UserId = "";
    private static String Email = "", Username = "";
    private static String product_name = "";
    private static String producer = "", price = "";
    private static String description = "";
    Button btnadd;
    EditText edtname, edtproducer, edtprice, edtDes;
    RecyclerView recyclerView;
    static Adapter adapter;
    static List<Model> modelList;
    static Model model = new Model();

    @Override
    protected void onResume() {
        super.onResume();
        //MainActivity.adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        signInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        signInClient = GoogleSignIn.getClient(this, gso);
        signIn();
        init();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        database = FirebaseDatabase.getInstance();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddProduct();
                Clearform();
            }
        });

        myRef = database.getReference("AdvancedAndroidFinalTest");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelList = new ArrayList<Model>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Model m = dataSnapshot1.getValue(Model.class);
                    modelList.add(m);
                }
//                if (modelList.isEmpty()) {
//                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                        Model n = dataSnapshot1.getValue(Model.class);
//                        modelList.add(n);
//                    }
//                }
                adapter = new Adapter(modelList, R.layout.custom_recycle, MainActivity.this);
                //adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                recyclerView.smoothScrollToPosition(adapter.getItemCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void signIn() {
        Intent signInIntent = signInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            firebaseAuthWithGoogle(task);
        }
    }

    private void firebaseAuthWithGoogle(Task<GoogleSignInAccount> task) {
        try{
            GoogleSignInAccount account = task.getResult(ApiException.class);
            UserId = account.getId();
            Email = account.getEmail();
            Username = account.getDisplayName();
        }catch (ApiException e){
            finish();
        }
    }
    void init(){
        recyclerView = findViewById(R.id.rcv);
        edtname = findViewById(R.id.editName);
        edtproducer = findViewById(R.id.editproducer);
        edtprice = findViewById(R.id.editprice);
        edtDes = findViewById(R.id.editDescription);
        btnadd = findViewById(R.id.btn_add);
    }

    private void AddProduct() {
        myRef = database.getReference("AdvancedAndroidFinalTest");
        model.setUserId(UserId);
        model.setEmail(Email);
        model.setUsername(Username);
        model.setProduct_name(edtname.getText().toString());
        model.setProducer(edtproducer.getText().toString());
        model.setPrice(Integer.parseInt(edtprice.getText().toString()));
        model.setDescription(edtDes.getText().toString());
        userRef = myRef.child(model.getProduct_name());
        userRef.setValue(model);
    }

    boolean onVali(){
        product_name = edtname.getText().toString();
        producer = edtproducer.getText().toString();
        price = edtprice.getText().toString();
        description = edtDes.getText().toString();
        if(product_name.equals("")){
            edtname.setError("Null");
            return false;
        }
        if(producer.equals("")){
            edtproducer.setError("Null");
            return false;
        }
        if(price.equals("")){
            edtprice.setError("Null");
            return false;
        }
        if(description.equals("")){
            edtDes.setError("Null");
            return false;
        }
        return true;
    }

    void Clearform(){
        edtname.setText("");
        edtproducer.setText("");
        edtprice.setText("");
        edtDes.setText("");
    }
}
