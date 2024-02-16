package w4;

import java.util.Scanner;

public class B_0_16395 {
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp = new long[n+1][n+1];
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
        }
        System.out.println(dp[n][k]);

    }
}
