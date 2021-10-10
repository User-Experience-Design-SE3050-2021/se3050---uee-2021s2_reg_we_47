package com.example.boc_app.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;
public class DBHelperAddAccount extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "eChannel";

    public DBHelperAddAccount(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AddAccountDetails.Account.TABLE_NAME + " (" +
                    AddAccountDetails.Account._ID + " String PRIMARY KEY," +
                    AddAccountDetails.Account.COLUMN_1 + " TEXT," +
                    AddAccountDetails.Account.COLUMN_2 + " TEXT," +
                    AddAccountDetails.Account.COLUMN_3 + " TEXT," +
                    AddAccountDetails.Account.COLUMN_4 + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AddAccountDetails.Account.TABLE_NAME;

    public long addInfo( String type,String holder_name, String acc_number, String branch){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(AddAccountDetails.Account.COLUMN_1, type);
        values.put(AddAccountDetails.Account.COLUMN_2, holder_name);
        values.put(AddAccountDetails.Account.COLUMN_3, acc_number);
        values.put(AddAccountDetails.Account.COLUMN_4, branch);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(AddAccountDetails.Account.TABLE_NAME, null, values);
        return newRowId;
    }

}
