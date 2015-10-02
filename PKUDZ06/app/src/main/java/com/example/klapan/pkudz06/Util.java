package com.example.klapan.pkudz06;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by klapan on 9/27/15.
 */
public class Util {


    public static byte [] bitmapToByteArray (Bitmap b){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG,100,baos);
        return baos.toByteArray();
    }

    public static Bitmap byteArrayToBitmap (byte[] bArray){
        return BitmapFactory.decodeByteArray(bArray, 0, bArray.length);
    }
}