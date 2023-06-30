/* 문제 :
    디지털 시계에 하루동안(00:00~23:59) 3이 표시되는 시간을 초로 환산하면 총 몇 초(second)인지 계산하여 출력하라.
    디지털 시계는 하루동안 다음과 같이 시:분(00:00~23:59)으로 표시된다.
    00:00 (60초간 표시됨) 00:01 00:02 ... 23:59
 */

package org.example;

public class Main {
    public static void main(String[] args) {
        int sec = 0;
        for (int hour = 0; hour < 24; hour++) {
            for (int min = 0; min < 60; min++) {
                if (hour % 10 == 3 || hour / 10 == 3 || min % 10 == 3 || min / 10 == 3) sec += 60;
            }
        }
        System.out.println(sec);
    }
}
