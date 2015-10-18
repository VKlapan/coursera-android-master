package com.example.klapan.pkudz06;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    FragmentItemEdit.backEditedItem frieActivity;

    private Bitmap frImg;
    private String frDist;
    private String frAdr;
    private String frTel;
    private String frNote;
    private int frId;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        frieActivity = (FragmentItemEdit.backEditedItem) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

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

        setHasOptionsMenu(true);

        Log.e("my_log", "VIEW ITEM ID = " + frId);
        return frameView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_view, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_edit) {

            FragmentItemEdit fragment = new FragmentItemEdit();

            fragment.setFrImg(frImg);
            fragment.setFrDist(frDist);
            fragment.setFrAdr(frAdr);
            fragment.setFrTel(frTel);
            fragment.setFrNote(frNote);
            fragment.setFrId(frId);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack("frEdit");
            fragmentTransaction.commit();

            return true;
        } else if (id == R.id.action_delete){

            frieActivity.backEditedItem("DELETE", frImg, frDist, frAdr, frTel, frNote, frId );
            Log.e("my_log", "try delete and back");
            return true;

        } else {
            frieActivity.backEditedItem("CLOSE", frImg, frDist, frAdr, frTel, frNote, frId );
            Log.e("my_log", "closing");
            getFragmentManager().popBackStack();
        }

        return super.onOptionsItemSelected(item);
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

    public void setFrId (int id){
        frId = id;
    }

}
