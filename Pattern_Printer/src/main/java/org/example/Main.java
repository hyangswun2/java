/* 문제 :
    정수 n을 입력 받아 첫번째 row는 (n-1)의 O와 X, 두번째 row는 (n-2)의 O와 XX, 세번째 row는 (n-3)의 O와 XXX... n번째 row는 n의 X을 출력하라.
     조건 : 비트 연산 사용
     ex) input : 6 -> OOOOOX OOOOXX OOOXXX OOXXXX OXXXXX XXXXXX
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("enter the number : ");
        int n = Integer.valueOf(new Scanner(System.in).nextLine());
        for (int i = 0; i < n; i++)
            System.out.println(
                    String.format("%0" + n + "d",
                                    Integer.valueOf(Integer.toBinaryString((int) (Math.pow(2, i + 1) - 1))))
                            .replaceAll("0", "O")
                            .replaceAll("1", "X"));
    }
}
