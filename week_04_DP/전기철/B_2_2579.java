import java.util.Scanner;

public class B_2_2579 {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] lst = new int[301];
        for (int i=0;i<n;i++){
            int x= sc.nextInt();
            lst[i]=x;
        }
        dp= new long[301];
        dp[0]=lst[0];
        dp[1]=lst[0]+lst[1];
        dp[2]=Math.max((lst[0]+lst[2]) , (lst[1]+lst[2]));
        for(int i=3;i<n;i++){
            dp[i]=Math.max((dp[i-3]+lst[i-1]),dp[i-2])+lst[i];
        }
        System.out.println(dp[n-1]);
    }


    }