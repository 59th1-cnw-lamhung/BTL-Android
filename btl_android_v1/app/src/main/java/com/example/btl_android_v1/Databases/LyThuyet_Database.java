package com.example.btl_android_v1.Databases;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



public class LyThuyet_Database extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "CauHoi.sqlite";
    private static final int DATABASE_VERSION = 1;
    public LyThuyet_Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
