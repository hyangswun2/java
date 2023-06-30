/* 문제 :
    Dash Insert 함수는 숫자로 구성된 문자열을 입력받은 뒤, 문자열 내에서 홀수가 연속되면 두 수 사이에 -를 추가하고, 짝수가 연속되면 *를 추가하는 기능을 갖고 있다. 이 함수를 구현하라.
     ex) 454 => 454, 4546793 => 45467-9-3, 4546793 => 454*67-9-3
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number : ");
        char[] num = sc.next().toCharArray();

        for (int i = 1; i < num.length; i++) {
            System.out.print(num[i - 1]);
            if (num[i - 1] % 2 == 0 && num[i] % 2 == 0) {
                if (num[i] % 2 == 0)
                    System.out.print("*");
            } else {
                if (num[i] % 2 != 0)
                    System.out.print("-");
            }
        }
        System.out.println(num[num.length - 1]);
        sc.close();
    }
}
