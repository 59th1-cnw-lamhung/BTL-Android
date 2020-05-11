package com.example.btl_android_v1.Activities;

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
import android.widget.Button;
import android.widget.EditText;

import com.example.btl_android_v1.Adapter.AdapterRecyclerView_LuatGT;
import com.example.btl_android_v1.Adapter.AdapterRecyclerView_MeoGhiNho;
import com.example.btl_android_v1.Model.MeoGhiNho_Model;
import com.example.btl_android_v1.R;

import ca.barrenechea.widget.recyclerview.decoration.DividerDecoration;
import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderDecoration;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;


public class MeoGhiNho_Activity extends AppCompatActivity {
    RecyclerView rcv_meoGhiNho;
    AdapterRecyclerView_MeoGhiNho adapterRecyclerViewMeoGhiNho;
    MeoGhiNho_Model meoGhiNhoDAO;
    private StickyHeaderDecoration decor;
    Button btn_menu,btn_search;
    Toolbar toolbar;
    EditText editText;

    public static String NoiDungtimkiem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meoghinho);

        btn_search = findViewById(R.id.button1);
        editText = findViewById(R.id.timkiem);
        NoiDungtimkiem = editText.getText().toString();
        editText.setVisibility(View.GONE);
        setControl();
    }
    public void setControl(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        rcv_meoGhiNho = findViewById(R.id.rcv_meoGhiNho);
        rcv_meoGhiNho.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        meoGhiNhoDAO = new MeoGhiNho_Model(this);
        adapterRecyclerViewMeoGhiNho = new AdapterRecyclerView_MeoGhiNho(this,meoGhiNhoDAO.getListMeoGhiNho());
        DividerDecoration divider = new DividerDecoration.Builder(this)
                .setHeight(R.dimen.default_divider_height)
                .setPadding(R.dimen.default_divider_padding)
                .setColorResource(R.color.default_header_color)
                .build();
        rcv_meoGhiNho.setHasFixedSize(true);
        rcv_meoGhiNho.addItemDecoration(divider);
        rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
        decor = new StickyHeaderDecoration(adapterRecyclerViewMeoGhiNho);
        rcv_meoGhiNho.addItemDecoration(decor, 1);
        OverScrollDecoratorHelper.setUpOverScroll(rcv_meoGhiNho, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v7.widget.PopupMenu popupMenu
                        = new android.support.v7.widget.PopupMenu(MeoGhiNho_Activity.this,btn_menu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_meoghinho,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new android.support.v7.widget.PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.item_tatca:
                                adapterRecyclerViewMeoGhiNho
                                        = new AdapterRecyclerView_MeoGhiNho(MeoGhiNho_Activity.this,meoGhiNhoDAO.getListMeoGhiNho());
                                rcv_meoGhiNho.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewMeoGhiNho);
                                rcv_meoGhiNho.addItemDecoration(decor, 1);
                                rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
                                break;
                            case R.id.item_meolythuyet:
                                adapterRecyclerViewMeoGhiNho
                                        = new AdapterRecyclerView_MeoGhiNho(MeoGhiNho_Activity.this,meoGhiNhoDAO.getListMeoLyThuyet());
                                rcv_meoGhiNho.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewMeoGhiNho);
                                rcv_meoGhiNho.addItemDecoration(decor, 1);
                                rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
                                break;
                            case R.id.item_meobienbao:
                                adapterRecyclerViewMeoGhiNho
                                        = new AdapterRecyclerView_MeoGhiNho(MeoGhiNho_Activity.this,meoGhiNhoDAO.getListMeoBienBao());
                                rcv_meoGhiNho.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewMeoGhiNho);
                                rcv_meoGhiNho.addItemDecoration(decor, 1);
                                rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
                                break;
                            case R.id.item_meosahinh:
                                adapterRecyclerViewMeoGhiNho
                                        = new AdapterRecyclerView_MeoGhiNho(MeoGhiNho_Activity.this,meoGhiNhoDAO.getListMeoSaHinh());
                                rcv_meoGhiNho.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewMeoGhiNho);
                                rcv_meoGhiNho.addItemDecoration(decor, 1);
                                rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
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

                NoiDungtimkiem = editText.getText().toString();
                adapterRecyclerViewMeoGhiNho
                        = new AdapterRecyclerView_MeoGhiNho(MeoGhiNho_Activity.this,meoGhiNhoDAO.getTimKiem());
                rcv_meoGhiNho.removeItemDecoration(decor);
                decor = new StickyHeaderDecoration(adapterRecyclerViewMeoGhiNho);
                rcv_meoGhiNho.addItemDecoration(decor, 1);
                rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
                editText.setVisibility(View.VISIBLE);
                toolbar.setTitle("Search");
                setSupportActionBar(toolbar);
            }
        });

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoiDungtimkiem = editText.getText().toString();
                adapterRecyclerViewMeoGhiNho
                        = new AdapterRecyclerView_MeoGhiNho(MeoGhiNho_Activity.this,meoGhiNhoDAO.getTimKiem());
                rcv_meoGhiNho.removeItemDecoration(decor);
                decor = new StickyHeaderDecoration(adapterRecyclerViewMeoGhiNho);
                rcv_meoGhiNho.addItemDecoration(decor, 1);
                rcv_meoGhiNho.setAdapter(adapterRecyclerViewMeoGhiNho);
                editText.setVisibility(View.VISIBLE);
                toolbar.setTitle("Search");
                setSupportActionBar(toolbar);
            }
        });
    }
}
