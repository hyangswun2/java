package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(LCM(1, 20));
    }

    private static int LCM(int start, int end) {
        int lcm = end;
        while (!isMulAll(lcm, start, end)) lcm += end;

        return lcm;
    }

    private static boolean isMulAll(int n, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (n % i != 0) return false;
        }
        return true;
    }
}
