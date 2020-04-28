package com.example.btl_android_v1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.btl_android_v1.R;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;


public class Practice1_Activity extends AppCompatActivity {
    TextView tv_kinhNghiemThiA;
    android.support.v7.widget.Toolbar toolbar;

    int dem = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meothuchanha);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        tv_kinhNghiemThiA = findViewById(R.id.tv_kinhNghiemThiA);
        tv_kinhNghiemThiA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Practice1_Activity.this, Experience1_Activity.class);
                startActivity(intent);
                MainActivity.dem9++;
                if (MainActivity.dem9==3 || MainActivity.checkTime){
                    MainActivity.dem9 = 0;
                    MainActivity.checkTime = false;

                }
            }
        });
        ScrollView scrollView = findViewById(R.id.scrollView);
        OverScrollDecoratorHelper.setUpOverScroll(scrollView);
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (!mInterstitialAd.isLoaded())loadInterstitialAd();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (!mInterstitialAd.isLoaded())loadInterstitialAd();
//    }
}
