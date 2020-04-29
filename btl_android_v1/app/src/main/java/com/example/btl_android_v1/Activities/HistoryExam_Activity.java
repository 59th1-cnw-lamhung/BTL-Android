package com.example.btl_android_v1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.btl_android_v1.Adapter.AdapterRecyclerViewHistory;
import com.example.btl_android_v1.MyItemDecoration;
import com.example.btl_android_v1.Object.Exam;
import com.example.btl_android_v1.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class HistoryExam_Activity extends AppCompatActivity {
    RecyclerView rcv_lichSuBaiThi;
    AdapterRecyclerViewHistory adapterRecyclerViewLichSuBaiThi;
    List<Exam> listDeThi;
    Toolbar toolbar;
    Button btn_delete;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichsubaithi);

        btn_delete = findViewById(R.id.btn_delete);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        rcv_lichSuBaiThi = findViewById(R.id.rcv_lichSuBaiThi);
        listDeThi = docFile("lichsu.txt");
        adapterRecyclerViewLichSuBaiThi = new AdapterRecyclerViewHistory(this,listDeThi);
        rcv_lichSuBaiThi.setLayoutManager(new GridLayoutManager(this,4));
        rcv_lichSuBaiThi.addItemDecoration(new MyItemDecoration(this, R.dimen.item_offset));
        rcv_lichSuBaiThi.setAdapter(adapterRecyclerViewLichSuBaiThi);
        Log.d("SIZE",listDeThi.size()+"");

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleFile("lichsu.txt");
                Intent intent_load =new Intent(HistoryExam_Activity.this, HistoryExam_Activity.class);
                startActivity(intent_load);
            }
        });

    }


    public List<Exam> docFile(final String fileName){
        List<Exam> listDeThi = new ArrayList<>();

        try {
            File file = getFileStreamPath(fileName);
            if (file==null||!file.exists()){
                file = new File(fileName);
            }
            else {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                listDeThi = (List<Exam>) ois.readObject();
                ois.close();
                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return listDeThi;
    }

    public List<Exam> deleFile(final String fileName){
        File file = getFileStreamPath(fileName);
        file.delete();

        return listDeThi;
    }


}
