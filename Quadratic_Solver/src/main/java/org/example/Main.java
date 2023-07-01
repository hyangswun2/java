/* 문제 :
    이차방정식 풀이 프로그램을 작성하라.
     조건 :
        ax^2 + bx + c = 0의 꼴에서 a, b, c를 입력받아 해를 구하여야 한다.
        근의 공식을 사용하여야 한다.
        해는 정수로 반올림한 값을 구하고 해가 없거나 여러 개인 경우도 모두 구하여야 한다.
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a: ");
        double a = sc.nextDouble();
        System.out.print("enter b: ");
        double b = sc.nextDouble();
        System.out.print("enter c: ");
        double c = sc.nextDouble();
        sc.close();

        Discriminant(a, b, c);
    }
    private static void Discriminant(double a, double b, double c) {
        double D = b * b - 4 * a * c;
        if (D < 0) {
            System.out.println("x is a complex number. (There are no solutions)");
        } else if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println(String.format("The values of x are %d, %d", Math.round(x1), Math.round(x2)));
        } else if (D == 0) {
            double x = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println(String.format("The value of x is %d", Math.round(x)));
        }
    }
}