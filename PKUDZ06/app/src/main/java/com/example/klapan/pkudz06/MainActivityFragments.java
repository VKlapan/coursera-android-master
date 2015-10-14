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


public class MainActivityFragments extends ActionBarActivity implements FragmentItemEdit.backEditedItem {

    int id;

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
        id = intentFromMain.getIntExtra("int_value_id", 0);

        FragmentItemView fragment = new FragmentItemView();

//        FragmentItemView fragment = FragmentItemView.newInstance(dist);

        fragment.setFrImg(img);
        fragment.setFrDist(dist);
        fragment.setFrAdr(adr);
        fragment.setFrTel(tel);
        fragment.setFrNote(note);
        fragment.setFrId(id);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack("frView");
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

//        ((ImageView) findViewById(R.id.ViewImage)).setImageBitmap(img);
//        ((TextView) findViewById(R.id.ViewDistrict)).setText(dist);
//        ((TextView) fragment.getActivity().findViewById(R.id.ViewAdr)).setText(adr);
//        ((TextView) findViewById(R.id.ViewTel)).setText(tel);
//        ((TextView) findViewById(R.id.ViewNote)).setText(note);

    }

    public void backEditedItem (String flag, Bitmap i, String d, String a, String t, String n, int id){
        Log.e("my_log", "Back trough ActivityFragments: " + flag);

        Intent intent = new Intent();


        if (flag.equalsIgnoreCase("DELETE")){
            intent.putExtra("string_value_flag", "delete");
            intent.putExtra("int_value_id", id);

        } else if (flag.equalsIgnoreCase("UPDATE")){
            intent.putExtra("string_value_flag", "update");
            intent.putExtra("string_value_adr", a);
            intent.putExtra("string_value_tel", t);
            intent.putExtra("bitmap_value_img", i);
            intent.putExtra("string_value_dist", d);
            intent.putExtra("string_value_note", n);
            intent.putExtra("int_value_id", id);

        } else {
            intent.putExtra("string_value_flag", "close");
        }       ;
        setResult(RESULT_OK, intent);

        finish();
    };

}