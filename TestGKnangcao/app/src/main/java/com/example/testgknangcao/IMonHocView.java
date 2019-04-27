package com.example.testgknangcao;

import android.graphics.Bitmap;

import org.json.JSONArray;

public interface IMonHocView {
    void onRequestSuccess(Bitmap bitmap);

    void onGetDataSuccess(JSONArray jsonArray);
}
