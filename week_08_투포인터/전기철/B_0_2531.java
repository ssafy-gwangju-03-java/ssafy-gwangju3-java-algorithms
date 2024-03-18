package week_08_투포인터.전기철;

import java.util.Scanner;

public class B_0_2531 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        int k=sc.nextInt();
        int c=sc.nextInt();
        int[] lst=new int[n];
        int[] good=new int[d+1];
        for(int i=0;i<n;i++){
            lst[i]=sc.nextInt();
        }
        int cnt=1;
        good[c]=1;
        for(int i=0;i<k;i++){
            if (good[lst[i]]==0){
                cnt+=1;
            }
            good[lst[i]]+=1;
        }
        int mx=cnt;
        for(int i=1;i<n;i++){
            int end=(i+k-1)%n;
            if (good[lst[end]]==0){
                cnt+=1;
            }
            good[lst[end]]+=1;
            good[lst[i-1]]-=1;
            if(good[lst[i-1]]==0){
                cnt-=1;
            }
            mx=Math.max(cnt,mx);
        }
        System.out.println(mx);
        sc.close();
    }

}
