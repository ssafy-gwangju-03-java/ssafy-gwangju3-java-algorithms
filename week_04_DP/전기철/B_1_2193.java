import java.util.Scanner;

public class B_1_2193 {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        dp= new long[11];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<11;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            System.out.println(dp[x]);
        }
        sc.close();
    }


    }