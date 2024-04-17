package study_week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1_16398 {
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

    static List<Edge> list = new ArrayList<>();
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

        v = Integer.parseInt(br.readLine());
        e = v;

        StringTokenizer st;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < e; j++) {
                int weight = Integer.parseInt(st.nextToken());
				if(weight!=0){
                list.add(new Edge(i, j, weight));
				}
            }
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
        }

        Collections.sort(list);
        makeset();
        long totalcost = 0;
        int edgecnt = 0;

        for(int i = 0; i < list.size(); i++){
            if(edgecnt == v-1) break;
            Edge edge = list.get(i);
            if(union(edge.from, edge.to)){
                edgecnt++;
                totalcost += edge.weight;
            }
        }

        System.out.println(totalcost);

    }
}
