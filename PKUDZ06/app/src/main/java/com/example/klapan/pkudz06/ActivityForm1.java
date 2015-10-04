package com.example.klapan.pkudz06;


import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ActivityForm1 extends ActionBarActivity{

    EditText newAdr;
    EditText newTel;
    EditText newNote;
    ImageView newImg;
    private Bitmap preImg;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        newAdr = (EditText) findViewById (R.id.editTextAdr);
        newTel = (EditText) findViewById (R.id.editTextTel);
        newNote = (EditText) findViewById (R.id.editTextNote);
        newImg = (ImageView) findViewById(R.id.imageViewAdd);

        View.OnClickListener onClickListenerImg = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                takePicture();
                showSetDistrictDialog();
            }
        };

        newImg.setOnClickListener(onClickListenerImg);

    }

    public void takePicture() {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

        }
    }

    public void showSetDistrictDialog() {
        DialogFragment dialog = new setDistrictDialog();
        dialog.show(getFragmentManager(), "districts");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            preImg = data.getParcelableExtra("data");
            newImg.setImageBitmap(preImg);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_form1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_save) {
            String textAdr = newAdr.getText().toString();
            String textTel = newTel.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("string_value_adr", textAdr);
            intent.putExtra("string_value_tel", textTel);
            intent.putExtra("bitmap_value_img", preImg);
            setResult(RESULT_OK, intent);
            finish();
        }

        Log.e("1", "putExtra");

        return true;
    }
}
