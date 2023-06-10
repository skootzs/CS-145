// Gabriella Samantha Maria
// 05/03/2023
// CS 145
// Assignment 2: Phonebook
// Class: PhonebookManager

import java.util.Scanner;

// PhonebookManager class manages a simple phonebook with basic functionalities
public class PhonebookManager {
    private ListNode head;// head of the phonebook's linked list
    private int size; // size of the phonebook

    public PhonebookManager() {
        head = null;
        size = 0;
    }
    // addEntry method adds a new entry to the phonebook
    public void addEntry(String firstName, String lastName, String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(firstName, lastName, address, city, phoneNumber);
        ListNode current = head;
        if (head == null) {
            head = newNode;
            size++;
        } 
        else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            size++;
        }
    }

    public boolean deleteEntry(String firstName, String lastName) {
        ListNode current = head;
        if (head == null) {
            System.out.println("Phonebook is empty");
            return false;
        } 
        else if (head.getFirstName().equals(firstName) && head.getLastName().equals(lastName)) {
            head = head.getNext();
            size--;
            return true;
        } 
        else {
            while (current.getNext() != null) {
                if (current.getNext().getFirstName().equals(firstName) && current.getNext().getLastName().equals(lastName)) {
                    current.setNext(current.getNext().getNext());
                    size--;
                    return true;
                }
                current = current.getNext();
            }
            System.out.println("Entry not found");
            return false;
        }
    }
// This part reminds me of my mom, when she always forgets people's name
public void modifyEntry(String firstName, String lastName) {
    ListNode current = head;
    if (head == null) {
        System.out.println("Phonebook is empty");
    } 
    else {
        while (current != null) {
            if (current.getFirstName().equals(firstName) && current.getLastName().equals(lastName)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter new address: ");
                String address = sc.nextLine();
                System.out.println("Enter new city: ");
                String city = sc.nextLine();
                System.out.println("Enter new phone number: ");
                String phoneNumber = sc.nextLine();
                current.setAddress(address);
                current.setCity(city);
                current.setPhoneNumber(phoneNumber);
                System.out.println("Entry modified");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Entry not found");
    }
}

public void printPhonebook() {
    ListNode current = head;
    System.out.println("Phonebook:");
    if (head == null) {
        System.out.println("Phonebook is empty");
    } 
    else {
        while (current != null) {
            System.out.println("Name: " + current.getFirstName() + " " + current.getLastName());
            System.out.println("Address: " + current.getAddress());
            System.out.println("City: " + current.getCity());
            System.out.println("Phone Number: " + current.getPhoneNumber());
            System.out.println("-------------------");
            current = current.getNext();
            // Update the current node's address, city, and phone number
        }
    }
}
}