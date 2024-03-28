package week_09_다익스트라.전기철;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B_5_1865 {
    static final int INF = (int) 1e9;
    static int n;
    static List<int[]> lst;
    static int[] dis;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int t=0;t<tc;t++){
            n=sc.nextInt();
            int m=sc.nextInt();
            int w=sc.nextInt();
            lst=new ArrayList<>();
            dis=new int[n+1];
            Arrays.fill(dis, INF);
            for(int i=0;i<m;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                lst.add(new int[]{a,b,c});
                lst.add(new int[]{b,a,c});
            }
            for(int i=0;i<w;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                lst.add(new int[]{a,b,-c});
            }

            if(bellman_ford(1)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    static boolean bellman_ford(int start){
        for(int i=0;i<n;i++){
            for(int[] line :lst){
                int now=line[0];
                int next=line[1];
                int cost=line[2];
                if(dis[now]+cost<dis[next]){
                    dis[next]=dis[now]+cost;
                    if(i==n-1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
