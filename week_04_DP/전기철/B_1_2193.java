package week_04_DP.전기철;

import java.util.Scanner;

public class B_1_2193 {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        dp= new long[91];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
        sc.close();
    }


    }