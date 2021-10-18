package com.techtorial.ventraApp;

import java.util.Random;

public class VentraCard {

    String fullName = "ass";
    String phoneNumber;
    String email;
    long cardNumber = VentraCard.createCardNumber();

    public VentraCard(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
/*
    1- Create private instance variables for passenger fullName, phoneNumber, email, cardNumber
    2- Create getter and setter for instance variables
    3- Create the constructor to set the value to the instance variables
    4- Create one method to create the 16 digit cardNumber. Return type must be long and it will return 16 digit unique number
     */

    public VentraCard createCard(String fullName, String phoneNumber, String email){ //

        VentraCard newCard = new VentraCard(fullName,phoneNumber,email);

        return newCard;
    }

    public static long createCardNumber(){//DONE
        /*
        this method needs to return the 16 digit card number
         */
        Random rand = new Random();
        String out ="";
        for (int i = 0; i < 16; i++) {
            int digit = rand.nextInt(8)+1;
            out+= ""+digit;
        }

        long outLong = Long.parseLong(out);

        return outLong;

    }
}
