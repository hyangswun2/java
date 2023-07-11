package org.example;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class SmartPhone {
    private String num;
    private List<SmartPhone> phones;
    private List<Message> inbox;
    private Contact contact = new Contact();
    private Message message = new Message();
    private boolean isCall = false;
    private boolean isPowerOn = true;
    private Scanner sc = new Scanner(System.in);

    SmartPhone(String num, List<SmartPhone> phones) {
        this.num = num;
        this.phones = phones;
        this.inbox = new ArrayList<>();
    }
    String getNum() {
        return num;
    }
    void main() {
        if (!isPowerOn) powerOffUI();
        else {
            while (true) {
                if (isCall) callUI();
                else {
                    phoneUI();
                    switch (sc.nextInt()) {
                        case 1:
                            call();
                            break;
                        case 2:
                            messageUI();
                            break;
                        case 3:
                            contact.main();
                            break;
                        case 4:
                            isPowerOn = false;
                            powerOffUI();
                            break;
                        case 5:
                            return;
                    }
                }
            }
        }
    }
    void phoneUI() {
        System.out.println("=================================");
        System.out.println("Phone Number : " + getNum());
        System.out.println("Is Power On : " + isPowerOn);
        System.out.println("Is Call : " + isCall);
        System.out.println("=================================");
        System.out.println("1. Call");
        System.out.println("2. Message");
        System.out.println("3. Contacts");
        System.out.println("4. Power Off");
        System.out.println("5. Go to Main");
        System.out.println("=================================");
        System.out.print("Select Number : ");
    }
    void callUI() {
        while (true) {
            System.out.println("=================================");
            System.out.println("Phone Number : " + num);
            System.out.println("Is Power On : " + isPowerOn);
            System.out.println("Is Call : " + isCall);
            System.out.println("=================================");
            System.out.println("1. Hang Up");
            System.out.println("=================================");
            System.out.print("Select Number : ");
            if (sc.nextInt() == 1) {
                isCall = false;
                break;
            }
        }
    }
    void messageUI() {
        while(true) {
            System.out.println("=================================");
            System.out.println("Phone Number : " + num);
            System.out.println("Is Power On : " + isPowerOn);
            System.out.println("Is Call : " + isCall);
            System.out.println("=================================");
            System.out.println("1. Send Message");
            System.out.println("2. Message Inbox");
            System.out.println("3. Go to Precious");
            System.out.println("=================================");
            System.out.print("Select Number : ");
            switch (sc.nextInt()) {
                case 1:
                    sendMessage();
                case 2:
                    inboxUI();
                case 3:
                    return;
                default:
                    continue;
            }
        }
    }
    void powerOffUI() {
        while (true) {
            System.out.println("=================================");
            System.out.println("Phone Number : " + num);
            System.out.println("Is Power On : " + isPowerOn);
            System.out.println("Is Call : " + isCall);
            System.out.println("=================================");
            System.out.println("1. Power On");
            System.out.println("2. Go to Main");
            System.out.println("=================================");
            System.out.print("Select Number : ");
            switch (sc.nextInt()) {
                case 1:
                    isPowerOn = true;
                    break;
                case 2:
                    return;
                default :
                    continue;
            }
        }
    }
    void call() {
        Map<String, String> contacts = contact.getContacts();

        if (contacts.isEmpty()) {
            System.out.println("=================================");
            System.out.println("Add Contacts First!");
            return;
        }
        System.out.println("=================================");
        contacts.forEach((name, num) -> System.out.println(name + " " + num));

        System.out.println("=================================");
        System.out.print("Enter Name stored in Contacts : ");
        String inputName = sc.next();

        for (String name : contacts.keySet()) {
            if (inputName.equals(name)) {
                if (inputName.equals(num)) {
                    System.out.println("=================================");
                    System.out.println("Can't Call Yourself!");
                    return;
                }
                break;
            } else {
                System.out.println("=================================");
                System.out.println("No Result");
                return;
            }
        }
        for (SmartPhone smartphone : phones) {
            if (contacts.get(inputName).equals(smartphone.num)) {
                if (smartphone.isPowerOn && !smartphone.isCall) {
                    System.out.println("=================================");
                    System.out.println("Call to " + inputName);
                    smartphone.isCall = !smartphone.isCall;
                    isCall = !isCall;
                } else if (!smartphone.isPowerOn) {
                    System.out.println("=================================");
                    System.out.println("Phone to call is turned off.");
                } else if (smartphone.isCall) {
                    System.out.println("=================================");
                    System.out.println("Phone to call is now calling.");
                }
                break;
            } else {
                System.out.println("=================================");
                System.out.println("Phone Number doesn't exist");
            }
        }
    }
    void sendMessage() {
        Map<String, String> contacts = contact.getContacts();

        if (contacts.isEmpty()) {
            System.out.println("=================================");
            System.out.println("Add Contacts First!");
            return;
        }
        System.out.println("=================================");
        contacts.forEach((name, num) -> System.out.println(name + " " + num));
        System.out.println("=================================");
        System.out.print("Enter Name to send Message : ");
        String inputName = sc.next();

        if (!contacts.containsKey(inputName)) {
            System.out.println("=================================");
            System.out.println("No Result");
            return;
        }
        String phoneNum = contacts.get(inputName);
        SmartPhone targetPhone = null;

        for (SmartPhone smartphone : phones) {
            if (phoneNum.equals(smartphone.num)) {
                targetPhone = smartphone;
                break;
            }
        }

        if (targetPhone == null) {
            System.out.println("=================================");
            System.out.println("Phone Number doesn't exist");
            return;
        }
        Message message = new Message();
        message.setName(inputName);
        message.setNum(phoneNum);
        System.out.println("Enter text to send Message : ");
        message.setMessage(sc.nextLine());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        message.setDate(now.format(formatter));

        targetPhone.message = message;
        targetPhone.addInbox(message);

        System.out.println("=================================");
        System.out.println(message.getName() + " " + message.getNum());
        System.out.println(message.getDate());
        System.out.println(message.getMessage());
        System.out.println("=================================");
        System.out.println("Message has been sent.");
    }
    void addInbox(Message message) {
        inbox.add(message);
    }
    void inboxUI() {
        if (inbox.isEmpty()) {
            System.out.println("=================================");
            System.out.println("Inbox is empty.");
            return;
        }
        System.out.println("=================================");
        for (Message message : inbox) {
            System.out.println(message.getName() + " " + message.getNum());
            System.out.println(message.getDate());
            System.out.println(message.getMessage());
            System.out.println("---------------------------------");
        }
    }
}