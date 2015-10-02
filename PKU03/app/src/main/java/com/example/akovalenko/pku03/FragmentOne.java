package com.example.akovalenko.pku03;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by klapan on 15.09.15.
 */
public class FragmentOne extends Fragment {

    TextView textTitle;
    ImageView imgView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,
                container, false);

        textTitle = (TextView) view.findViewById(R.id.textView);
        imgView = (ImageView) view.findViewById(R.id.imgView);

        return view;
    }

    public interface OnButton{
        void onButton();
    }
}