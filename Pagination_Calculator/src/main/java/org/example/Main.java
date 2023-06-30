/* 문제 :
    게시물의 총 건수와 한 페이지에 보여줄 게시물 수를 입력으로 주었을 때 총 페이지 수를 리턴하는 프로그램을 작성하라.
    입력 : 총 건 수(m), 한 페이지에 보여줄 게시물 수(n) (단 n >= 1), 출력 : 총 페이지 수
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m, n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Total number of posts (m) : ");
        m = sc.nextInt();

        while (true) {
            System.out.print("Posts per page (n) : ");
            n = sc.nextInt();
            if (n >= 1) break;
            else System.out.println("n must be at least 1!");
        }

        if (m % n != 0) System.out.println(String.format("| m : %d | n : %d | output : %d |", m, n, m / n + 1));
        else System.out.println(String.format("| m : %d | n : %d | output : %d |", m, n, m / n));
    }
}
