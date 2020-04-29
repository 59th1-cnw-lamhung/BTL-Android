package com.example.btl_android_v1.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.btl_android_v1.Databases.Noticeboard_Database;
import com.example.btl_android_v1.Object.Noticeboard;

import java.util.ArrayList;
import java.util.List;

public class Noticeboard_Model {
    Noticeboard_Database bienBaoDatabase;
    SQLiteDatabase database;
    public Noticeboard_Model(Context context){
        bienBaoDatabase = new Noticeboard_Database(context);
    }
    public void open(){
        database = bienBaoDatabase.getReadableDatabase();
    }
    public void close(){
        bienBaoDatabase.close();
    }

    public List<Noticeboard> getListBienBao(){
        List<Noticeboard> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        //isAfterLast() thực hiện cho tới khi cuối cùng của con trỏ
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            Noticeboard bienBao;
            //compareTo phương thức so sánh
            if (image.compareTo("0")!=0) {
                bienBao = new Noticeboard(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }

    public List<Noticeboard> getListBienBaoNguyHiem(){
        List<Noticeboard> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 1";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            Noticeboard bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new Noticeboard(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }

    public List<Noticeboard> getListBienBaoCam(){
        List<Noticeboard> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 2";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            Noticeboard bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new Noticeboard(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }

    public List<Noticeboard> getListBienBaoHieuLenh(){
        List<Noticeboard> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 3";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            Noticeboard bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new Noticeboard(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }

    public List<Noticeboard> getListBienBaoChiDan(){
        List<Noticeboard> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 4";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            Noticeboard bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new Noticeboard(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }

    public List<Noticeboard> getListBienBaoPhu(){
        List<Noticeboard> listBienBao = new ArrayList<>();
        open();
        String cauTruyVan = "select * from BIENBAO where loaibien = 5";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String image = cursor.getString(0);
            String noiDung = cursor.getString(1);
            int loaiBien = cursor.getInt(2);
            Noticeboard bienBao;
            if (image.compareTo("0")!=0) {
                bienBao = new Noticeboard(noiDung,"bienbao"+image,loaiBien);
                listBienBao.add(bienBao);
            }
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listBienBao;
    }

}
