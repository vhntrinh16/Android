package com.example.exercise;

public class UserContact extends MainActivity{
    private String name;
    private String phoneNumber;
    private String address;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserContact(int Id, String mName, String mPhoneNumber, String mAddress) {
        this.id = Id;
        this.name = mName;
        this.phoneNumber = mPhoneNumber;
        this.address = mAddress;
    }
}

