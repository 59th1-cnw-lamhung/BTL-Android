package com.example.btl_android_v1.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.example.btl_android_v1.Adapter.AdapterRecyclerView_LichSu;
import com.example.btl_android_v1.Adapter.AdapterRecyclerView_DapAn;
import com.example.btl_android_v1.Model.CauHoi_Model;
import com.example.btl_android_v1.Object.CauHoi;
import com.example.btl_android_v1.R;

import java.util.ArrayList;
import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

import static com.example.btl_android_v1.Activities.ThiSatHach1_Activity.SIZE;
import static com.example.btl_android_v1.Activities.ThiSatHach1_Activity.checkDungSai;


public class DapAn_Activity extends AppCompatActivity {
    RecyclerView rcv_xemDapAn;
    CauHoi_Model cauHoiDAO;
    public static List<CauHoi> list;
    List<CauHoi> listCauHoi = new ArrayList<CauHoi>();
    AdapterRecyclerView_DapAn adapterRecyclerViewXemDapAn;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xemlaidapan);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        rcv_xemDapAn = findViewById(R.id.rcv_xemDapAn);
        cauHoiDAO = new CauHoi_Model(this);
        listCauHoi = cauHoiDAO.getListCauHoi();
        list = new ArrayList<>();
        if (getIntent().getCharExtra("from",' ')=='l') {
            list = AdapterRecyclerView_LichSu.getListCauHoi();
            adapterRecyclerViewXemDapAn = new AdapterRecyclerView_DapAn(this,list,checkDungSai,'l');
        }
        else {
            for (int i=0;i<SIZE;i++){
                this.list.add(ThiSatHach1_Activity.list.get(i));
            }
            adapterRecyclerViewXemDapAn = new AdapterRecyclerView_DapAn(this,list,checkDungSai,'t');
        }
        rcv_xemDapAn.setAdapter(adapterRecyclerViewXemDapAn);
        rcv_xemDapAn.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        OverScrollDecoratorHelper.setUpOverScroll(rcv_xemDapAn, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        RecyclerViewHeader header = findViewById(R.id.header);
        header.attachTo(rcv_xemDapAn);
    }
}
