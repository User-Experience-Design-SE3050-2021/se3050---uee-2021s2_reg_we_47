package com.example.boc_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "boc.db";
    public DBHelper(Context context) {
        super(context, "boc.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(name TEXT, username TEXT primary key, dCno TEXT, contact TEXT, email TEXT, pass TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
    }

    // data insert function
    public Boolean insertData(String name, String uname, String dCno, String contact,String email, String pass ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name",name);
        values.put("username",uname);
        values.put("dCno",dCno);
        values.put("contact",contact);
        values.put("email",email);
        values.put("pass",pass);

        long result = db.insert("users",null,values);
        if(result==-1)return false;
        else
            return true;
    }

    //check username fuction
    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String [] {username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    // check username password fucntion
    public Boolean checkusernamepassword(String username, String pass){
      SQLiteDatabase db = this.getWritableDatabase();
      Cursor cursor = db.rawQuery("select * from users where username = ? and pass = ?", new String[]{username,pass});
      if(cursor.getCount()>0){
          return true;
      }
      else{
          return false;
      }
    }

}
