package com.example.vuhoangnutrinh_1706020090;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<UserContact> {
    List<UserContact> list;
    int GroupID;
    Context context;

    public ContactAdapter(Context context, int vg, List<UserContact> list){
        super(context, vg, list);
        this.context = context;
        GroupID = vg;
        this.list = list;
    }

    class Viewholder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
        LinearLayout layout;
    }
    @Override
    public View getView(final int position,View convertView,ViewGroup parent ) {
        View rowView = convertView;
        Viewholder viewholder = new Viewholder();
        final UserContact userContact = list.get(position);
        if (rowView == null) {
            rowView = LayoutInflater.from(getContext()).inflate(GroupID, parent, false);
            viewholder.textView1 = rowView.findViewById(R.id.txt1);
            viewholder.textView2 = rowView.findViewById(R.id.txt2);
            viewholder.textView3 = rowView.findViewById(R.id.txt3);
            viewholder.layout = rowView.findViewById(R.id.layout);
            rowView.setTag(viewholder);

        } else {
            viewholder = (Viewholder) rowView.getTag();
        }

        viewholder.textView1.setText(String.valueOf(userContact.getTenDT()));
        viewholder.textView2.setText(String.valueOf(userContact.getGia()));
        viewholder.textView3.setText(String.valueOf(userContact.getMaDT()));

        viewholder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContactProducer.class);
                intent.putExtra("tenDT", userContact.getTenDT());
                intent.putExtra("maDT", userContact.getMaDT());
                intent.putExtra("gia", userContact.getGia());
                intent.putExtra("mo ta", userContact.getMota());
                context.startActivity(intent);
            }
        });


        return rowView;
    }

}
