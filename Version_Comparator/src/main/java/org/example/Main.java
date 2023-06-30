/* 문제 :
    두 개의 버전을 비교하는 프로그램을 작성하라.
     ex) 0.0.2 > 0.0.1, 1.0.10 > 1.0.3, 1.2.0 > 1.1.99
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the version : ");
        String v1 = sc.next();
        System.out.print("enter the version to compare : ");
        String v2 = sc.next();
        sc.close();

        compareVersion(v1, v2);
    }
    private static void compareVersion(String v1, String v2) {
        v1 += '.';
        v2 += '.';
        String[] ver1 = v1.split("\\.");
        String[] ver2 = v2.split("\\.");

        for(int i = 0 ; i < Math.min(ver1.length , ver2.length);i++)
            if( Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i]))
                System.out.println(v2.substring(0, v2.length() - 1) + " > " + v1.substring(0,v1.length() - 1));

        System.out.println(v1.substring(0, v1.length() - 1) + " > " + v2.substring(0, v2.length() - 1));
    }
}
