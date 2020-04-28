package com.example.btl_android_v1.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.btl_android_v1.Databases.Memorize_Database;
import com.example.btl_android_v1.Object.Memorize;

import java.util.ArrayList;
import java.util.List;

public class Memorize_Model {

    Memorize_Database meoGhiNhoDatabase;
    SQLiteDatabase database;
    public Memorize_Model(Context context){
        meoGhiNhoDatabase = new Memorize_Database(context);
    }
    public void open(){
        database = meoGhiNhoDatabase.getReadableDatabase();
    }
    public void close(){
        meoGhiNhoDatabase.close();
    }

    public List<Memorize> getListMeoGhiNho(){
        List<Memorize> listMeoGhiNho = new ArrayList<>();
        open();
        String cauTruyVan = "select * from MEO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            Memorize meoGhiNho = new Memorize(id,loai,noiDung);
            listMeoGhiNho.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listMeoGhiNho;
    }

    public List<Memorize> getListMeoLyThuyet(){
        List<Memorize> listMeoGhiNho = new ArrayList<>();
        open();
        String cauTruyVan = "select * from MEO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            Memorize meoGhiNho = new Memorize(id,loai,noiDung);
            if (loai==0) listMeoGhiNho.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listMeoGhiNho;
    }
    public List<Memorize> getListMeoBienBao(){
        List<Memorize> listMeoGhiNho = new ArrayList<>();
        open();
        String cauTruyVan = "select * from MEO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            Memorize meoGhiNho = new Memorize(id,loai,noiDung);
            if (loai==1) listMeoGhiNho.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listMeoGhiNho;
    }
    public List<Memorize> getListMeoSaHinh(){
        List<Memorize> listMeoGhiNho = new ArrayList<>();
        open();
        String cauTruyVan = "select * from MEO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            int loai = cursor.getInt(1);
            String noiDung = cursor.getString(2);
            Memorize meoGhiNho = new Memorize(id,loai,noiDung);
            if (loai==2) listMeoGhiNho.add(meoGhiNho);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listMeoGhiNho;
    }

}
