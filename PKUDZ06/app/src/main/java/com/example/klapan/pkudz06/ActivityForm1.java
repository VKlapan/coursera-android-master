package com.example.klapan.pkudz06;


import android.app.DialogFragment;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityForm1 extends ActionBarActivity implements setDistrictDialog.TakeDistrict {

    Button btnDistr;
    TextView viewTextDistr;
    EditText newAdr;
    EditText newTel;
    EditText newNote;
    ImageView newImg;
    private Bitmap preImg;
    String newDistrict;
    Uri fileUri;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnDistr = (Button) findViewById (R.id.btnDistrict);
        viewTextDistr = (TextView) findViewById (R.id.textViewDistrict);
        newAdr = (EditText) findViewById (R.id.editTextAdr);
        newTel = (EditText) findViewById (R.id.editTextTel);
        newNote = (EditText) findViewById (R.id.editTextNote);
        newImg = (ImageView) findViewById(R.id.imageViewAdd);

        View.OnClickListener onClickListenerImg = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        };

        View.OnLongClickListener onLongClickListenerImg = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick (View v) {
                takeFullPicture();
                return true;
            }
        };

        View.OnClickListener onClickListenerDistr = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSetDistrictDialog();
            }
        };

        newImg.setOnClickListener(onClickListenerImg);
        newImg.setOnLongClickListener(onLongClickListenerImg);
        btnDistr.setOnClickListener(onClickListenerDistr);

    }

    public void takeFullPicture() {

        Log.e("my_log", "try FULL Picture");

        Intent intent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );

        fileUri = getOutputMediaFileUri();
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

        }
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
    public void takeDistrict (String district){
        viewTextDistr.setText(district);
        newDistrict = district;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Log.e("my_log", "try onActivityResult");

            String filePath = fileUri.getPath();
            Log.e("my_log", filePath);
            this.grabImage(newImg);

//            preImg = data.getParcelableExtra("data");
//            newImg.setImageBitmap(preImg);
        }
    }

    public void grabImage(ImageView imageView)
    {
        this.getContentResolver().notifyChange(fileUri, null);
        ContentResolver cr = this.getContentResolver();
        Bitmap bitmap;
        try
        {
            bitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, fileUri);
            imageView.setImageBitmap(bitmap);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT).show();
            Log.d("my_log", "Failed to load", e);
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
            String textNote = newNote.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("string_value_adr", textAdr);
            intent.putExtra("string_value_tel", textTel);
            intent.putExtra("bitmap_value_img", preImg);
            intent.putExtra("string_value_dist", newDistrict);
            intent.putExtra("string_value_note", textNote);
            setResult(RESULT_OK, intent);
            finish();
        }

        Log.e("1", "putExtra");

        return true;
    }

    /** Create a file Uri for saving an image or video */
    private static Uri getOutputMediaFileUri(){
        return Uri.fromFile(getOutputMediaFile());
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "PKUDZ06App");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("my_log", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");

        return mediaFile;
    }
}
