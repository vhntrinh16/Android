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
    public View getView(final int position, final View convertView, final ViewGroup parent ) {
        View rowView = convertView;
        Viewholder viewholder = new Viewholder();
        final UserContact userContact = getItem(position);
        if (rowView == null) {
            rowView = LayoutInflater.from(getContext()).inflate(GroupID, parent, false);
            viewholder.textView1 = rowView.findViewById(R.id.txt1);
            viewholder.textView2 = rowView.findViewById(R.id.txt2);
            viewholder.textView3 = rowView.findViewById(R.id.txt3);
            viewholder.layout = rowView.findViewById(R.id.layout);

        } else {
            viewholder = (Viewholder) rowView.getTag();
        }

        viewholder.textView1.setText(userContact.getTênĐT());
        viewholder.textView2.setText(userContact.getMã());
        viewholder.textView3.setText(userContact.getGiá());

        viewholder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListContact.class);
                intent.putExtra("hovaten",userContact.getHovaTen());
                intent.putExtra("nganh",userContact.getNganh());
                intent.putExtra("maSV",userContact.getMaSv());
                intent.putExtra("ten SP",userContact.getTenSP());
                intent.putExtra("ma SP",userContact.getMaSP());
                intent.putExtra("Gia",userContact.getGia());
                intent.putExtra("Mo ta",userContact.getMota());
                intent.putExtra( "index", position);
                context.startActivity(intent);
            }
        });

        rowView.setTag(viewholder);
        return rowView;
    }

}
