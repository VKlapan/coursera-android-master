package com.example.klapan.pkudz06;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by klapan on 10/10/15.
 */
public class FragmentItemEdit extends Fragment {

    private ImageView viewImg;
    private TextView viewDistr;
    private EditText viewAdr;
    private EditText viewTel;
    private EditText viewNote;
    backEditedItem frieActivity;

    private Bitmap frImg;
    private String frDist;
    private String frAdr;
    private String frTel;
    private String frNote;
    private int frId;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        frieActivity = (backEditedItem) activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        Log.e("my_log", "fragmentEdit view inflater start");
        View frameView = (View) inflater.inflate(R.layout.fragment_edit, container, false);


        viewImg = (ImageView) frameView.findViewById(R.id.imageItemEdit);
        viewDistr = (TextView) frameView.findViewById(R.id.districtItemEdit);
        viewAdr = (EditText) frameView.findViewById(R.id.adrItemEdit);
        viewTel = (EditText) frameView.findViewById(R.id.telItemEdit);
        viewNote = (EditText) frameView.findViewById(R.id.noteItemEdit);

//        frDist = this.getArguments().getString("DISTR");

        viewImg.setImageBitmap(frImg);
        viewDistr.setText(frDist);
        viewAdr.setText(frAdr);
        viewTel.setText(frTel);
        viewNote.setText(frNote);

        setHasOptionsMenu(true);

        return frameView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_edit_save  ) {

            frieActivity.backEditedItem("UPDATE", frImg, frDist, viewAdr.getText().toString(), viewTel.getText().toString(), viewNote.getText().toString(), frId );
            Log.e("my_log", "try save and back");
            getFragmentManager().popBackStack();

//            getFragmentManager().beginTransaction().remove(this);
//            return true;
        } else if (id == R.id.action_edit_cancel) {
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


    public interface backEditedItem {
        void backEditedItem (String flag, Bitmap i, String d, String a, String t, String n, int id);
    }
}
