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
    private SmartPhone tempPhone = null;
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
    List<SmartPhone> getPhones() {
        return phones;
    }
    List<Message> getInbox() {
        return inbox;
    }
    Contact getContact() {
        return contact;
    }
    SmartPhone getTempPhone() {
        return tempPhone;
    }
    boolean getIsCall() {
        return isCall;
    }
    boolean getIsPowerOn() {
        return isPowerOn;
    }
    Scanner getSc() {
        return sc;
    }


    void setMessage(Message message) {
        this.message = message;
    }
    void setTempPhone(SmartPhone tempPhone) {
        this.tempPhone = tempPhone;
    }
    void setIsCall(boolean call) {
        isCall = call;
    }
    void setIsPowerOn(boolean pow) {
        isPowerOn = pow;
    }

    void main() {
        while (true) {
            if (!getIsPowerOn()) {
                powerOffUI();
                switch (getSc().nextInt()) {
                    case 1 :
                        setIsPowerOn(true);
                        break;
                    case 2 :
                        return;
                    default :
                        continue;
                }
            }
            if (getIsCall()) {
                callUI();
                switch (getSc().nextInt()) {
                    case 1:
                        setIsCall(false);
                        getTempPhone().setIsCall(false);
                        break;
                    case 2:
                        return;
                    default:
                        continue;
                }
            }
            phoneUI();
            switch (getSc().nextInt()) {
                case 1:
                    call();
                    break;
                case 2:
                    messageUI();
                    break;
                case 3:
                    getContact().main();
                    break;
                case 4:
                    setIsPowerOn(false);
                    break;
                case 5:
                    return;
            }
        }
    }

    void basicUI() {
        System.out.println("=================================");
        System.out.println("Phone Number : " + getNum());
        System.out.println("Is Power On : " + getIsPowerOn());
        System.out.println("Is Call : " + getIsCall());
    }
    void selectUI() {
        System.out.println("=================================");
        System.out.print("Select Number : ");
    }
    void phoneUI() {
        basicUI();
        System.out.println("=================================");
        System.out.println("1. Call");
        System.out.println("2. Message");
        System.out.println("3. Contacts");
        System.out.println("4. Power Off");
        System.out.println("5. Go to Main");
        selectUI();
    }
    void callUI() {
        basicUI();
        System.out.println("=================================");
        System.out.println("1. Hang Up");
        System.out.println("2. Go to Main");
        selectUI();
    }

    void messageUI() {
        while (true) {
            basicUI();
            System.out.println("=================================");
            System.out.println("1. Send Message");
            System.out.println("2. Message Inbox");
            System.out.println("3. Go to Precious");
            selectUI();
            switch (sc.nextInt()) {
                case 1:
                    sendMessage();
                    break;
                case 2:
                    inboxUI();
                    break;
                case 3:
                    return;
                default:
                    continue;
            }
        }
    }
    void powerOffUI() {
        basicUI();
        System.out.println("=================================");
        System.out.println("1. Power On");
        System.out.println("2. Go to Main");
        selectUI();
    }

    void call() {
        Map<String, String> contacts = getContact().getContacts();
        setTempPhone(null);

        if (contacts.isEmpty()) {
            System.out.println("=================================");
            System.out.println("Add Contacts First!");
            return;
        }
        System.out.println("=================================");
        contacts.forEach((name, num) -> System.out.println(name + " " + num));

        System.out.println("=================================");
        System.out.print("Enter Name stored in Contacts : ");
        String inputName = getSc().next();
        boolean isIt = false;

        for (String name : contacts.keySet()) {
            if (inputName.equals(name)) {
                if(contacts.get(inputName).equals(getNum())){
                    System.out.println("=================================");
                    System.out.println("Can't Call Yourself!");
                    return;
                }
                isIt = true;
                break;
            }
        }
        if(!isIt) {
            System.out.println("=================================");
            System.out.println("No Result.");
            return;
        }
        for (SmartPhone smartphone : getPhones()) {
            if (contacts.get(inputName).equals(smartphone.getNum())) {
                if (smartphone.getIsPowerOn() && !smartphone.getIsCall()) {
                    System.out.println("=================================");
                    System.out.println("Call to " + inputName);
                    smartphone.setIsCall(true);
                    setIsCall(true);
                    setTempPhone(smartphone);
                    getTempPhone().setTempPhone(this);
                } else if (!smartphone.getIsPowerOn()) {
                    System.out.println("=================================");
                    System.out.println("Phone to Call is Turned Off.");
                } else if (smartphone.getIsCall()) {
                    System.out.println("=================================");
                    System.out.println("Phone to Call is Now Calling.");
                }
                return;
            }
        }
        System.out.println("=================================");
        System.out.println("Phone Number doesn't Exist");
    }

    void sendMessage() {
        Map<String, String> contacts = getContact().getContacts();

        if (contacts.isEmpty()) {
            System.out.println("=================================");
            System.out.println("Add Contacts First!");
            return;
        }
        System.out.println("=================================");
        contacts.forEach((name, num) -> System.out.println(name + " " + num));
        System.out.println("=================================");
        System.out.print("Enter Name to Send Message : ");
        String inputName = getSc().next();

        if (!contacts.containsKey(inputName)) {
            System.out.println("=================================");
            System.out.println("No Result");
            return;
        }
        String phoneNum = contacts.get(inputName);
        setTempPhone(null);

        for (SmartPhone smartphone : getPhones()) {
            if (phoneNum.equals(smartphone.getNum())) {
                setTempPhone(smartphone);
                break;
            }
        }

        if (getTempPhone() == null) {
            System.out.println("=================================");
            System.out.println("Phone Number doesn't Exist");
            return;
        }
        Message message = new Message();
        message.setNum(getNum());
        System.out.println("Enter Text to Send Message : ");
        getSc().nextLine();
        String text = getSc().nextLine();
        message.setMessage(text);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        message.setDate(now.format(formatter));

        getTempPhone().setMessage(message);
        getTempPhone().addInbox(message);

        System.out.println("=================================");
        System.out.println("To. " + phoneNum);
        System.out.println(message.getDate());
        System.out.println(message.getMessage());
        System.out.println("=================================");
        System.out.println("Message has been Sent.");
    }

    void addInbox(Message message) {
        getInbox().add(message);
    }

    void inboxUI() {
        if (getInbox().isEmpty()) {
            System.out.println("=================================");
            System.out.println("Inbox is Empty.");
            return;
        }
        System.out.println("=================================");
        for (Message message : getInbox()) {
            System.out.println("From. " + message.getNum());
            System.out.println(message.getDate());
            System.out.println(message.getMessage());
            System.out.println("---------------------------------");
        }
    }
}