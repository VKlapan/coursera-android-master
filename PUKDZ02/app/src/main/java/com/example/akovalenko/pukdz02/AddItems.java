package com.example.akovalenko.pukdz02;

import android.graphics.Bitmap;
import android.media.Image;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.BitSet;

public class AddItems {
    private Bitmap addImg;
    private String addAdr;
    private String addTel;

    public AddItems() {
    }

    public AddItems (Bitmap i, String a, String t){
        this.addImg = i;
        this.addAdr = a;
        this.addTel = t;
        }

    public Bitmap getImg () {
        return addImg;
    }

    public String getAdr () {
        return addAdr;
    }

    public String getTel () {
        return addTel;
    }

    public void setImg () {
        this.addImg = addImg;
    }

    public void setAdr () {
        this.addAdr = addAdr;
    }

    public void setTel () {
        this.addTel = addTel;
    }

}
