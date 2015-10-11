package com.example.klapan.pkudz06;


import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivityFragments extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_fragments);

        Intent intentFromMain = this.getIntent();

        Bitmap img = intentFromMain.getParcelableExtra("bitmap_value_img");
        String dist = intentFromMain.getStringExtra("string_value_dist");
        String adr = intentFromMain.getStringExtra("string_value_adr");
        String tel = intentFromMain.getStringExtra("string_value_tel");
        String note = intentFromMain.getStringExtra("string_value_note");

        FragmentItemView fragment = new FragmentItemView();

//        FragmentItemView fragment = FragmentItemView.newInstance(dist);

        fragment.setFrImg(img);
        fragment.setFrDist(dist);
        fragment.setFrAdr(adr);
        fragment.setFrTel(tel);
        fragment.setFrNote(note);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

//        ((ImageView) findViewById(R.id.ViewImage)).setImageBitmap(img);
//        ((TextView) findViewById(R.id.ViewDistrict)).setText(dist);
//        ((TextView) fragment.getActivity().findViewById(R.id.ViewAdr)).setText(adr);
//        ((TextView) findViewById(R.id.ViewTel)).setText(tel);
//        ((TextView) findViewById(R.id.ViewNote)).setText(note);

    }


}