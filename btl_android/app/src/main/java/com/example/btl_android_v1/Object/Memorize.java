package com.example.btl_android_v1.Object;

public class Memorize {
    int id;
    int loai;
    String noiDung;

    public Memorize(int id, int loai, String noiDung) {
        this.id = id;
        this.loai = loai;
        this.noiDung = noiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
