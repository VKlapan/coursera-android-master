package com.example.akovalenko.pukdz02;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_CODE_NEW_ADD = 1;
    private ArrayList<AddItems> items = new ArrayList<>();
    private MyArrayAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listItems = (ListView) findViewById(R.id.listViewItems);

        myAdapter = new MyArrayAdapter(this, items);
        listItems.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new) {
            Intent intent = new Intent(this, ActivityForm1.class);
            startActivityForResult(intent, REQUEST_CODE_NEW_ADD);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent intentItem){

        if (requestCode == REQUEST_CODE_NEW_ADD && resultCode == RESULT_OK){
            Bitmap img = null;
            try {
                img = intentItem.getParcelableExtra("bitmap_value_img");
            } catch (NullPointerException e){
                Log.e("my_log", "error", e);}

            String adr = intentItem.getStringExtra("string_value_adr");
            String tel = intentItem.getStringExtra("string_value_tel");

            items.add(new AddItems(img,adr,tel));
            myAdapter.notifyDataSetChanged();
        }
    }


}

