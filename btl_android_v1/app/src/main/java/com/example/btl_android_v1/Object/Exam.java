package com.example.btl_android_v1.Object;


import java.io.Serializable;
import java.util.List;

public class Exam implements Serializable {
    List<Quetion> listCauHoi;

    public Exam(List<Quetion> listCauHoi) {
        this.listCauHoi = listCauHoi;
    }

    public List<Quetion> getListCauHoi() {
        return listCauHoi;
    }

    public void setListCauHoi(List<Quetion> listCauHoi) {
        this.listCauHoi = listCauHoi;
    }
}
