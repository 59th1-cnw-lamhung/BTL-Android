package com.example.btl_android_v1.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.btl_android_v1.Adapter.AdapterRecyclerView_LuatGT;
import com.example.btl_android_v1.Adapter.AdapterRecyclerView_MeoGhiNho;
import com.example.btl_android_v1.Databases.LuatGT_Database;
import com.example.btl_android_v1.Model.LuatGT_Model;

import com.example.btl_android_v1.Object.LuatGT;
import com.example.btl_android_v1.R;

import java.util.ArrayList;
import java.util.List;

import ca.barrenechea.widget.recyclerview.decoration.DividerDecoration;
import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderDecoration;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;


public class LuatGT_Activity extends AppCompatActivity {
    RecyclerView rcv_luatgt;
    AdapterRecyclerView_LuatGT adapterRecyclerViewLuatGT;
    LuatGT_Model luatGTModel;
    private StickyHeaderDecoration decor;
    Button btn_menu,btn_search;
    Toolbar toolbar;
    EditText editText;


    public static String NoiDungtimkiem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luatgt);
        btn_search = findViewById(R.id.button1);
        editText = findViewById(R.id.timkiem);
        editText.setVisibility(View.GONE);

        setControl();

    }
    public void setControl(){
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toolbar.setTitle("");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        rcv_luatgt = findViewById(R.id.rcv_luatgt);
        rcv_luatgt.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        luatGTModel = new LuatGT_Model(this);
        adapterRecyclerViewLuatGT = new AdapterRecyclerView_LuatGT(this,luatGTModel.getListLuatGT());
        DividerDecoration divider = new DividerDecoration.Builder(this)
                .setHeight(R.dimen.default_divider_height)
                .setPadding(R.dimen.default_divider_padding)
                .setColorResource(R.color.default_header_color)
                .build();
        rcv_luatgt.setHasFixedSize(true);
        rcv_luatgt.addItemDecoration(divider);
        rcv_luatgt.setAdapter(adapterRecyclerViewLuatGT);



        decor = new StickyHeaderDecoration(adapterRecyclerViewLuatGT);
        rcv_luatgt.addItemDecoration(decor, 1);
        OverScrollDecoratorHelper.setUpOverScroll(rcv_luatgt, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v7.widget.PopupMenu popupMenu
                        = new android.support.v7.widget.PopupMenu(LuatGT_Activity.this,btn_menu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_luatgt,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new android.support.v7.widget.PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.item_tatca:
                                adapterRecyclerViewLuatGT
                                        = new AdapterRecyclerView_LuatGT(LuatGT_Activity.this,luatGTModel.getListLuatGT());
                                rcv_luatgt.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewLuatGT);
                                rcv_luatgt.addItemDecoration(decor, 1);
                                rcv_luatgt.setAdapter(adapterRecyclerViewLuatGT);
                                break;

                            case R.id.item_loai1:
                            adapterRecyclerViewLuatGT
                                    = new AdapterRecyclerView_LuatGT(LuatGT_Activity.this,luatGTModel.getListLuatGTloai1());
                            rcv_luatgt.removeItemDecoration(decor);
                            decor = new StickyHeaderDecoration(adapterRecyclerViewLuatGT);
                            rcv_luatgt.addItemDecoration(decor, 1);
                            rcv_luatgt.setAdapter(adapterRecyclerViewLuatGT);
                            break;

                            case R.id.item_loai2:
                                adapterRecyclerViewLuatGT
                                        = new AdapterRecyclerView_LuatGT(LuatGT_Activity.this,luatGTModel.getListLuatGTloai2());
                                rcv_luatgt.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewLuatGT);
                                rcv_luatgt.addItemDecoration(decor, 1);
                                rcv_luatgt.setAdapter(adapterRecyclerViewLuatGT);
                                break;

                            case R.id.item_loai3:
                                adapterRecyclerViewLuatGT
                                        = new AdapterRecyclerView_LuatGT(LuatGT_Activity.this,luatGTModel.getListLuatGTloai3());
                                rcv_luatgt.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewLuatGT);
                                rcv_luatgt.addItemDecoration(decor, 1);
                                rcv_luatgt.setAdapter(adapterRecyclerViewLuatGT);
                                break;

                            case R.id.item_loai4:
                                adapterRecyclerViewLuatGT
                                        = new AdapterRecyclerView_LuatGT(LuatGT_Activity.this,luatGTModel.getListLuatGTloai4());
                                rcv_luatgt.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewLuatGT);
                                rcv_luatgt.addItemDecoration(decor, 1);
                                rcv_luatgt.setAdapter(adapterRecyclerViewLuatGT);
                                break;


                        }
                        return true;
                    }
                });
                popupMenu.setGravity(Gravity.CENTER_HORIZONTAL);
                popupMenu.show();
            }
        });


        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setVisibility(View.VISIBLE);
                toolbar.setTitle("Search");
                setSupportActionBar(toolbar);
            }
        });

            editText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NoiDungtimkiem = editText.getText().toString();
                    adapterRecyclerViewLuatGT = new AdapterRecyclerView_LuatGT(LuatGT_Activity.this,luatGTModel.getTimKiem());
                    rcv_luatgt.removeItemDecoration(decor);
                    decor = new StickyHeaderDecoration(adapterRecyclerViewLuatGT);
                    rcv_luatgt.addItemDecoration(decor, 1);
                    rcv_luatgt.setAdapter(adapterRecyclerViewLuatGT);
                    editText.setVisibility(View.VISIBLE);
                    toolbar.setTitle("Search");
                    setSupportActionBar(toolbar);
                }
            });


    }
}
