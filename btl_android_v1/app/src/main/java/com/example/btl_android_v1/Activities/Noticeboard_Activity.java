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

import com.example.btl_android_v1.Adapter.AdapterRecyclerViewNoticeboard;
import com.example.btl_android_v1.Model.Noticeboard_Model;
import com.example.btl_android_v1.R;

import ca.barrenechea.widget.recyclerview.decoration.DividerDecoration;
import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderDecoration;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;


public class Noticeboard_Activity extends AppCompatActivity{
    RecyclerView rcv_bienBao;
    AdapterRecyclerViewNoticeboard adapterRecyclerViewBienBao;
    Noticeboard_Model bienBaoDAO;
    private StickyHeaderDecoration decor;
    Button btn_menu;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienbao);
        setControl();
    }

    public void setControl(){
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toolbar.setTitle("");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        rcv_bienBao = findViewById(R.id.rcv_bienBao);
        rcv_bienBao.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        bienBaoDAO = new Noticeboard_Model(this);
        adapterRecyclerViewBienBao = new AdapterRecyclerViewNoticeboard(this,bienBaoDAO.getListBienBao());
        DividerDecoration divider = new DividerDecoration.Builder(this)
                .setHeight(R.dimen.default_divider_height)
                .setPadding(R.dimen.default_divider_padding)
                .setColorResource(R.color.default_header_color)
                .build();
        rcv_bienBao.setHasFixedSize(true);// tối ưu hóa dữ liệu
        rcv_bienBao.addItemDecoration(divider);
        rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
        decor = new StickyHeaderDecoration(adapterRecyclerViewBienBao);
        rcv_bienBao.addItemDecoration(decor, 1);
        OverScrollDecoratorHelper.setUpOverScroll(rcv_bienBao, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v7.widget.PopupMenu popupMenu
                        = new android.support.v7.widget.PopupMenu(Noticeboard_Activity.this,btn_menu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_bienbao,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new android.support.v7.widget.PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.item_tatca:
                                adapterRecyclerViewBienBao
                                        = new AdapterRecyclerViewNoticeboard(Noticeboard_Activity.this,bienBaoDAO.getListBienBao());
                                rcv_bienBao.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewBienBao);
                                rcv_bienBao.addItemDecoration(decor, 1);
                                rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                                break;
                            case R.id.item_nguyhiem:
                                adapterRecyclerViewBienBao
                                        = new AdapterRecyclerViewNoticeboard(Noticeboard_Activity.this,bienBaoDAO.getListBienBaoNguyHiem());
                                rcv_bienBao.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewBienBao);
                                rcv_bienBao.addItemDecoration(decor, 1);
                                rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                                break;
                            case R.id.item_cam:
                                adapterRecyclerViewBienBao
                                        = new AdapterRecyclerViewNoticeboard(Noticeboard_Activity.this,bienBaoDAO.getListBienBaoCam());
                                rcv_bienBao.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewBienBao);
                                rcv_bienBao.addItemDecoration(decor, 1);
                                rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                                break;
                            case R.id.item_hieulenh:
                                adapterRecyclerViewBienBao
                                        = new AdapterRecyclerViewNoticeboard(Noticeboard_Activity.this,bienBaoDAO.getListBienBaoHieuLenh());
                                rcv_bienBao.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewBienBao);
                                rcv_bienBao.addItemDecoration(decor, 1);
                                rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                                break;
                            case R.id.item_chidan:
                                adapterRecyclerViewBienBao
                                        = new AdapterRecyclerViewNoticeboard(Noticeboard_Activity.this,bienBaoDAO.getListBienBaoChiDan());
                                rcv_bienBao.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewBienBao);
                                rcv_bienBao.addItemDecoration(decor, 1);
                                rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                                break;
                            case R.id.item_phu:
                                adapterRecyclerViewBienBao
                                        = new AdapterRecyclerViewNoticeboard(Noticeboard_Activity.this,bienBaoDAO.getListBienBaoPhu());
                                rcv_bienBao.removeItemDecoration(decor);
                                decor = new StickyHeaderDecoration(adapterRecyclerViewBienBao);
                                rcv_bienBao.addItemDecoration(decor, 1);
                                rcv_bienBao.setAdapter(adapterRecyclerViewBienBao);
                                break;

                        }
                        return true;
                    }
                });
                popupMenu.setGravity(Gravity.CENTER_HORIZONTAL);
                popupMenu.show();
            }
        });
    }
}
