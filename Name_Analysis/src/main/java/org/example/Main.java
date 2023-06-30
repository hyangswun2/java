/* 문제 :
    주어진 문자열을 가지고 아래 문제에 대한 프로그램을 작성하라.
     "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌"
    1. 김씨와 이씨는 각각 몇 명인지 구하라.
    2. "이재영"이란 이름이 몇 번 반복되는지 구하라.
    3. 중복을 제거한 이름을 출력하라.
    4. 중복을 제거한 이름을 오름차순으로 정렬하여 출력하라.
 */

package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String nameList =
                "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";

        String[] splitedName = nameList.split(",");

        for(String name : splitedName) System.out.println(name);
        System.out.println();

        long countKim = Arrays.stream(splitedName)
                .mapToLong(it -> it.startsWith("김") ? 1 : 0) // Long 타입으로 map하는 스트림 메서드
                .sum(); // sum의 반환값이 Long이기 때문에 mapToLong 사용
        long countLee = Arrays.stream(splitedName)
                .mapToLong(it -> it.startsWith("이") ? 1 : 0) // "이"로 시작한다면 1, 아니라면 0을 할당
                .sum(); // 스트림에 저장하고 sum을 통해 합산
        long countLeeJY = Arrays.stream(splitedName)
                .mapToLong(it -> it.equals("이재영") ? 1 : 0)
                .sum();

        System.out.println(String.format("Start at 김 : %d, Start at 이 : %d, equal 이재영 : %d", countKim, countLee, countLeeJY));
        System.out.println();

        Arrays.stream(splitedName)
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        Arrays.stream(splitedName)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}