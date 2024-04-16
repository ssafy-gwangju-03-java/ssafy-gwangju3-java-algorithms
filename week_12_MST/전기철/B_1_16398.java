package week_12_MST.전기철;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1_16398 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int[] vis=new int[n];
        long ans=0;
        List<int[]>[] lst=new List[n];
        int[][] arr= new int[n][n];
        for(int i=0;i<n;i++){
            String[] s =sc.nextLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            lst[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                lst[i].add(new int[]{arr[i][j],j});
                lst[j].add(new int[]{arr[i][j],i});
            }
        }
        PriorityQueue<int[]> heap=new PriorityQueue<>(Comparator.comparingInt(k -> k[0]));
        heap.add(new int[]{0,0});
        while (!heap.isEmpty()) {
            int[] edge=heap.poll();
            int w=edge[0];
            int now=edge[1];
            if(vis[now]==0){
                vis[now]=1;
                ans+=w;
                for(int[] next : lst[now]){
                    if(vis[next[1]]==0){
                        heap.add(next);
                    }
            }
        }

    }
        System.out.println(ans);
    }
}
