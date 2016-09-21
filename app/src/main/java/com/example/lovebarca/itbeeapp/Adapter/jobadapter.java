package com.example.lovebarca.itbeeapp.Adapter;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovebarca.itbeeapp.R;
import com.example.lovebarca.itbeeapp.object.company;
import com.example.lovebarca.itbeeapp.object.job;

import java.util.ArrayList;

/**
 * Created by Love Barca on 9/20/2016.
 */
public class jobadapter extends ArrayAdapter<job> {
    Activity context = null;
    ArrayList<job> myArray = null;
    int layoutId;

    public jobadapter(Activity context, int layoutId, ArrayList<job> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if (myArray.size() > 0 && position >= 0) {
           // final TextView txtTitle = (TextView)convertView.findViewById(R.id.txtTitle);
            final  TextView txtSalary = (TextView) convertView.findViewById(R.id.txtSalary);
            final TextView txtNameOfJob = (TextView) convertView.findViewById(R.id.txtNameOfJob);
            final TextView txtAddressOfJob = (TextView) convertView.findViewById(R.id.txtAddressOfJob);
            final ImageView imgJob = (ImageView)convertView.findViewById(R.id.imgJog);
            final job jog = myArray.get(position);
            txtNameOfJob.setText(jog.getNameofjob());
            txtAddressOfJob.setText(jog.getAddressofjob());
            txtSalary.setText(jog.getSalaryofjob());
            imgJob.setImageResource(R.drawable.company);
        }
        return convertView;
    }
}