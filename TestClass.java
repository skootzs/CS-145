// Gabriella Samantha Maria
// 05/03/2023
// CS 145
// Assignment 2: Phonebook
// Class: The main method

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        // Creating a PhonebookManager class object and a scanner object to collect user input
        PhonebookManager phonebook = new PhonebookManager();
        Scanner sc = new Scanner(System.in);
        int option;
        // looping the menu until the user chooses to quit.
        do {
            System.out.println("Phonebook Management System");
            System.out.println("1. Add Entry");
            System.out.println("2. Delete Entry");
            System.out.println("3. Modify Entry");
            System.out.println("4. Print Phonebook");
            System.out.println("5. Exit");
            System.out.println("Enter option: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Enter first name: ");
                    String firstName = sc.nextLine();
                    System.out.println("Enter last name: ");
                    String lastName = sc.nextLine();
                    System.out.println("Enter address: ");
                    String address = sc.nextLine();
                    System.out.println("Enter city: ");
                    String city = sc.nextLine();
                    System.out.println("Enter phone number: ");
                    String phoneNumber = sc.nextLine();
                    // Use the addEntry function to add the entry to the phonebook
                    phonebook.addEntry(firstName, lastName, address, city, phoneNumber);
                    break;
                case 2:
                    System.out.println("Enter first name: ");
                    firstName = sc.nextLine();
                    System.out.println("Enter last name: ");
                    lastName = sc.nextLine();
                    phonebook.deleteEntry(firstName, lastName);
                    break;
                case 3:
                    System.out.println("Enter first name: ");
                    firstName = sc.nextLine();
                    System.out.println("Enter last name: ");
                    lastName = sc.nextLine();
                    phonebook.modifyEntry(firstName, lastName);
                    break;
                case 4:
                    phonebook.printPhonebook();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Try again");
                    break;
           
            }
        } while (option != 5);
    }
}