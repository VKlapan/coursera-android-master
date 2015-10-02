package com.example.akovalenko.pku02;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "myTagLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText text1 = (EditText) findViewById(R.id.editText1);
        final Button btnSend = (Button) findViewById(R.id.btnSend);


        View.OnClickListener onClickListenerSend = new View.OnClickListener() {
               @Override
            public void onClick (View view) {

            String textEntry = text1.getText().toString();

                if (textEntry.isEmpty()){
                    Log.d(TAG, "Entry TEXT is empty");
                    Toast toast = Toast.makeText(MainActivity.this, "You must enter something", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Log.d(TAG, "Entry TEXT is: " + textEntry);
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("string_value", textEntry);
                    startActivity(intent);
                }

            }
        };

        btnSend.setOnClickListener(onClickListenerSend);


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

            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}