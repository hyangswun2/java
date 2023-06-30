/* 문제 :
    1 ~ 1000에서 각 숫자의 개수를 구하라.
     ex) 10 ~ 15의 각 숫자의 개수 : 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5
     0 : 1개, 1 : 7개, 2 : 1개, 3 : 1개, 4:1개, 5 : 1개
 */

package org.example;

public class Main {
    public static void main(String[] args) {
        int[] cntNum = new int[10];
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j <= 9; j++) {
                cntNum[j] += cntF(i, j);
            }
        }
        for(int i = 0; i < cntNum.length; i++) {
            System.out.println(String.format("%d : %d", i, cntNum[i]));
        }
    }
    public static int cntF(int a, int b) {
        int temp = 0;
        while (a > 0) {
            if (a % 10 == b) {
                temp++;
            }
            a /= 10; // 최하위 자릿수 count가 끝났으니 지운다.
        } // a가 0이 되면 반복문이 끝난다.
        return temp;
    }
}
