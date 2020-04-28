package com.example.btl_android_v1.Databases;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class Noticeboard_Database extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "BIENBAO.sqlite";
    private static final int DATABASE_VERSION = 1;
    public Noticeboard_Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
