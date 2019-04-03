package com.example.librarymanagement;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.librarymanagement.Database.SQLite;
import com.example.librarymanagement.Fragment.VotesFragment;
import com.example.librarymanagement.User.BooksContact;
import com.example.librarymanagement.User.VotesContact;

import java.util.List;

public class VoteAdapter extends ArrayAdapter<VotesContact> {
    static List<VotesContact> list;
    int GroupId;
    Context context;
    SQLite sqLite;

    public VoteAdapter(Context context, int resource, List<VotesContact> objects) {
        super(context, resource, objects);
        this.list = objects;
        GroupId = resource;
        this.context = context;
    }
    class ViewHolder{
        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;
        Button btnDanhdau;
        LinearLayout layout;
    }
    @Override
    public View getView(final int position, View converView, ViewGroup parent) {
        sqLite = new SQLite(getContext());
        ViewHolder viewHolder = new ViewHolder();
        final VotesContact votesContact = list.get(position);
        if (converView == null) {
            converView = LayoutInflater.from(getContext()).inflate(GroupId, parent, false);
            viewHolder.text1 = converView.findViewById(R.id.txt_lv_1);
            viewHolder.text2 = converView.findViewById(R.id.txt_lv_2);
            viewHolder.text3 = converView.findViewById(R.id.txt_lv_3);
            viewHolder.text4 = converView.findViewById(R.id.txt_lv_4);
            viewHolder.btnDanhdau = converView.findViewById(R.id.btndanhdau);
            viewHolder.layout = converView.findViewById(R.id.Layout_vote);
            converView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) converView.getTag();
        }

        viewHolder.text1.setText(String.valueOf(votesContact.getTenSach()));
        viewHolder.text2.setText(String.valueOf(votesContact.getTenNguoiMuon()));
        viewHolder.text3.setText(String.valueOf(votesContact.getSluong()));
        viewHolder.text4.setText(String.valueOf(votesContact.getDatefinish()));

        viewHolder.btnDanhdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_xacnhan_huy);
                dialog.setTitle("Xác nhận đã trả sách");
                Button btnXacnhan = dialog.findViewById(R.id.dialog_btnXacnhan);
                Button btnHuy = dialog.findViewById(R.id.dialog_btnHuy);
                btnXacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sqLite.UpdateStatus(votesContact.getID(), "true");
                        VotesFragment.Update();
                        dialog.dismiss();
                    }
                });
                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailVote.class);
               i.putExtra("VotesContacts", votesContact);
                context.startActivity(i);
            }
        });


        return converView;
    }
}
