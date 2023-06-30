/* 문제 :
    1부터 10까지 자연수의 제곱의 합은 다음과 같다.
     1^2 + 2^2 + ... + 10^2 = 385
    1부터 10까지 자연수의 합의 제곱은 다음과 같다.
     (1 + 2 + ... + 10)^2 = 55^2 = 3025
    1부터 10까지 자연수의 합의 제곱과 제곱의 합의 차는 3025 - 385 = 2640 이다.
    1부터 100까지 자연수의 합의 제곱과 제곱의 합의 차를 구하라.
 */

package org.example;

public class Main {
    public static void main(String[] args) {
        int sum_pow = 0;
        int pow_sum = 0;
        for(int i = 1; i <= 100; i++) {
            sum_pow += i;
            pow_sum += i * i;
        }
        System.out.println(Math.abs(sum_pow * sum_pow - pow_sum));
    }
}
