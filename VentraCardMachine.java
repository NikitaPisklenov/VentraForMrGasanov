package com.techtorial.ventraApp;

import java.util.ArrayList;
import java.util.Scanner;

public class VentraCardMachine {

    private String location;
    private ArrayList<VentraCard> allCards;

    public VentraCardMachine(String location){
        this.location=location;
        this.allCards=new ArrayList<VentraCard>();
    }

    public ArrayList<VentraCard> getAllCards() {
        return allCards;
    }

//    public boolean addCard(VentraCard card){
//        /*
//         This method is taking the parameter as a VentraCard.
//         if this VentraCard is not registered before this method will add the VentraCard to the allCards(ArrayList).
//         Using VentraCard cardNumber you can verify that the card is in allCards or not
//         */
//        return false;
//    }

    public void printCardzInfo(ArrayList <VentraCard> carrdz){


        for (VentraCard card : carrdz) {
            System.out.print(card.cardNumber +" : "+ card.fullName+ " : "+card.phoneNumber+" : "+card.email);
            System.out.println();
            System.out.println("=======");
        }

        /*
         This method is taking one parameter as a list of cards and it will print all the card number
         which is available in this list
         */
    }


    public void updateCardInfo(long CardNumber,String fullName, String phoneNumber, String email){

     for (VentraCard card : VentraAppRunner.machine.getAllCards()) {

         String oldName = card.fullName;
         String opldphomeNumber = card.phoneNumber;
         String oldEmail = card.email;

         if (card.cardNumber==CardNumber) {

             card.email = email;
             card.phoneNumber =phoneNumber;
             card.fullName = fullName;

             System.out.println("Card succesfully updated");
             System.out.println("For the card #"+CardNumber+" this changes were implemented");
             System.out.println(oldEmail+" is changed for "+email);
             System.out.println(opldphomeNumber+" is changed for "+phoneNumber);
             System.out.println(oldName+" is changed for "+fullName);
             System.out.println("Your new card number info is : Full Name "+fullName + " Phone# "+phoneNumber +" Email "+email);
         }
     }


        /*
        This method is taking two parameter oldCardNumber and it will replace this card with newCard.
        */

    }

    public void updateSingleInfoParameter (long cardNumber, String option) {

        Scanner inputs = new Scanner(System.in);

        for (VentraCard card : getAllCards()) {

            if (cardNumber == card.cardNumber) {
                if (option.equalsIgnoreCase("email")) {

                    System.out.println("Please enter new email");

                    card.email = inputs.nextLine();

                    System.out.println("New email is " + card.email);
                }
                if (option.equalsIgnoreCase("name")) {

                    System.out.println("Please enter new Full Name ");

                    card.fullName = inputs.nextLine();

                    System.out.println("New Full Name is" + card.fullName);

                }
                if (option.equalsIgnoreCase("phone")) {

                    System.out.println("Please enter new Phone number ");

                    card.phoneNumber = inputs.nextLine();


                    System.out.println("New phone number is" + card.phoneNumber);

                }

            }



        }
    }


    public  void replaceExistingCarNumber (long oldCard) {

        long oldHolder = oldCard ; // happy path to test
        long newNumber = VentraCard.createCardNumber();

        for (VentraCard card : getAllCards()) {

            if (oldCard == card.cardNumber) {


                card.cardNumber = newNumber;

            }

        }
        System.out.println("Card number successfully changed from #"+oldHolder+"to # "+ newNumber);

    }

    public void searchCardByPhone (String phoneNumber) {


       //String phoneDigitsonly = phoneNumber.replaceAll("[^0-9]", "");

       for (VentraCard card : getAllCards()) {

           if (card.phoneNumber.equalsIgnoreCase(phoneNumber)) {

               System.out.println("Your card info is : "+"Card#"+card.cardNumber+" Full Name "+card.fullName + " Phone# "+phoneNumber +" Email "+card.email);

           }

       }



    }

    public  void menuOrExit (String option) { // Exit or main menu

        if (option.equalsIgnoreCase("M")) {
            printOptions();
        }
        if (option.equalsIgnoreCase("0")) {
            System.out.println("Thank you. Bye.");
            System.exit(0);
        }
    }

    public static void printOptions(){

        System.out.println("Hello. Please choose one of the following options");
        System.out.println("1 - For new card"); //done
        System.out.println("2 - To print all card holders name and card number"); //done
        //System.out.println("3 - To print ventra card numbers");
        System.out.println("4 - To update the Ventra Card info"); // done
        System.out.println("5 - To replace card# , but save existing info"); // done
//        System.out.println("6 - To update existing card email address");
        System.out.println("6 - To search the card with phone number and print all card information");
       // System.out.println("8 - To print available options");
        System.out.println("0 - To exit");
    }



    /*
        1-Create the method will take parameter as a list of cards and it will print all the card holders name
        2- Create the method will take three parameter as a cardNumber, oldEmail and newEmail. This method will replace old email address with
        new email address matching with cardNumber
        3- Create the method will take one parameter as a card number and it will remove the card from the list if card number if matching.
        If the card removed it will return true else will return false.
        4- Create the method will take the parameter as a phone number and it will print all card information connected with this phone number.
        5- Create the method will take two parameter as an oldCardNumber and newCardNumber.
        This method will update the old card number with new card number
     */
}
