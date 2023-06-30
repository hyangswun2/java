/* 문제 :
    소스 코드 파일의 tab 공백을 space 공백으로 변환하는 프로그램을 작성하라.
 */

package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the file path what you modify : ");
        String inputFilePath = sc.nextLine(); // 수정할 파일 경로를 입력

        System.out.print("enter the file path to be modified: ");
        String outputFilePath = sc.nextLine(); // 수정될 파일 경로를 입력

        sc.close();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace("\t", " "); // replace 메서드는 String 클래스에서 사용
                // readline() 메서드를 통한 line 객체에 사용
                writer.write(line);
                writer.newLine();
            }

            System.out.println("converted!");
        } catch (IOException e) {
            e.printStackTrace(); // .getMessage 보다 예외 발생 원인 파악이 쉽다
        }
    }
}
