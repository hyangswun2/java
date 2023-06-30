/* 문제 :
    10 ~ 1000까지 각 숫자를 분해하여 곱한 전체 합을 구하라.
    예를 들어, 11 ~ 13까지의 각 숫자를 분해한 곱의 전체 합은 다음과 같다.
     11 : 1 * 1 = 1 12 : 1 * 2 = 2 13 : 1 * 3 = 3
    이 경우의 답은 1 + 2 + 3 = 6
 */

package org.example;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int result = IntStream.rangeClosed(10, 1000)
                .map(x -> String.valueOf(x)
                        .chars()
                        .map(y -> y - '0')
                        .reduce(1, (acc, element) -> acc * element))
                .sum();
        System.out.println(result);
    }
}
