package study_week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

    class Point{
        int num;
        double x;
        double y;

        Point(int num, double x, double y){
            this.num = num;
            this.x = x;
            this.y = y;
        }

    }
public class B_3_1774 {

    static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if(weight < o.weight){
                return -1;
            }
            return 1;
        }
    }
    static int n, m;
    static int[] p;

    static void makeset() {
        p = new int[n+1];
        for (int i = 1; i <= n; i++) {
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

    static ArrayList<Edge> edgelist;

    static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y-p2.y, 2));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n+1];
        makeset();
        Point[]points = new Point[n+1];
        edgelist = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(i,x,y);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            union(start,end);
        }
        for(int i = 1; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                double weight = distance(points[i],points[j]);
                edgelist.add(new Edge(points[i].num, points[j].num, weight));
            }
        }
        Collections.sort(edgelist);
        double ans = 0;
        for(int i = 0; i < edgelist.size(); i++){
            Edge edge = edgelist.get(i);

            if(find(edge.from) != find(edge.to)){
                ans += edge.weight;
                union(edge.from, edge.to);
            }
        }
        System.out.println(String.format("%.2f",ans));

    }
}
