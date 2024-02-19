package java_study.w4;

import java.util.Scanner;

public class B_4_1932 {

    public static void main(String[] args) {
        // 메모리 초과도 나고, dp도 아니야...
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] samgak = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i+1; j++) {
//                samgak[i][j] = sc.nextInt();
//            }
//        }
//
//        int r, c, total;
//        String bit;
//        int mx = 0;
//
//        for (int i = 0; i < (int) Math.pow(2, n-1); i++) {
//            r = 0;
//            c = 0;
//            total = samgak[0][0];
//            bit = String.format("%500s", Integer.toBinaryString(i));
//            for (int j = 0; j < n-1; j++) {
//                r++;
//                if (bit.charAt(499 - j) == '1') {
//                    c++;
//                }
//                total += samgak[r][c];
//            }
//            mx = Math.max(mx, total);
//        }
//        System.out.println(mx);
    }
}