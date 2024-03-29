package study_week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

    class Edge {
        int v;
        int w;
        int cost;

        public Edge (int v, int w, int cost) {
            this.v = v; // 나가는 정점
            this.w = w; // 들어오는 정점
            this.cost = cost;
        }
    }
public class B_5_11657 {

    static final int INF = (int)1e9;
    static int n,m;
    static Edge[] graph;
    static long[]dis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new Edge[m];
        dis = new long[n+1];
        for(int i = 1; i <= n; i++){
            dis[i] = INF;
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[i] = new Edge(a, b, c);
        }

        if(BellmanFord(1)){
            System.out.println(-1);
        }else{
            for(int i = 2; i <= n; i++){
                if(dis[i]==INF){
                    System.out.println(-1);
                }else{
                    System.out.println(dis[i]);
                }
            }
        }
    }
    static boolean BellmanFord(int start){
        dis[start] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < m; j++){
                int cur = graph[j].v;
                int next = graph[j].w;
                int cost = graph[j].cost;
                if(dis[cur]==INF) continue;
                if(dis[next] > (dis[cur] + cost)){
                    dis[next] = dis[cur] + cost;

                    if(i == n){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
