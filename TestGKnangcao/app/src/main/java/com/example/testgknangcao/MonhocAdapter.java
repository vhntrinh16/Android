package com.example.testgknangcao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

public class MonhocAdapter extends RecyclerView.Adapter<MonhocAdapter.Viewholder> {
    List<MonhocModel> models;
    int mResource;
    Context context;

    public MonhocAdapter(List<MonhocModel> models, int mResource, Context context) {
        this.models = models;
        this.mResource = mResource;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(mResource,viewGroup,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        MonhocModel monhocModel = models.get(i);
        viewholder.edtTen.setText(monhocModel.getTenMH());
        viewholder.edtMa.setText(monhocModel.getMaMH());
        viewholder.editTinchi.setText(monhocModel.getTinchi()+"");
        viewholder.editMota.setText(monhocModel.getMota());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private EditText edtTen;
        private EditText edtMa;
        private EditText editTinchi;
        private EditText editMota;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            this.edtTen = itemView.findViewById(R.id.edt_name);
            this.edtMa = itemView.findViewById(R.id.edt_Ma);
            this.editTinchi = itemView.findViewById(R.id.edt_Credits);
            this.editMota = itemView.findViewById(R.id.edt_Description);
        }
    }
}
