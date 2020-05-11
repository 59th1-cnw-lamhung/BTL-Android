package com.example.btl_android_v1.Model;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.btl_android_v1.Activities.MainActivity;
import com.example.btl_android_v1.Databases.LuatGT_Database;
import com.example.btl_android_v1.Object.LuatGT;
import com.example.btl_android_v1.Activities.LuatGT_Activity;
import com.example.btl_android_v1.R;

import java.util.ArrayList;
import java.util.List;

public class LuatGT_Model extends AppCompatActivity  {

    LuatGT_Database LuatGTDatabase;
    SQLiteDatabase database;
    String timkiem ;





    public LuatGT_Model(Context context){
        LuatGTDatabase = new LuatGT_Database(context);
    }
    public void open(){
        database = LuatGTDatabase.getReadableDatabase();
    }
    public void close(){
        LuatGTDatabase.close();
    }
    
    public List<LuatGT> getListLuatGT(){
        List<LuatGT> listLuatGT = new ArrayList<>();
        open();
        String cauTruyVan = "select * from LuatGT";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            LuatGT meoGhiNho = new LuatGT(id,loai,noiDung);
            listLuatGT.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listLuatGT;
    }


    public List<LuatGT> getTimKiem(){

        List<LuatGT> listLuatGT = new ArrayList<>();
        open();
        timkiem = LuatGT_Activity.NoiDungtimkiem;
        String cauTruyVan = "select * from LuatGT where name like '%"+timkiem+"%'";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            LuatGT meoGhiNho = new LuatGT(id,loai,noiDung);
            listLuatGT.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listLuatGT;
    }




    public List<LuatGT> getListLuatGTloai1(){
        List<LuatGT> listLuatGT = new ArrayList<>();
        open();
        String cauTruyVan = "select * from LuatGT where loai = 0";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            LuatGT meoGhiNho = new LuatGT(id,loai,noiDung);
            listLuatGT.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listLuatGT;
    }


    public List<LuatGT> getListLuatGTloai2(){
        List<LuatGT> listLuatGT = new ArrayList<>();
        open();
        String cauTruyVan = "select * from LuatGT ";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            LuatGT meoGhiNho = new LuatGT(id,loai,noiDung);
            if (loai == 1) listLuatGT.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listLuatGT;
    }


    public List<LuatGT> getListLuatGTloai3(){
        List<LuatGT> listLuatGT = new ArrayList<>();
        open();
        String cauTruyVan = "select * from LuatGT where loai = 2 ";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            LuatGT meoGhiNho = new LuatGT(id,loai,noiDung);
            listLuatGT.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listLuatGT;
    }

    public List<LuatGT> getListLuatGTloai4(){
        List<LuatGT> listLuatGT = new ArrayList<>();
        open();
        String cauTruyVan = "select * from LuatGT where loai =3";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            LuatGT meoGhiNho = new LuatGT(id,loai,noiDung);
            listLuatGT.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listLuatGT;
    }
}