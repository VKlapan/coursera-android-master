package com.example.akovalenko.pkud01;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ActivityChat extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        final EditText textMessage = (EditText) findViewById(R.id.editTextMessage);
        final Button btnClear = (Button) findViewById(R.id.btnClear);
        final Button btnSend = (Button) findViewById(R.id.btnSend);
        final ListView listChart = (ListView) findViewById(R.id.listViewChat);

        final ArrayList<String> list = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        listChart.setAdapter(adapter);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textMessage.getText().toString();
                list.add("VOVAN: " + message);
                adapter.notifyDataSetChanged();
            }

            ;
        };

        btnSend.setOnClickListener(onClickListener);

        View.OnClickListener onClickListenerClear = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();
                adapter.notifyDataSetChanged();
            }

            ;
        };

        btnClear.setOnClickListener(onClickListenerClear);


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
