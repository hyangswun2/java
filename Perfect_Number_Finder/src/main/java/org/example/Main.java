/* 문제 :
    완전수란 자기 자신을 제외한 모든 양의 약수들의 합이 자기 자신이 되는 자연수이다. 예를 들면, 6과 28은 완전수이다.
     6 = 1 + 2 + 3 28 = 1 + 2 + 4 + 7 + 14
    자연수를 입력받아, 그 이하의 모든 완전수를 출력하는 코드를 작성하라.
 */

package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number (n): ");
        BigInteger n = sc.nextBigInteger();
        for (BigInteger e : perfectNum(n)) {
            if (e.compareTo(n) <= 0) System.out.print(e + " ");
        }
    }
    private static List<BigInteger> perfectNum(BigInteger n) {
        List<BigInteger> perfectNums = new ArrayList<>();
        BigInteger two = BigInteger.valueOf(2);
        BigInteger one = BigInteger.ONE;

        for (BigInteger i = one; ; i = i.add(one)) {
            BigInteger temp = two.pow(i.intValueExact()).subtract(one);
            if (temp.compareTo(n.add(one)) >= 0) break;
            if (temp.isProbablePrime(10)) {
                BigInteger perfectNum = two.pow(i.intValueExact() - 1).multiply(temp);
                perfectNums.add(perfectNum);
            }
        }
        return perfectNums;
    }
}
