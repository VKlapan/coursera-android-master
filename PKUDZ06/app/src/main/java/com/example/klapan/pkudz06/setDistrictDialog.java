package com.example.klapan.pkudz06;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by akovalenko on 02.10.2015.
 */
public class setDistrictDialog extends DialogFragment {

    String setDistrict;


    public interface TakeDistrict {
        public void takeDistrict (String destrict);
    }

    TakeDistrict tDistrict; //new element of interface

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity); // attach activity to fragment
        try {
            tDistrict = (TakeDistrict) activity; //cast activity to interface, so activity = interface with method takeDistrict
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

          AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title
        builder.setTitle(R.string.dialog_set_district)
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setSingleChoiceItems(R.array.district_array, 1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setDistrict = getResources().getStringArray(R.array.district_array)[which];
                                }
                        })
                .setPositiveButton(R.string.set, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                     tDistrict.takeDistrict(setDistrict); // use method of activity
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }


}