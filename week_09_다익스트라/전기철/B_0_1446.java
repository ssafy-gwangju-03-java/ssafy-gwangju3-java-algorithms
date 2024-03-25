package week_09_다익스트라.전기철;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class B_0_1446 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        int[] dp=new int[d+1];
        for(int i=1;i<d+1;i++){
            dp[i]=i;
        }
        List<int[]> lst= new ArrayList<>();
        for (int i=0;i<n;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            int cost=sc.nextInt();
            lst.add(new int[]{start,end,cost});
        }
        Collections.sort(lst, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 비교 대상의 요소 순서를 비교하여 정렬
                // 여기서는 start를 기준으로 오름차순으로 정렬하도록 함
                return Integer.compare(a[0], b[0]);
            }
        });
        for(int[] i:lst){
            int s=i[0];
            int e=i[1];
            int c=i[2];
            if(e<=d && c<e-s){
                dp[e]=Math.min(dp[s]+c,dp[e]);
                for(int j=e;j<d+1;j++){
                    dp[j]=Math.min(dp[j-1]+1,dp[j]);
                }
            }
        }

        System.out.println(dp[d]);
    }
}
