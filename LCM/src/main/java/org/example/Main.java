/* 문제 :
    1 ~ 10 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 2520이다.
    1 ~ 20 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수를 구하라.
 */

package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 20;
        Map<Integer, Integer> primeFactors = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            Map<Integer, Integer> factorization = factorization(i, getPrimes(i));
            primeFactors = LCM(primeFactors, factorization);
        }
        long res = getRes(primeFactors);
        System.out.println(res);
    }

    private static List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isComposite = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                for (int j = i * i; j <= n; j += i)
                    isComposite[j] = true;
            }
        }
        return primes;
    }
    private static Map<Integer, Integer> factorization(int n, List<Integer> primes) {
        Map<Integer, Integer> primeFactors = new HashMap<>();
        for (int base : primes) {
            int expon = 0;
            while (n % base == 0) {
                n /= base;
                expon++;
            }
            if (expon > 0) {
                if (primeFactors.containsKey(base)) {
                    primeFactors.put(base, Math.max(expon, primeFactors.get(base)));
                } else {
                    primeFactors.put(base, expon);
                }
            }
        }
        if (n > 1) primeFactors.put(n, 1);
        return primeFactors;
    }
    private static Map<Integer, Integer> LCM(Map<Integer, Integer> LCM, Map<Integer, Integer> factorization) {
        for (int base : factorization.keySet()) {
            int expon = factorization.get(base);
            if (LCM.containsKey(base)) {
                LCM.put(base, Math.max(expon, LCM.get(base)));
            } else {
                LCM.put(base, expon);
            }
        }
        return LCM;
    }
    private static long getRes(Map<Integer, Integer> primeFactors) {
        long res = 1;
        for (int base : primeFactors.keySet()) {
            int expon = primeFactors.get(base);
            res *= Math.pow(base, expon);
        }
        return res;
    }
}
