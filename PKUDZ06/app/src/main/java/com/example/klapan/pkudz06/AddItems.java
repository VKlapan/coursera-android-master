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
    private String addNote;
    private String addDist;
    private String addTel;

    //AddItems SQL Table Name

    public static final String TABLE_NAME = "ads";

    //AddItems SQL Table Columns Name

    public static final String KEY_ID = "id";
    public static final String KEY_ADR = "adr";
    public static final String KEY_NOTE = "note";
    public static final String KEY_DIST = "dist";
    public static final String KEY_TEL = "tel";
    public static final String KEY_IMG = "img";

    public static final String[]    COLUMNS = {KEY_ID, KEY_ADR, KEY_NOTE, KEY_DIST, KEY_TEL, KEY_IMG};

    public AddItems() {
    }

    public AddItems (Bitmap i, String a, String n, String d, String t){
        this.addImg = i;
        this.addAdr = a;
        this.addNote = n;
        this.addDist = d;
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

    public String getNote () {
        return addNote;
    }

    public String getDist () {
        return addDist;
    }

    public String getTel () {
        return addTel;
    }

    public void setImg (Bitmap addImg) { this.addImg = addImg; }

    public void setAdr (String addAdr) {
        this.addAdr = addAdr;
    }

    public void setNote (String addNote) {
        this.addNote = addNote;
    }

    public void setDist (String addDistr) {
        this.addDist = addDistr;
    }

    public void setTel (String addTel) {
        this.addTel = addTel;
    }

}