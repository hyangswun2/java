/* 문제 :
    아래의 실행 순서와 요구 사항에 맞춰 프로그램을 작성하여라.
     1. 입력할 정수의 개수를 사용자로부터 입력받는다.
     2. 입력받은 정수의 개수만큼 정수를 입력받는다.
     3. 입력받은 정수의 합과 평균 값을 출력한다.
     4. 할당된 메모리공간을 비운다.
    요구 사항
     1. 메모리 공간은 사용자의 입력 수의 따라 변동된다.
     2. 사용한 공간은 마지막에 비워야 한다.
     3. 배열을 사용하면 안된다.
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number to input : ");
        int n = sc.nextInt();
        int get, sum = 0;
        for(int i = 0; i < n; i++) {
            System.out.print("enter the number : ");
            get = sc.nextInt();
            sum += get;
        }
        System.out.print(String.format("sum : %d, avg : %.2f", sum, (float) sum / n));
        sc.close();
    }
}
