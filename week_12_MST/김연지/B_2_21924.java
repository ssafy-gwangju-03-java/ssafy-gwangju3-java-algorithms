package study_week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2_21924 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    static Edge[]edgelist;
//    static List<Edge> list = new ArrayList<>();
    static int v, e;
    static int[] p;

    static void makeset() {
        p = new int[v+1];
        for (int i = 1; i <= v; i++) {
            p[i] = i;
        }
    }

    static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        p[y] = p[x];
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edgelist = new Edge[e];
        long total = 0;
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            total += weight;
            edgelist[i] = new Edge(from,to,weight);
        }

        Arrays.sort(edgelist);
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
            if(p[i]!= p[i+1]){
                flag = false;
                break;
            }
        }

    if(flag == false){
        System.out.println(-1);
    }else{

        System.out.println(total - totalcost);
    }


    }
}
