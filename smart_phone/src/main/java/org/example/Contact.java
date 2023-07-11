package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contact {
    private Map<String, String> contacts;
    private Scanner sc = new Scanner(System.in);

    Contact() {
        this.contacts = new HashMap<>();
    }
    Map<String, String> getContacts() {
        return contacts;
    }
    void main() {
        while(true) {
            contactUI();
            switch(sc.nextInt()) {
                case 1 :
                    contacts();
                    break;
                case 2 :
                    addContact();
                    break;
                case 3 :
                    delContact();
                    break;
                case 4 :
                    return;
            }
        }
    }
    void contactUI() {
        System.out.println("=================================");
        System.out.println("1. Contacts");
        System.out.println("2. Add Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Go to Precious");
        System.out.println("=================================");
        System.out.print("Select Number : ");
    }
    void contacts() {
        if(contacts.isEmpty()) {
            System.out.println("=================================");
            System.out.println("Add Contacts First!");
            return;
        }
        System.out.println("=================================");
        contacts.forEach((name, num) -> System.out.println(name + " " + num));
    }
    void addContact() {
        System.out.println("=================================");
        System.out.print("Enter Name : ");
        String getName = sc.next();
        for(String name : contacts.keySet()) {
            if(getName.equals(name)) {
                System.out.println("=================================");
                System.out.println("This Name is already Stored.");
                return;
            }
        }
        System.out.print("Enter Number : ");
        String getNum = sc.next();
        for(String num : contacts.values()) {
            if(getNum.equals(num)) {
                System.out.println("=================================");
                System.out.println("This Number is already Stored.");
                return;
            }
        }
        contacts.put(getName, getNum);
        System.out.println("=================================");
        System.out.println("Added Contact : " + getName + " " + getNum);
    }
    void delContact() {
        if(contacts.isEmpty()) {
            System.out.println("=================================");
            System.out.println("Add Contacts First!");
            return;
        }
        System.out.println("=================================");
        contacts.forEach((name, num) -> System.out.println(name + " " + num));
        System.out.println("=================================");
        System.out.print("Enter Name to Delete : ");
        String temp = sc.next();

        if(contacts.containsKey(temp)) {
            System.out.println("=================================");
            System.out.println("Deleted Contact : " + temp + " " + contacts.get(temp));
            contacts.remove(temp);
        } else {
            System.out.println("=================================");
            System.out.println(String.format("'%s' doesn't exist in Contacts", temp));
        }
    }
}
