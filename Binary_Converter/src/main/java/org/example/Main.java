/* 문제 :
    자연수를 2진수로 출력하는 프로그램을 작성하라.
     ex) 73 = 64(2^6)+8(2^3)+1(2^0) -> 1001001
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number : ");
        int input = sc.nextInt();
        System.out.println(Integer.toBinaryString(input));
        sc.close();
    }
}