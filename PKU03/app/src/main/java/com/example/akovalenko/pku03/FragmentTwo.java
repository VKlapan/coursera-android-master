package com.example.akovalenko.pku03;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by klapan on 15.09.15.
 */
public class FragmentTwo extends Fragment {
    Button titleButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,
                container, false);

        titleButton = (Button) view.findViewById(R.id.button);
        return view;
    }

    public interface OnButton{
        void onButton();
    }


}

