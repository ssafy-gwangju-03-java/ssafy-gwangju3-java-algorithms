package W1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class B_33_2754 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String grade = sc.nextLine();

        // A, B, C, D의 점수
        double num_grade = 4 + ((int) 'A') - ((int) grade.charAt(0));
        if (grade.equals("F")) {
            System.out.println(0.0);
        }else {
            // + 0 - 점수
            if ('+' == grade.charAt(1)) {
                System.out.println(num_grade + 0.3);
            } else if ('0' == grade.charAt(1)) {
                System.out.println(num_grade);
            } else {
                System.out.println(num_grade - 0.3);
            }
        }

// if문 여러 개
// if (grade.equals("A+")) {System.out.println(4.5);}...

    }
}
