package W1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class B_32_2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        // 대소문자 함수 : toUpperCase(), toLowerCase()

        // 문자열 인덱싱 : 문자열.chartAt(인덱스)
        int A = (int) 'A';
        int a = (int) 'a';
        int diff = a - A;
        char chr ;
        for (int i = 0; i < word.length(); i++) {
            int ord_word = (int) word.charAt(i);
            if (ord_word < a) {
                chr = (char) (ord_word + diff);
                System.out.print(chr);
            }
            else {
                chr = (char) (ord_word - diff);
                System.out.print(chr);
            }
        }


    }
}
