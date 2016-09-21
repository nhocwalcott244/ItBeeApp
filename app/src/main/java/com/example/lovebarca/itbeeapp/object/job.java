package com.example.lovebarca.itbeeapp.object;

import android.widget.Button;

/**
 * Created by Love Barca on 9/20/2016.
 */
public class job {
    private String salaryofjob;
    private String nameofjob;
    private String addressofjob;
    private Button btnnote;

    public String getSalaryofjob() {
        return salaryofjob;
    }

    public void setSalaryofjob(String salaryofjob) {
        this.salaryofjob = salaryofjob;
    }

    public String getNameofjob() {
        return nameofjob;
    }

    public void setNameofjob(String nameofjob) {
        this.nameofjob = nameofjob;
    }

    public String getAddressofjob() {
        return addressofjob;
    }

    public void setAddressofjob(String addressofjob) {
        this.addressofjob = addressofjob;
    }

    public Button getBtnnote() {
        return btnnote;
    }

    public void setBtnnote(Button btnnote) {
        this.btnnote = btnnote;
    }

    @Override
    public String toString() {
        return this.nameofjob+" "+ this.salaryofjob;
    }
}
