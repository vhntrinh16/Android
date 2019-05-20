package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
    List<Model> modelList;
    int mResource;
    Context context;

    public Adapter(List<Model> modelList, int mResource, Context context) {
        this.modelList = modelList;
        this.mResource = mResource;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(mResource, viewGroup, false);
        return new Viewholder(v);    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter.Viewholder viewholder, final int position) {
        viewholder.pro_name.setText(modelList.get(position).getProduct_name());
        viewholder.producer.setText(modelList.get(position).getProducer());
        viewholder.price.setText(String.valueOf(modelList.get(position).getPrice()));
        viewholder.des.setText(modelList.get(position).getDescription());

        viewholder.imvdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference reference;
                reference = FirebaseDatabase.getInstance().getReference("AdvancedAndroidFinalTest");
                reference.child(viewholder.pro_name.getText().toString()).removeValue();
            }
        });

        viewholder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Product_DetailActivity.class);
                i.putExtra("product_name", modelList.get(position).getProduct_name());
                i.putExtra("producer", modelList.get(position).getProducer());
                i.putExtra("price", String.valueOf(modelList.get(position).getPrice()));
                i.putExtra("description", modelList.get(position).getDescription());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView pro_name, producer, price, des;
        ImageView imvdel;
        LinearLayout linearLayout;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            this.pro_name = itemView.findViewById(R.id.tv_name);
            this.producer = itemView.findViewById(R.id.tv_producer);
            this.price = itemView.findViewById(R.id.tv_price);
            this.des = itemView.findViewById(R.id.tv_description);
            this.imvdel = itemView.findViewById(R.id.imv_del);
            linearLayout = itemView.findViewById(R.id.layout);
        }
    }
}
