/* 문제 :
    n개의 정수를 가진 배열이 있다. 이 배열은 양의 정수와 음의 정수를 모두 가지고 있다. 아래 조건에 따라 배열을 정렬하라.
     조건 : 음의 정수는 앞쪽에 양의 정수는 뒷쪽에 있어야 한다. 또한 양의 정수와 음의 정수의 순서에는 변함이 없어야 한다.
    ex) -1 1 3 -2 2 -> -1 -2 1 3 2
 */

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your array length (n): ");
        int n = sc.nextInt();

        int[] intArray = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("enter element: ");
            intArray[i] = sc.nextInt();
        }
        sc.close();

        List<Integer> minusList = new ArrayList<>();
        List<Integer> plusList = new ArrayList<>();

        for (int i : intArray) {
            System.out.print(i + " "); // 원본 배열 출력
            if (i < 0) minusList.add(i);
            else plusList.add(i);
        }

        minusList.addAll(plusList); // minusList에 plusList를 결합

        System.out.println("");
        for (int i : minusList) System.out.print(i + " "); // 정렬된 배열 출력
    }
}