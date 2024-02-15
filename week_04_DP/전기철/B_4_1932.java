import java.util.Scanner;

public class B_4_1932 {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[][] lst = new int[501][501];
        for (int i=0;i<n;i++){
            for (int j=0;j<i+1;j++){
                int x= sc.nextInt();
                lst[i][j]=x;
            }
        }
        long ans=0;
        dp= new long[501][501];
        dp[0][0]=lst[0][0];
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+lst[i][0];
            dp[i][i]=dp[i-1][i-1]+lst[i][i];
        }
        for (int i=2;i<n;i++){
            for(int j=1;j<i;j++){
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+lst[i][j];
            }
        }
        for (int i=0;i<n;i++){
            if(dp[n-1][i]>ans){
                ans=dp[n-1][i];
            }
        }
        System.out.println(ans);




        sc.close();
    }


    }