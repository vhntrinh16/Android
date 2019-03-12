package com.example.exercise;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<UserContact>{
    List<UserContact> list;
    int GroupID;
    Context context;

    public CustomAdapter(Context context, int vg, List<UserContact> list) {
        super(context, vg, list);//gọi là hàm cha
        this.list = list;
        GroupID = vg;
        this.context = context;
    }
    class Viewholder{
        TextView textView1;
        TextView textView2;
        Button buttonCall;
        Button btnIcon, btnDe;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent){

        View rowView = convertView;
        Viewholder viewholder = new Viewholder();
        final UserContact userContact = getItem(position);
        if(rowView == null){
            rowView = LayoutInflater.from(getContext()).inflate(GroupID, parent, false);
            viewholder.textView1 = rowView.findViewById(R.id.txt);
            viewholder.textView2 = rowView.findViewById(R.id.txt1);
            viewholder.buttonCall = rowView.findViewById(R.id.btn);
            viewholder.btnIcon = rowView.findViewById(R.id.btnClick);
            viewholder.btnDe = rowView.findViewById(R.id.btnDelete);
        }
        else {viewholder =(Viewholder) rowView.getTag();}

        viewholder.textView1.setText(userContact.getName());
        viewholder.textView2.setText(userContact.getPhoneNumber());
        viewholder.buttonCall.setTag(userContact.getCallingActivity());

        viewholder.buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +userContact.getPhoneNumber()));
                context.startActivity(intent);
            }
        });

        viewholder.btnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main_AddContactActivity.class);
                intent.putExtra("name", userContact.getName());
                intent.putExtra("phone", userContact.getPhoneNumber());
                intent.putExtra("address", userContact.getAddress());
                context.startActivity(intent);

            }
        });

        viewholder.btnDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.userContacts.remove(position);
                notifyDataSetChanged();
            }
        });

        rowView.setTag(viewholder);
        return rowView;

    }


}
