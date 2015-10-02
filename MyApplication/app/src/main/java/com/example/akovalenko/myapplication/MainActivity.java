package com.example.akovalenko.myapplication;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    TextView textView;
    Button button3;
    Button button4;
    Button button5;
    ImageView imageView;
//    Drawable my_icon = (Drawable) getResources(R.drawable.ic_accessibility_black_48dp);

    private static final String TAG = "myTagLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Находим элементы: Image");
        imageView = (ImageView) findViewById(R.id.imageView1);

        Log.d(TAG, "Находим элементы: Text");
        textView = (TextView) findViewById (R.id.textView2);

        Log.d(TAG, "Находим элементы: Buttons");
        button3 = (Button) findViewById (R.id.button3);
        button4 = (Button) findViewById (R.id.button4);
        button5 = (Button) findViewById (R.id.button5);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick (View view){
                switch (view.getId()) {
                    case R.id.button3:
                        Log.d(TAG, "Нажата Кнопка 3");
                        textView.setText("111111111111");

                        Toast toast = Toast.makeText(MainActivity.this, "ВАХ, кнопка 3", Toast.LENGTH_LONG);
                        LinearLayout toastView = (LinearLayout) toast.getView();
                        ImageView toastImage = new ImageView (MainActivity.this);
                        toastImage.setImageResource(R.drawable.ic_add_shopping_cart_black_48dp);
                        toastView.addView(toastImage, 0);
                        toast.show();

                    break;

                    case R.id.button4:
                        Log.d(TAG, "Нажата Кнопка 4");
                        try {
                            float i = 30/4;
                            textView.setText("" + i);
                            } catch (Exception e) {
                                Log.d(TAG, "Деление на ноль :-(", e);
                            }
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_account_balance_black_48dp));
                    break;

                    case R.id.button5:
                        Log.d(TAG, "Нажата Кнопка 5");
                        textView.setText(R.string.textBtn5);
                        break;

                }
            }
        };
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);

        textView.setOnClickListener(
                new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "Нажат текст для замены подписи кнопки 3");
                        button3.setText("333");
                                        }
                }
        );



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
