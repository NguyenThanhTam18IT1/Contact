package com.example.contact.Model;

public class Contact {
    private boolean Gender;
    private String mName;
    private String mNumber;

    public Contact(boolean gender, String mName, String mNumber) {
        Gender = gender;
        this.mName = mName;
        this.mNumber = mNumber;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }
}