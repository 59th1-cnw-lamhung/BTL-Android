package com.example.btl_android_v1.Databases;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



public class LuatGT_Database extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "LuatGT1.sqlite";
    private static final int DATABASE_VERSION = 1;
    public LuatGT_Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}