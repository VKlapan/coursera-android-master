package com.example.akovalenko.pkud01;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textLogin = (EditText) findViewById(R.id.editTextLogin);
        final EditText textPass = (EditText) findViewById(R.id.editTextPass);
        final Button btnSubmit = (Button) findViewById (R.id.btnSubmit);
        final TextView textResult = (TextView) findViewById(R.id.textViewResult);

        final HashMap<String, String> LoginDB = new HashMap<String, String>();
        LoginDB.put("klapan","klapan15");
        LoginDB.put("vovan","vovan15");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                String login = textLogin.getText().toString();
                String pass = textPass.getText().toString();
                if (login.isEmpty()||pass.isEmpty() ) {
                    textResult.setText("no login or pass");
                }
                else if (LoginDB.containsKey(login)&&LoginDB.get(login).equals(pass)) {
                    textResult.setText("All OK");
                }

                else {
                    textResult.setText("Login or pass incorrect :(");
                }
            }
        };
        btnSubmit.setOnClickListener(onClickListener);

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
