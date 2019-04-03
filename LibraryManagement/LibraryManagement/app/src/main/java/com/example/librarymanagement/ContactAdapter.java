package com.example.librarymanagement;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.librarymanagement.BooksList;
import com.example.librarymanagement.Database.SQLite;
import com.example.librarymanagement.EditContactActivity;
import com.example.librarymanagement.Fragment.BooksFragment;
import com.example.librarymanagement.R;
import com.example.librarymanagement.User.BooksContact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<BooksContact> {
    List<BooksContact> list;
    int GroupID;
    Context context;
    SQLite sqLite;

    public ContactAdapter(Context context, List<BooksContact> list, int groupID) {
        super(context, groupID, list);
        this.list = list;
        GroupID = groupID;
        this.context = context;
    }

    class ViewHolder{
        TextView text1;
        TextView text2;
        TextView text3;
        LinearLayout layout;
    }

    @Override
    public View getView(final int position, View converView, ViewGroup parent){
        sqLite = new SQLite(getContext());
        ViewHolder viewHolder = new ViewHolder();
        final BooksContact booksContact = list.get(position);
        if(converView == null){
            converView = LayoutInflater.from(getContext()).inflate(GroupID, parent, false);
            viewHolder.text1 = converView.findViewById(R.id.txt1);
            viewHolder.text2 = converView.findViewById(R.id.txt2);
            viewHolder.text3 = converView.findViewById(R.id.txt3);
            viewHolder.layout = converView.findViewById(R.id.Layout);
            converView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) converView.getTag();
        }

        viewHolder.text1.setText(String.valueOf(booksContact.getTenSach()));
        viewHolder.text2.setText(String.valueOf(booksContact.getNXB()));
        viewHolder.text3.setText(String.valueOf(booksContact.getSoLuong()));

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, ContactDetail.class);
                i.putExtra("ct", booksContact);
                context.startActivity(i);
            }
        });

        return converView;
    }
}
