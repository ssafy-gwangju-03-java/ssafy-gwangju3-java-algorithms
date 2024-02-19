import java.util.Scanner;

public class B_5_10844 {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        long ans=0;
        dp= new long[101][10];
        for(int i=1;i<10;i++){
            dp[1][i]=1;
        }
        for (int i=2;i<n+1;i++){
            for(int j=0;j<10;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][1];
                }
                else if (j==9){
                    dp[i][j]=dp[i-1][8];
                }
                else{
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                }
            }
        }
        for(int i=0;i<10;i++){
            ans+=dp[n][i];
        }
        System.out.println(ans%1000000000);
        sc.close();
    }


    }