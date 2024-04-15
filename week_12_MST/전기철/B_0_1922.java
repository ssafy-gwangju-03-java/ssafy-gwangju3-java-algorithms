package week_12_MST.전기철;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_0_1922 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] vis=new int[n+1];
        int ans=0;
        List<int[]>[] lst=new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            lst[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            lst[a].add(new int[]{c,b});
            lst[b].add(new int[]{c,a});
        }
        PriorityQueue<int[]> heap=new PriorityQueue<>(Comparator.comparingInt(k -> k[0]));
        heap.add(new int[]{0,1});
        while (!heap.isEmpty()) {
            int[] edge=heap.poll();
            int w=edge[0];
            int now=edge[1];
            if(vis[now]==0){
                vis[now]=1;
                ans+=w;
                for(int[] next : lst[now]){
                    heap.add(next);
            }
        }

    }
        System.out.println(ans);
}
}