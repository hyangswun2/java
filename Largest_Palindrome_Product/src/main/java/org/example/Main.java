/* 문제 :
    대칭수(palindrome)는 순서대로 읽은 수와 거꾸로 읽은 수가 같은 수이다.
    두 자리 수를 곱하여 만들 수 있는 대칭수 중 가장 큰 수는 9009 (= 91 * 99)이다.
    세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수를 구하라.
 */

package org.example;

public class Main {
    public static void main(String[] args) {
        int output = 0;
        for(int i = 999; i >= 100; i--) {
            for(int j = 999; j >= 100; j--) {
                if(isPalindrome(i * j)) {
                    int temp = i * j;
                    if(temp > output) output = temp;
                }
            }
        }
        System.out.println(output);
    }
    private static boolean isPalindrome(int n) {
        String intToString = Integer.toString(n);
        int left = 0;
        int right = intToString.length() - 1;
        while(left < right) {
            if(intToString.charAt(left) != intToString.charAt(right)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}