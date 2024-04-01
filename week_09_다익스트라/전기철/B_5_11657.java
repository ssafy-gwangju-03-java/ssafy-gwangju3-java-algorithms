package week_09_다익스트라.전기철;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B_5_11657{
    static int INF = 5000001;
    static List<int[]> lst;
    static long[] dis; // int로 진행하면 underflow 발생
    static int n,m;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        lst = new ArrayList<>();
        dis=new long[n+1];
        Arrays.fill(dis,INF);

        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            lst.add(new int[]{a,b,c});
        }
        if(bellman_ford(1)){
            for(int i=2;i<n+1;i++){
                if(dis[i]==INF){
                    System.out.println(-1);
                }
                else{
                    System.out.println(dis[i]);
                }
            }
        }
        else{
            System.out.println(-1);
        }

    }
    static boolean bellman_ford(int start){
        dis[start]=0;
        for(int i=0;i<n;i++){
            for(int[] line : lst){
                int now=line[0];
                int next=line[1];
                int cost=line[2];
                if(dis[now]!=INF && dis[now]+cost<dis[next]){
                    dis[next]=dis[now]+cost;
                    if(i==n-1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}