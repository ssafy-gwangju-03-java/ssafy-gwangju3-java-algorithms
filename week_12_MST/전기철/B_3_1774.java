package week_12_MST.전기철;

import java.util.Arrays;
import java.util.Scanner;

public class B_3_1774 {
    static int[] p;
    static Point[] points;
    static Edge[] edges;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        p=new int[n+1];
        for(int i=1;i<n+1;i++){
            p[i]=i;
        }

        points=new Point[n+1];
        edges= new Edge[(n-1)*n/2];
        for(int i=1;i<n+1;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            points[i]=new Point(i,a,b);
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(union(x, y)){
                cnt+=1;
            }
        }
        int chk=0;
        for(int i=1;i<n+1;i++){
            for(int j=i+1;j<n+1;j++){
                Point p1=points[i];
                Point p2=points[j];
                double dis= Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
                edges[chk]=new Edge(p1.num, p2.num, dis);
                chk+=1;
            }
        }
        Arrays.sort(edges);
        double ans=0;
        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                ans += edge.weight;
                if (++cnt == n - 1) break;
            }
        }
        System.out.printf("%.2f",ans);
    }
    static boolean union(int a, int b) {
        a = findset(a);
        b = findset(b);
        if (a == b) {
            return false;
        }
        p[b] = a;
        return true;
    }
    static int findset(int a) {
        if (a == p[a]) {
            return a;
        }
        return p[a] = findset(p[a]);
    }
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
            return Double.compare(this.weight, o.weight);
        }
    }
}
class Point{
    int num;
    double x,y;
    Point(int num,double x,double y){
        this.num=num;
        this.x=x;
        this.y=y;
    }
}