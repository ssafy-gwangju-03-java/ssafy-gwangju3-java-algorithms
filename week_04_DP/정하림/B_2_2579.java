package java_study.w4;

import java.util.ArrayList;
import java.util.Scanner;

public class B_2_2579 {
    // 메모리 초과
//    static ArrayList<String>[] step;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] stair = new int[N];
//        step = new ArrayList[N+1];
//
//        for (int i = 0; i < N; i++) {
//            stair[i] = sc.nextInt();
//            step[i + 1] = new ArrayList<>();
//        }
//
//        step[1].add("1");
//        step[2].add("01");
//        step[2].add("11");
//
//        for (int i = 3; i < N+1 ; i++) {
//            for (String s : step[i - 1]) {
//                // 0으로 시작하면 1 붙이기
//                if (s.charAt(0) == '0') {
//                    step[i].add("1" + s);
//                }
//                // 1로 시작하면 0 붙이기
//                // 두번쨰 숫자가 0이면 1붙이기
//                else {
//                    step[i].add("0" + s);
//                    if (s.charAt(1) =='0') {
//                        step[i].add("1" + s);
//                    }
//                }
//            }
//        }
//
//        // 점수
//        long grade;
//        long mx =0;
//        for (String s : step[N]) {
//            grade = 0;
//            for (int i = 0; i < N; i++) {
//                if (s.charAt(i) == '1') {
//                    grade += stair[i];
//                }
//            }
//            mx = Math.max(mx, grade);
//        }
//        System.out.println(mx);
//
//    }
}
