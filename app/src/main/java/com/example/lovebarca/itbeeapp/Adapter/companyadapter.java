package com.example.lovebarca.itbeeapp.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lovebarca.itbeeapp.R;
import com.example.lovebarca.itbeeapp.object.bee;
import com.example.lovebarca.itbeeapp.object.company;

import java.util.ArrayList;

/**
 * Created by Love Barca on 9/20/2016.
 */
public class companyadapter extends ArrayAdapter<company> {
    Activity context = null;
    ArrayList<company>myArray = null;
    int layoutId;
    public companyadapter(Activity context, int layoutId, ArrayList<company>arr){
        super(context, layoutId,arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if (myArray.size() > 0 && position >= 0) {
            final TextView txtHour = (TextView)convertView.findViewById(R.id.txtHour) ;
            final TextView txtNameOfCompany= (TextView)convertView.findViewById(R.id.txtNameOfCompany);
            final TextView txtAddressOfCompany = (TextView) convertView.findViewById(R.id.txtAddressOfCompany);
            final company company = myArray.get(position);
            txtHour.setText(company.getTimeOfCreate());
            txtNameOfCompany.setText(company.getNameOfCompany());
            txtAddressOfCompany.setText(company.getAddressOfCompany());
        }
        return convertView;
    }
}
