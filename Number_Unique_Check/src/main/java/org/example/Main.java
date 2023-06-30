/* 문제 :
    0~9까지의 문자로 된 숫자를 입력 받았을 때, 이 입력 값이 0~9까지의 숫자가 모두 한 번 씩만 사용된 것인지 확인하는 함수를 구하라.
     input ex) 0123456789 01234 01234567890 6789012345 012322456789
     output ex): true false false true false
 */

package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number: ");
        String input = sc.next();

        System.out.println(isDuplicate(input));
        sc.close();
    }
    private static boolean isDuplicate(String input) {
        Set<Character> isAllNum = new HashSet<>();
        Set<Character> isDupNum = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (isAllNum.contains(c)) isDupNum.add(c);
            else isAllNum.add(c);
        }

        return isAllNum.size() == 10 && isDupNum.isEmpty();
    }
}