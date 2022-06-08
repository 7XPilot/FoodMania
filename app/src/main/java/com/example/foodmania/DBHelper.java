package com.example.foodmania;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="Login.db";

    public DBHelper( Context context)
    {
        super(context, "Login.db",null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL ("create Table users(username TEXT primary key, password TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }


    //insertion data function
    public Boolean insertData(String username, String password){

        //takes what users give
        SQLiteDatabase MyDB =this.getWritableDatabase();

        //put values inside table
        ContentValues contentValues =new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);


        long result=MyDB.insert("users",null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    //check if username exists already.
    public Boolean checkusername(String username){
        SQLiteDatabase MyDB =this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username=? ", new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username=? and password=?", new String[]{username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    //update method
    public Boolean upgradeData(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);

        //Cursor selects row , what is selected will load onto this object
        Cursor cursor = MyDB.rawQuery("Select * from  users where username=?", new String[]{username});
        if (cursor.getCount() > 0) {

            long result = MyDB.update("users", contentValues, "username=?", new String[] {username});
            if (result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }

    //Delete
    public Boolean deleteData(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();


        //Cursor selects row , what is selected will load onto this object
        Cursor cursor = MyDB.rawQuery("Select * from  users where username=?", new String[]{username});
        if (cursor.getCount() > 0) {

            long result = MyDB.delete("users", "username=?", new String[] {username});
            if (result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }

    //Get Data
    public Cursor getData() {
        SQLiteDatabase MyDB = this.getWritableDatabase();


        //Cursor selects row , what is selected will load onto this object
        Cursor cursor = MyDB.rawQuery("Select * from  users",null);
        return cursor;

    }



}










