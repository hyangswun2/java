package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(LCM(1, 20));
    }

    private static int LCM(int start, int end) {
        int lcm = 1;
        for (int i = start; i <= end; i++) lcm = getLCM(lcm, i);
        return lcm;
    }

    private static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }

    private static int getGCD(int a, int b) {
        if (b == 0) return a;
        else return getGCD(b, a % b);
    }
}
