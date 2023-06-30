/* 문제 :
    1000 미만의 자연수에서 3과 5의 배수의 총합을 구하라.
 */

package org.example;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int sum = IntStream.range(1, 1000) // 1부터 999까지의 자연수 범위
                .filter(n -> n % 3 == 0 || n % 5 == 0) // 3, 5로 나누어 떨어지는 자연수 필터링
                .sum(); // 총합 계산
// sum 메서드는 long 타입으로 반환되지만 이 문제에서는 범위를 초과할 수 없어 고려할 필요 없음.
        System.out.println("총합: " + sum);
    }
}