package com.example.wordapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Gridadapter extends BaseAdapter {

    Context context;
    private final String[] values;
    private final int[] images;
    View view;
    LayoutInflater layoutInflater;

public Gridadapter(Context context,int[] images,String[] values){

    this.context=context;
    this.values=values;
    this.images=images;


}


    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return values[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
   public View getView(int position, View convertView, ViewGroup parent) {

    View gridview=convertView;


        if(convertView==null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            gridview = layoutInflater.inflate(R.layout.custom_layout, null);

        }
            ImageView image= (ImageView) gridview.findViewById(R.id.icons);
            TextView value= (TextView) gridview.findViewById(R.id.letters);


            image.setImageResource(images[position]);
            value.setText(values[position]);




        return gridview;

    }
}
