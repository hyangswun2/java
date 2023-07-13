package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SmartPhone> phones = new ArrayList<>();

        while(true) {
            mainUI();
            switch (sc.nextInt()) {
                case 1 :
                    SmartPhone phone = new SmartPhone(getPhoneNum(), phones);
                    phones.add(phone);
                    System.out.println("SmartPhone Added : " + phone.getNum());
                    break;
                case 2 :
                    if(phones.isEmpty()) {
                        System.out.println("Add SmartPhone First!");
                        continue;
                    }
                    System.out.println("=================================");
                    for(SmartPhone p : phones) System.out.println(p.getNum());
                    System.out.println("=================================");
                    System.out.print("Select Phone Number : ");
                    String selected = sc.next();
                    exePhone(selected, phones);
                    break;
                case 3 :
                    System.exit(0);
                default :
                    continue;
            }
        }
    }
    static void mainUI() {
        System.out.println("=================================");
        System.out.println("1. Add SmartPhone");
        System.out.println("2. Select SmartPhone");
        System.out.println("3. exit");
        System.out.println("=================================");
        System.out.print("Select Number : ");
    }
    static String getPhoneNum() {
        Random rand = new Random();
        StringBuilder num = new StringBuilder("010");
        for (int i = 0; i < 8; i++) num.append(rand.nextInt(9));
        return num.toString();
    }
    static void exePhone(String selected, List<SmartPhone> phones) {
        for(SmartPhone p : phones) {
            if(p.getNum().equals(selected)) {
                p.main();
                return;
            }
        }
        System.out.println("Phone Number not found.");
    }
}