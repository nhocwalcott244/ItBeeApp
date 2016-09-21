package com.example.lovebarca.itbeeapp.object;

/**
 * Created by Love Barca on 9/20/2016.
 */
public class company {
    private String NameOfCompany;
    private String TimeOfCreate;
    private String AddressOfCompany;

    public String getNameOfCompany() {
        return NameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        NameOfCompany = nameOfCompany;
    }

    public String getTimeOfCreate() {
        return TimeOfCreate;
    }

    public void setTimeOfCreate(String timeOfCreate) {
        TimeOfCreate = timeOfCreate;
    }

    public String getAddressOfCompany() {
        return AddressOfCompany;
    }

    public void setAddressOfCompany(String addressOfCompany) {
        AddressOfCompany = addressOfCompany;
    }

    @Override
    public String toString() {
        return this.getNameOfCompany();
    }
}
