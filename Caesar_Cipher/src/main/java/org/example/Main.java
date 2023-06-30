/* 문제 :
    시저 암호란 고대 로마의 황제 줄리어스 시저가 만들어 낸 암호이다. 원본 알파벳을 n개 뒤에 오는 알파벳으로 작성하는 암호 기법이다.
     ex) 원본 단어 : CAT, n = 5 -> 암호화 : HFY
    원본 문장과 n을 입력하면 시저 암호를 만드는 프로그램을 작성하라.
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the sentence : ");
        String origin = sc.nextLine();
        System.out.print("enter the n : ");
        int n = sc.nextInt();
        sc.close();

        char[] cipher = new char[origin.length()];
        for(int i = 0; i < origin.length(); i++) {
            char c = origin.charAt(i);
            if(Character.isLetter(c)) {
                int firstAlphabet = Character.isUpperCase(c) ? 'A' : 'a';
                int adjustAscii = ((c - firstAlphabet) + n) % 26;
                cipher[i] = (char) (firstAlphabet + adjustAscii);
            } else cipher[i] = c;
        }
        System.out.println(cipher);
    }
}
