// Gabriella Samatha Maria
// 05/03/2023
// CS 145
// Assignment 2: Phonebook
// Class: ListNode

public class ListNode {
    // Fields for storing first and last names, addresses, cities, phone numbers, and the next ListNode in the list.    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String phoneNumber;
    private ListNode next;

// Constructor for initializing the fields with the values supplied.    
        public ListNode(String firstName, String lastName, String address, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }

    public String getFirstName() {
        return firstName;
    }

    // The first name field's setter method 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // The last name field's getter method
    public String getLastName() {
        return lastName;
    }

    // The last name field's setter method 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Address's field for Getter method
    public String getAddress() {
        return address;
    }

    // Addrress field for setter method
    public void setAddress(String address) {
        this.address = address;
    }

    // city field getter method
    public String getCity() {
        return city;
    }

    // city field setter method
    public void setCity(String city) {
        this.city = city;
    }

    // phone number field getter method
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // phone number field setter method
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // next ListNode field Getter Method
    public ListNode getNext() {
        return next;
    }

    // next ListNode field setter method
    public void setNext(ListNode next) {
        this.next = next;
    }
}