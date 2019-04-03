package com.example.librarymanagement.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.librarymanagement.ContactAdapter;
import com.example.librarymanagement.Database.SQLite;
import com.example.librarymanagement.EditContactActivity;
import com.example.librarymanagement.R;
import com.example.librarymanagement.User.BooksContact;

import java.util.ArrayList;
import java.util.List;


public class BooksFragment extends Fragment {
    ListView listView;
    List<BooksContact> books = new ArrayList<>();
    ContactAdapter adapter;
    static SQLite sqLite;
    Button btnThem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_books, container, false);
        listView = view.findViewById(R.id.tab_list_book);
        btnThem = (Button) view.findViewById(R.id.btnThem_sach);

        sqLite = new SQLite(getContext());
        books = sqLite.getAll();
        if(books.isEmpty()){
            setValue();
            books = sqLite.getAll();
        }
        adapter = new ContactAdapter(getContext(), books, R.layout.bookslist2);
        listView.setAdapter(adapter);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), EditContactActivity.class);
                startActivity(i);
            }
        });
        return view;
    }

//    @Override
//    public void onStart(){
//        super.onStart();
//        adapter = new ContactAdapter(getContext(), books, R.layout.bookslist2);
//        listView.setAdapter(adapter);
//    }

    private void setValue(){
        sqLite.Insert("G01", "Bắt trẻ đồng xanh", "Tiểu thuyết", "J.D.Salinger", "5");
        sqLite.Insert("C03", "7 thói quen để thành đạt", "Giả thuyết", "Stephen R. Covey", "10");
        sqLite.Insert("D02", "Đọc vị bất kỳ ai", "Giả thuyết", "David J. Lieberman ", "5");
        sqLite.Insert("B05", "Khởi nghiệp tinh gọn", "Kinh doanh", "Eric Ries ", "5");
    }

}
