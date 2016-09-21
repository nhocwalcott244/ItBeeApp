package com.example.lovebarca.itbeeapp.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lovebarca.itbeeapp.R;
import com.example.lovebarca.itbeeapp.object.bee;

import java.util.ArrayList;

/**
 * Created by Love Barca on 9/20/2016.
 */
public class beeadapter extends ArrayAdapter<bee>{
    Activity context = null;
    ArrayList<bee> myArray = null;
    int layoutId;
    public beeadapter(Activity context, int layoutId, ArrayList<bee>arr){
        super(context, layoutId,arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if (myArray.size() > 0 && position >= 0) {
            final TextView txtnameofbee = (TextView) convertView.findViewById(R.id.txtNameOfBee);
            final bee bee = myArray.get(position);
            txtnameofbee.setText(bee.getName());


        }
        return convertView;
    }
}
