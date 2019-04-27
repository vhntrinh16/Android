package com.example.testgknangcao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<MonhocModel> monhocModels;
    Map<String, String>mMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monhocModels = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mMap.put("id", "27");
        new MonHocAsyncTask(MainActivity.this,new IMonHocView() {
            @Override
            public void onRequestSuccess(Bitmap bitmap) {

            }

            @Override
            public void onGetDataSuccess(JSONArray jsonArray) {
                for (int i=0;i<jsonArray.length();i++){
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        MonhocModel model = new MonhocModel();
                        model.setTenMH(jsonObject.getString("subject_name"));
                        model.setMaMH(jsonObject.getString("subject_code"));
                        model.setTinchi(jsonObject.getInt("credits"));
                        model.setMota(jsonObject.getString("description"));
                        model.setId(Integer.valueOf(jsonObject.getString("id")));
                        monhocModels.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                MonhocAdapter adapter = new MonhocAdapter(monhocModels,R.layout.mh_item, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }
        },mMap).execute("http://www.vidophp.tk/api/account/getdata");
    }
}
