package org.example;

public class Main {
    public static void main(String[] args) {
        int lcm = 1;
        while (true) {
            boolean isLCM = true;
            for (int i = 1; i <= 20; i++) {
                if (lcm % i != 0) {
                    isLCM = false;
                    break;
                }
            }
            if (isLCM) {
                System.out.println(lcm);
                break;
            }
            lcm++;
        }
    }
}
