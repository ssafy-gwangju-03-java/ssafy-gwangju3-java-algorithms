package w4;

import java.util.Scanner;

public class B_0_1904 {
    static long dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[N + 2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < N+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        System.out.println(dp[N]);
    }
}
