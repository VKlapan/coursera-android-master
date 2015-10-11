package com.example.klapan.pkudz06;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by klapan on 10/10/15.
 */
public class FragmentItemView extends Fragment {

    private ImageView viewImg;
    private TextView viewDistr;
    private TextView viewAdr;
    private TextView viewTel;
    private TextView viewNote;

    private Bitmap frImg;
    private String frDist;
    private String frAdr;
    private String frTel;
    private String frNote;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        Log.e("my_log", "fragment view inflater start");
        View frameView = (View) inflater.inflate(R.layout.fragment_view, container, false);


        viewImg = (ImageView) frameView.findViewById(R.id.ViewImage);
        viewDistr = (TextView) frameView.findViewById(R.id.ViewDistrict);
        viewAdr = (TextView) frameView.findViewById(R.id.ViewAdr);
        viewTel = (TextView) frameView.findViewById(R.id.ViewTel);
        viewNote = (TextView) frameView.findViewById(R.id.ViewNote);

//        frDist = this.getArguments().getString("DISTR");

        viewImg.setImageBitmap(frImg);
        viewDistr.setText("Distriction: " + frDist);
        viewAdr.setText("Address:" + frAdr);
        viewTel.setText("Tel: " + frTel);
        viewNote.setText("Note: " + frNote);

        return frameView;
    }

    public static FragmentItemView newInstance(String text){
        FragmentItemView fragment = new FragmentItemView();
        Bundle bundle = new Bundle();
        bundle.putString("DISTR", text);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setFrImg (Bitmap img){
        frImg = img;
    }

    public void setFrDist (String text){
        frDist = text;
    }

    public void setFrAdr (String text){
        frAdr = text;
    }

    public void setFrTel (String text){
        frTel = text;
    }

    public void setFrNote (String text){
        frNote = text;
    }

}
