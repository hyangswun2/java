/* 문제 :
    자연수 a, b, c 가 피타고라스 정리(a^2 + b^2 = c^2)를 만족하면 피타고라스 수이다(a < b < c).
     ex) 3^2 + 4^2 = 5^2 ∴ 3, 4, 5는 피타고라스 수
    a + b + c = 1000인 피타고라스 수 a, b, c는 한 가지 뿐이다. 이 때, a * b * c 는 얼마인가?
 */

package org.example;

public class Main {
    public static void main(String[] args) {
        for(int a = 1; a <= 332; a++) {
            for (int b = a + 1; b <= (999 - a) / 2; b++) {
                int c = 1000 - a - b;
                if (a + b + c == 1000 && a * a + b * b == c * c && a < b && b < c)
                    System.out.println(a * b * c);
            }
        }
    }
}
