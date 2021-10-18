package com.techtorial.ventraApp;

import java.util.Scanner;

public class VentraAppRunner {

   public static VentraCardMachine machine = new VentraCardMachine("Chicago");
   public static VentraCard callVentraCard = new VentraCard(null,null,null);

    public static void main(String[] args){
        welcome();
        VentraCardMachine.printOptions();
        Scanner scanner = new Scanner(System.in);
            makeAChoice();
    }

    private static void makeAChoice(){
        Scanner scanner = new Scanner(System.in);
        String choice;

        VentraCard test = new VentraCard("test","224","test");
        VentraCard test1 = new VentraCard("test","test","test");
        machine.getAllCards().add(test);
        machine.getAllCards().add(test1);

        boolean menuOn = true;

        do {switch (scanner.next()) {
            case "0":
                System.out.println("Thank you for working with us");
                break;
            case "1":
                System.out.println("To create new card");
                System.out.println("Enter your name");
                scanner.nextLine();
                String newName = scanner.nextLine();
                System.out.println("Enter your phone #");
                String newPhone = scanner.nextLine();
                System.out.println("Enter your EMail");
                String newEmail = scanner.nextLine();
                machine.getAllCards().add(callVentraCard.createCard(newName,newPhone,newEmail));
                System.out.println("New card created");

                menuOption();
                machine.menuOrExit(scanner.next());


                /*
                1- Using scanner get the information of User (FullName, PhoneNumber, Email)
                2- Create new card According to this information(Call createCard method)
                3- Call addCard method from VentraCard Machine and add new card
                 */
                break;
            case "2":
                System.out.println("Print all ventra card numberz");

                machine.printCardzInfo(machine.getAllCards());

                menuOption();
                machine.menuOrExit(scanner.next());
                break;

            case "4":
                System.out.println("Enter Existing card number");
                long cardNum = scanner.nextLong();
                System.out.println("Type email to update email");
                System.out.println("Type name to update Name");
                System.out.println("Type phone to update phone number");
                scanner.nextLine();
                String option = scanner.nextLine();
                machine.updateSingleInfoParameter(cardNum,option);
//                System.out.println("Enter new name for card");
//                scanner.nextLine();
//                String updName = scanner.nextLine();
//                System.out.println("Enter your phone #");
//                String updPhone = scanner.nextLine();
//                System.out.println("Enter your EMail");
//                String updEmail = scanner.nextLine();
//                machine.updateCardInfo(CardNum,updName,updPhone,updEmail);
//                System.out.println("Info updated");

                menuOption();
                machine.menuOrExit(scanner.next());



                break;
            case "5":
                System.out.println("Enter cardd number");
                machine.replaceExistingCarNumber(scanner.nextLong());

                menuOption();
                machine.menuOrExit(scanner.next());

                break;
            case "6":

                System.out.println("Please enter your phone number to find card");
                scanner.nextLine();
                machine.searchCardByPhone(scanner.nextLine());

                menuOption();
                machine.menuOrExit(scanner.next());

                break;



            case "9":

          }
        } while (menuOn);
    }

    public static void welcome(){

        System.out.println("Welcome to the Ventra card");
    }
    public static void menuOption() {
        System.out.println("M - to menu. 0 - exit");
    }


}
