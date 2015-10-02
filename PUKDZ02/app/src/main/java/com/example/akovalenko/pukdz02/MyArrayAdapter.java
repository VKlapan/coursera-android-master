package com.example.akovalenko.pukdz02;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MyArrayAdapter extends ArrayAdapter<AddItems> {

    private final Context context;
    private final ArrayList<AddItems> values;

    public MyArrayAdapter(Context context, ArrayList<AddItems> values) {
        super(context, R.layout.list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        ImageView imgView = (ImageView) rowView.findViewById(R.id.imageViewAdd);
        TextView textView1 = (TextView) rowView.findViewById(R.id.textViewAdr);
        TextView textView2 = (TextView) rowView.findViewById(R.id.textViewTel);

        Bitmap itemImg = values.get(position).getImg();
        String itemAdr = values.get(position).getAdr();
        String itemTel = values.get(position).getTel();

        imgView.setImageBitmap(itemImg);
        textView1.setText(itemAdr);
        textView2.setText(itemTel);

        return rowView;
    };

}