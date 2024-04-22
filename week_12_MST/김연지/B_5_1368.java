package study_week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_5_1368 {
    static int[]p;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]wall = new int [n+1];
        p = new int [n+1];
        PriorityQueue<Edge>pq = new PriorityQueue<>();
        int ans = 0;

        for(int i = 1; i <= n; i++){
            wall[i] = Integer.parseInt(br.readLine());
            p[i] = i;
        }

        for(int i = 1; i <= n; i++){
            String[]temp = br.readLine().split(" ");
            for(int j = 1; j <= n; j++){
                int w = Integer.parseInt(temp[j-1]);
                if(i == j){
                    pq.add(new Edge(0,i,wall[i]));
                }else if(i < j){{
                    pq.add(new Edge(i,j,w));
                }}
            }
        }

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(find(edge.from)==find(edge.to)){
                continue;
            }
            union(edge.from,edge.to);
            ans += edge.weight;
        }
        System.out.println(ans);

    }

//    static void makeset(){
//        p = new int[n+1];
//        for(int i = 1; i <= n; i++){
//            p[i] = i;
//        }
//    }

    static int find(int x){
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px > px){
            p[px] = py;
        }else{
            p[py] = px;
        }
    }

    static class Edge implements Comparable<Edge>{
        int from,to,weight;
        public Edge(int from,int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
}
