package com.example.boc_app.DataBase;

import android.provider.BaseColumns;

public class ContactUsMessageDetails {

    private ContactUsMessageDetails() {}

    public static class Message implements BaseColumns {
        public static final String TABLE_NAME = "ContactUsMessageInfo";
        public static final String COLUMN_1 = "username";
        public static final String COLUMN_2 = "email";
        public static final String COLUMN_3 = "message";
        public static final String COLUMN_4 = "date";
    }
}
