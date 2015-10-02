package com.example.akovalenko.pkudz03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AFragment extends Fragment {
    private ArrayAdapter<String> adapter;
    private static ArrayList<String> strings = new ArrayList<>(); // data are storing here

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false); // inflate the layout for fragment

        ListView list = (ListView) v.findViewById(R.id.fragment_two_listView);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        list.setAdapter(adapter);

        setHasOptionsMenu(true); // enable menu in this fragment
        return v;
    }

    public void addItem(String newItem) {
        adapter.add(newItem); // add new item to the list
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_second, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                BFragment bFragment = new BFragment(); // create the second fragment
                getActivity().getSupportFragmentManager().beginTransaction() // start transaction
                        .replace(R.id.fragment_container, bFragment) // replace first with new one
                        .addToBackStack(null) // add it to back stack
                        .commit(); // apply changes
                break;
        }
        return true;
    }
}