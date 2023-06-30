/* 문제 :
    피보나치 수열이란, 첫 번째 항의 값이 0이고 두 번째 항의 값이 1일 때, 이후의 항들은 이전의 두 항을 더한 값으로 이루어지는 수열을 말한다.
     ex) 0, 1, 1, 2, 3, 5, 8, 13
    정수 n을 입력으로 받을 때, n 이하까지의 피보나치 수열을 출력하는 프로그램을 작성하라.
 */

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number (n) : ");
        int n = sc.nextInt();
        sc.close();

        List<Integer> list = fibonacci(n);
        for (int i : list) System.out.print(i + " ");
    }
    private static List<Integer> fibonacci(int n) {
        List<Integer> list = new ArrayList<>();
        if(n >= 0) list.add(0);
        if(n >= 1) list.add(1);

        int a = 0;
        int b = 1;
        int c = a + b;

        while(c >= n){
            list.add(c);
            a = b;
            b = c;
            c = a + b;
        }
        return list;
    }
}
