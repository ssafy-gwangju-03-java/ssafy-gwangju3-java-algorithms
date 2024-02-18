package java_study.w4;

import java.util.Scanner;

public class B_3_9095 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n;
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int j = 4; j < 12; j++) {
            dp[j] = dp[j-1] + dp[j-2]+ dp[j-3];
        }
        for (int i = 1; i < T+1; i++) {
            n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
// 1 :  1 = 1
// 2 :  2 = 11 2
// 3 :  4 = 111 12 21 3
// 4 :  7 = 1111 112 121 211 13 31 22
// 5 : 13 = 11111 1112 1121 1211 2111 113 131 311 122 212 221 23 32
// 6 : 24 = 111111 11112 11121 11211 12111 21111 1113 1131 1311 3111
//          1122 1212 1221 2112 2121 2211 123 132 213 231 312 321 222 33
// 7 : 44
// 10: 274 = (7)44 (8) 88-7 +(9) 162 - 13