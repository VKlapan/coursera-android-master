package com.example.klapan.pkudz06;


import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_CODE_NEW_ADD = 1;
    private static final int REQUEST_CODE_EDIT_ITEM = 2;
    private ArrayList<AddItems> items;
    private  ListView listItems;
    private MyArrayAdapter myAdapter;
    private AddSQLiteOpenHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new AddSQLiteOpenHelper(this);

        items = db.getAllAddItemsFromSql();

        listItems = (ListView) findViewById(R.id.listViewItems);

        myAdapter = new MyArrayAdapter(this, items);
        listItems.setAdapter(myAdapter);

        AdapterView.OnItemClickListener onClickListenerListItems = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Log.e("my_log", "item click");

                AddItems vi; // view Item
                vi = db.getAddItemsFromSql(position +1);
                Bitmap viImg = vi.getImg();
                String viDistr = vi.getDist();
                String viAdr = vi.getAdr();
                String viTel = vi.getTel();
                String viNote = vi.getNote();
                int viId = vi.getId();

                Intent intent = new Intent(MainActivity.this, MainActivityFragments.class);

                intent.putExtra("bitmap_value_img", viImg);
                intent.putExtra("string_value_dist", viDistr);
                intent.putExtra("string_value_adr", viAdr);
                intent.putExtra("string_value_tel", viTel);
                intent.putExtra("string_value_note", viNote);
                intent.putExtra("int_value_id", viId);

                startActivityForResult(intent, REQUEST_CODE_EDIT_ITEM);
            }
        };

        listItems.setOnItemClickListener(onClickListenerListItems);

        AdapterView.OnItemLongClickListener onLongClickListenerListItems = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick (AdapterView<?> parent, View view, int position, long id) {
                Log.e("my_log", "item long click");
                return true;
            }
        };

        listItems.setOnItemLongClickListener(onLongClickListenerListItems);


    }

    public void showSetDistrictDialog() {
        DialogFragment dialog = new setDistrictDialog();
        dialog.show(getFragmentManager(), "districts");
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
            String note = intentItem.getStringExtra("string_value_note");
            String dist = intentItem.getStringExtra("string_value_dist");
            String tel = intentItem.getStringExtra("string_value_tel");

            AddItems ai = new AddItems(img, adr, note, dist, tel);
            Log.e("1","new AddItems");

            db.addAddItemsToSql(ai);
            items.add(ai);

            Log.e("1", "added new AddItems to SQL");

            myAdapter.notifyDataSetChanged();

        } else if (requestCode == REQUEST_CODE_EDIT_ITEM && resultCode == RESULT_OK){

            String flag = intentItem.getStringExtra("string_value_flag");

            if (flag.equalsIgnoreCase("DELETE")){
                Log.e("1", "DELETE Item ID " + intentItem.getIntExtra("int_value_id", 0));

            } else if (flag.equalsIgnoreCase("UPDATE")){
                Bitmap img = null;
                try {
                    img = intentItem.getParcelableExtra("bitmap_value_img");
                } catch (NullPointerException e){
                    Log.e("my_log", "error", e);}

                String dist = intentItem.getStringExtra("string_value_dist");
                String adr = intentItem.getStringExtra("string_value_adr");
                String tel = intentItem.getStringExtra("string_value_tel");
                String note = intentItem.getStringExtra("string_value_note");
                int id = intentItem.getIntExtra("int_value_id", 0);

                Log.e("1", "UPDATE ITEM: " + id + ". DIST: " + dist + ". ADR: " + adr + ". TEL: " + tel + ". NOTE: " + note);

            } else {
                Log.e("1", "CLOSE");

            }

        }
    }


}