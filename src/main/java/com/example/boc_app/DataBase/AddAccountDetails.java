package com.example.boc_app.DataBase;

import android.provider.BaseColumns;

public class AddAccountDetails {

    private AddAccountDetails() {}

    public static class Account implements BaseColumns {
        public static final String TABLE_NAME = "AddAccountInfo";
        public static final String COLUMN_1 = "type";
        public static final String COLUMN_2 = "holder_name";
        public static final String COLUMN_3 = "acc_number";
        public static final String COLUMN_4 = "branch";
    }
}
