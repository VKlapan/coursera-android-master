package com.example.klapan.pkudz06;


import android.graphics.Bitmap;
import android.media.Image;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.BitSet;

public class AddItems {
    private int id;
    private Bitmap addImg;
    private String addAdr;
    private String addTel;

    //AddItems SQL Table Name

    public static final String TABLE_NAME = "ads";

    //AddItems SQL Table Columns Name

    public static final String KEY_ID = "id";
    public static final String KEY_ADR = "adr";
    public static final String KEY_TEL = "tel";
    public static final String KEY_IMG = "img";

    public static final String[]    COLUMNS = {KEY_ID, KEY_ADR, KEY_TEL, KEY_IMG};

    public AddItems() {
    }

    public AddItems (Bitmap i, String a, String t){
        this.addImg = i;
        this.addAdr = a;
        this.addTel = t;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Bitmap getImg () {
        return addImg;
    }

    public String getAdr () {
        return addAdr;
    }

    public String getTel () {
        return addTel;
    }

    public void setImg (Bitmap addImg) { this.addImg = addImg; }

    public void setAdr (String addAdr) {
        this.addAdr = addAdr;
    }

    public void setTel (String addTel) {
        this.addTel = addTel;
    }

}