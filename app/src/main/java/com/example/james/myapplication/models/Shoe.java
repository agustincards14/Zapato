package com.example.james.myapplication.models;

import com.google.firebase.database.DataSnapshot;

import java.io.Serializable;

//import com.zapato.zapato.Network.FirebaseManager;

/**
 * Created by agustincards on 3/21/18.
 */

public class Shoe implements Serializable {

    public String shoeCondition;
    public String brand;
    public String name;
    public double size;
    public double price;
    public String gender;       //male, female, unisex
    public String shoeType;     //running, basketball, soccer
    public String shoeColor;    //red, black
    public String sellerID;     // sellerID is used for fetching seller's info later
    public String shoeID;       // each shoe has its own unique ID
    public String shoeImageUrl; //url to Firebase storage
    public String description;

    //constructor with basic shoe info input
    public Shoe(String shoeName, double shoeSize, double shoePrice){
        this.name = shoeName;
        this.size = shoeSize;
        this.price = shoePrice;

        //TODO temporary default attribute,
        this.brand = "Nike";
        this.shoeType = "Running";
        this.gender = "Unisex";
        this.shoeColor = "Red";
        this.shoeCondition = "New";
        this.description = "Only worn a couple times!";
    }

    //constructor with firebase's returned DataSnapshot input
    public Shoe(DataSnapshot snapshot) {
        this.name = snapshot.child("name").getValue().toString();
        this.sellerID = snapshot.child("sellerID").getValue().toString();
        this.shoeID = snapshot.child("shoeID").getValue().toString();
        this.name = snapshot.child("name").getValue().toString();
        this.brand = snapshot.child("brand").getValue().toString();
        this.gender = snapshot.child("gender").getValue().toString();
        this.shoeType = snapshot.child("shoeType").getValue().toString();
        this.shoeImageUrl = snapshot.child("shoeImageUrl").getValue().toString();
        this.shoeCondition = snapshot.child("shoeCondition").getValue().toString();
        //convert snapshot value to Double
        this.size = Double.valueOf(String.valueOf(snapshot.child("size").getValue()));
        this.price = Double.valueOf(String.valueOf(snapshot.child("price").getValue()));
    }

    public String getName()
    {
        return name;
    }
    public String getSellerId()
    {
        return sellerID;
    }
    public String getShoeId()
    {
        return shoeID;
    }
    public String getBrand()
    {
        return brand;
    }
    public String getGender()
    {
        return gender;
    }
    public String getShoeType()
    {
        return shoeType;
    }
    public String getShoeImageUrl(){ return shoeImageUrl; }
    public String getShoeCondition()
    {
        return shoeCondition;
    }
    public double getSize()
    {
        return size;
    }
    public double getPrice()
    {
        return price;
    }
}
