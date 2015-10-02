package com.example.akovalenko.pkudz03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BFragment.OnButtonReaction {

    private AFragment aFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aFragment = new AFragment(); // Create first fragment and set it into Activity
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, aFragment)
                .commit();
    }

    @Override
    public void onButtonReaction(String newItem) { // realization of interface
        aFragment.addItem(newItem);
        getSupportFragmentManager().popBackStack(); // kill the last fragment and show previous for user
    }
}