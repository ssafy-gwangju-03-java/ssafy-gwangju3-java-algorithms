package study_week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_4_14621 {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    static ArrayList<Edge> edgelist;
    static int v,e;
    static int[]p;
    static void makeset(){
        p = new int[v+1];
        for(int i = 1; i <= v; i++){
            p[i] = i;
        }
    }
    static int find(int x){
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }
    static boolean union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y) return false;
        p[y] = p[x];
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edgelist = new ArrayList<>();
        int[]check = new int[v+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= v; i++){
            if(st.nextToken().equals("M")){
                check[i] = 0;
            }else{
                check[i] = 1;
            }
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(check[from]!= check[to]){
            edgelist.add(new Edge(from, to, weight));
            }
        }
        Collections.sort(edgelist);
        makeset();
        long totalcost = 0;
        int edgecnt = 0;
        for(Edge edge:edgelist){
            if(union(edge.from,edge.to)){
                totalcost += edge.weight;

                if(++edgecnt == v-1) break;
            }
        }
        for(int i = 1; i <= v; i++){
            find(i);
        }
        boolean flag = true;
        for(int i = 1; i < v; i++){
            if(p[i]!=p[i+1]){
                flag = false;
            }
        }

        if(flag == false){
            System.out.println(-1);
        }else{
        System.out.println(totalcost);
        }
//        System.out.println(Arrays.toString(p));

    }
}
