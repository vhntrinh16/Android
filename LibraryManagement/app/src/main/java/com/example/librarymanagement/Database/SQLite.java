package com.example.librarymanagement.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ViewFlipper;

import com.example.librarymanagement.User.BooksContact;
import com.example.librarymanagement.User.VotesContact;

import java.util.ArrayList;
import java.util.List;

public class SQLite extends SQLiteOpenHelper {
    public static final String DBName = "SQL_DS";
    public static final int VERSION = 1;
    //Table Danh sach Sach
    public static final String TABLE = "Sach";
    public static final String ID = "ID";
    public static final String B_TENSACH = "TenSach";
    public static final String B_MASACH = "MaSach";
    public static final String B_LOAISACH = "LoaiSach";
    public static final String B_NXB = "Nxb";
    public static final String B_SOLUONG = "SoLuong";
    //Table Subjects
    public static final String TABLE_SUBJECTS = "Subjects";
    public static final String SUBJECT_ID = "ID";
    public static final String SUB_NAME = "Ten";
    public static final String SUB_TENSACH = "Tensach";
    public static final String SUB_SOLUONG = "Soluong";
    public static final String SUB_DATE = "Ngaymuon";
    public static final String SUB_STATUS = "Status";
    public SQLiteDatabase mDB;
    public SQLiteDatabase rDB;

    public SQLite(Context context) {
        super(context, DBName, null, VERSION);
        rDB = getReadableDatabase();
        openDB();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String mQuerry = String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                TABLE, ID, B_TENSACH, B_MASACH, B_LOAISACH, B_NXB, B_SOLUONG);
        String mSubjectsQuerry = String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s, %s, %s, %s, %s INTEGER)",
                TABLE_SUBJECTS, SUBJECT_ID, SUB_NAME, SUB_TENSACH, SUB_SOLUONG, SUB_DATE, SUB_STATUS);
        db.execSQL(mSubjectsQuerry);
        db.execSQL(mQuerry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDB() {
        mDB = getWritableDatabase();
    }

    public void closeDB() {
        if (mDB == null) {
            mDB.close();
        }
    }

    public List<BooksContact> getAll() {
        List<BooksContact> booksContactList = new ArrayList<>();
        String mQuerry = String.format("SELECT * FROM %s", TABLE);
        Cursor cursor = rDB.rawQuery(mQuerry, null);

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            BooksContact item = new BooksContact();
            item.setId(cursor.getInt(0));
            item.setMaSach(cursor.getString(1));
            item.setTenSach(cursor.getString(2));
            item.setLoaiSach(cursor.getString(3));
            item.setNXB(cursor.getString(4));
            item.setSoLuong(cursor.getString(5));
            booksContactList.add(item);

        }
        cursor.close();
        return booksContactList;
    }

    public List<VotesContact> getAllSubject() {
        List<VotesContact> votesContacts = new ArrayList<>();
        String mQuerry = String.format("SELECT * FROM %s", TABLE_SUBJECTS);
        Cursor cursor = mDB.rawQuery(mQuerry, null);
        if (cursor.moveToFirst()) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                VotesContact votes = new VotesContact();
                votes.setID(cursor.getInt(0));
                votes.setTenNguoiMuon(cursor.getString(1));
                votes.setTenSach(cursor.getString(2));
                votes.setSluong(cursor.getString(3));
                votes.setDatefinish(cursor.getString(4));
                votesContacts.add(votes);
            }
        }
        cursor.close();
        return votesContacts;
    }

    public void addItem(BooksContact item) {
        ContentValues values = new ContentValues();
        values.put(B_MASACH, item.getMaSach());
        values.put(B_TENSACH, item.getTenSach());
        values.put(B_LOAISACH, item.getLoaiSach());
        values.put(B_NXB, item.getNXB());
        values.put(B_SOLUONG, item.getSoLuong());
        mDB.insert(TABLE, null, values);
    }

    public void addItemSubject(VotesContact item) {
        ContentValues values = new ContentValues();
        values.put(SUB_NAME, item.getTenNguoiMuon());
        values.put(SUB_TENSACH, item.getTenSach());
        values.put(SUB_SOLUONG, item.getSluong());
        values.put(SUB_DATE, item.getDatefinish());
        mDB.insert(TABLE_SUBJECTS, null, values);
    }

    public void Insert(String b_MASACH, String b_TENSACH, String b_LOAISACH, String b_NXB, String b_SOLUONG) {
        String Insert = String.format("insert into %s (%s, %s, %s, %s, %s ) values ('%s', '%s', '%s', '%s', '%s')",
                TABLE, B_TENSACH, B_MASACH, B_LOAISACH, B_NXB, B_SOLUONG,
                b_MASACH, b_TENSACH, b_LOAISACH, b_NXB, b_SOLUONG);
        mDB.execSQL(Insert);
    }

    public void InsertSubject(String s_TEN, String s_TENSACH, String s_SOLUONG, String s_DATE) {
        String Inser = String.format("insert into %s (%s, %s, %s, %s) values ( '%s', '%s', '%s', '%s')",
                TABLE_SUBJECTS, SUB_NAME, SUB_TENSACH, SUB_SOLUONG, SUB_DATE,
                s_TEN, s_TENSACH, s_SOLUONG, s_DATE);
        mDB.execSQL(Inser);
    }

    public void UpdateStatus(int id, String status) {
        String mQuerry = String.format("UPDATE %s SET %s = '%s' WHERE %s = %s", TABLE_SUBJECTS, SUB_STATUS, status, SUBJECT_ID, id);
        mDB.execSQL(mQuerry);
//        String mClase = String.format("%s = %d", TABLE_SUBJECTS, id);
//        ContentValues values = new ContentValues();
//        values.put(SUB_STATUS, status);
//        int iSuccess = mDB.update(TABLE_SUBJECTS, values, mClase, null);
//        return iSuccess;
    }
}


