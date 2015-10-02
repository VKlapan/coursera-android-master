package com.example.akovalenko.pkudz03;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class BFragment extends Fragment {

    private OnButtonReaction reaction;
    private EditText address;
    private EditText time;
    private EditText description;

    public interface OnButtonReaction { // use it to interact with Activity
        void onButtonReaction(String newItem); // adding new item to the list
    }

    @Override
    public void onAttach(Activity activity) {
        reaction = (OnButtonReaction) activity; // cast Activity to interface, this allows to call method from Activity
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        setHasOptionsMenu(true); // enable menu in fragment

        address = (EditText) view.findViewById(R.id.fragment_one_address);
        time = (EditText) view.findViewById(R.id.fragment_one_time);
        description = (EditText) view.findViewById(R.id.fragment_one_description);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_first, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_apply:
                String result = "";
                if (address.getText().toString().length() > 0)
                    result += address.getText().toString() + " | ";
                if (time.getText().toString().length() > 0)
                    result += time.getText().toString() + " | ";
                if (description.getText().toString().length() > 0)
                    result += description.getText().toString();
                reaction.onButtonReaction(result); // call method from Activity
                break;
        }
        return true;
    }
}