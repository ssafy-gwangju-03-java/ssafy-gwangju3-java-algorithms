package week_04_DP.김가람;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B_5_10844 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] dp = new long[N+1][10];
        dp[0] = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i-1][1] % 1000000000;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % 1000000000;
            }
            dp[i][9] = dp[i-1][8] % 1000000000;
        }

        System.out.println(Arrays.stream(dp[N-1]).sum() % 1000000000);
    }
}
