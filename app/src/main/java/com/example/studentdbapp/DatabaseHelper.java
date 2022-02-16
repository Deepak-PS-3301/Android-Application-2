package com.example.studentdbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String DbName="MainDB";
    static String DbTable="students";
    static String Col1="id";
    static String Col2="name";
    static String Col3="admissionno";
    static String Col4="rollno";
    static String Col5="collegename";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+DbTable+"("+Col1+" integer primary key autoincrement,"+
                Col2+" text,"+
                Col3+" text,"+
                Col4+" text,"+
                Col5+" text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean InsertData(String name,String Rollno,String AdminNo,String College)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content =new ContentValues();
        content.put(Col2,name);
        content.put(Col3,AdminNo);
        content.put(Col4,Rollno);
        content.put(Col5,College);
        long status=db.insert(DbTable,null,content);
        if (status==-1)
        {
            return false;
        }else{
            return true;
        }
    }
}
