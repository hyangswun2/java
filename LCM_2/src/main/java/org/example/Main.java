package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(LCM(1, 20));
    }
    private static long LCM(int start, int end) {
        long lcm = start;
        for (int i = start + 1; i <= end; i++) lcm = getLCM(lcm, i);
        return lcm;
    }
    private static long getLCM(long a, long b) {
        return (a * b) / getGCD(a, b);
    }
    private static long getGCD(long a, long b) {
        if (b == 0) return a;
        else return getGCD(b, a % b);
    }
}