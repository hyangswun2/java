/* 문제 :
    피보나치 수열의 각 항은 바로 앞의 항 두 개를 더한 것이다. 1과 2로 시작하는 수열은 아래와 같다.
     1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    짝수이면서 4백만 이하인 모든 항을 더하면 값을 구하라.
 */

package org.example;

public class Main {
    public static void main(String[] args) {
        int output = 0;
        int f_pre = 1;
        int f_now = 2;
        while(f_now <= 4000000) {
            int f_next = f_now + f_pre;
            if(f_now % 2 == 0) output += f_now;
            f_pre = f_now;
            f_now = f_next;
        }
        System.out.println(output);
    }
}
