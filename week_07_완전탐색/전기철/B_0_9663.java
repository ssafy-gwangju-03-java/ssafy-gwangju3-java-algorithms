package week_07_완전탐색.전기철;

import java.util.Scanner;

public class B_0_9663 {
    static int n,cnt;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        cnt=0;
        ans=new int[n];
        queen(0);

        System.out.println(cnt);
        sc.close();
    }
    public static void queen(int x){
        if(x==n){
            cnt+=1;
            return;

        }
        for (int i=0;i<n;i++){
            ans[x]=i;
            if(check(x)){
                queen(x+1);
            }
        }

    }
    public static boolean check(int x){
        for(int i=0;i<x;i++){
            if(ans[i]==ans[x] || Math.abs(ans[i]-ans[x])==x-i){
                return false;
            }
        }
        return true;
    }
    
}
