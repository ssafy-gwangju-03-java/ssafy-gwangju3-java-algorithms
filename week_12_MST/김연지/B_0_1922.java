package study_week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_0_1922 {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Edge[]edgelist;
	static int v,e;
	static int[]p;
	
	static void makeset() {
		p = new int[v+1];
		for(int i = 1; i <= v; i++) {
			p[i]=i;
		}
	}
	
	static int find(int x) {
		if(p[x]==x)return x;
		return p[x] = find(p[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		p[y] = p[x];
		return true;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		edgelist = new Edge[e];
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgelist[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgelist);
		makeset();
		int totalcost = 0;
		int edgecnt = 0;
		
		for(Edge edge:edgelist) {
			if(union(edge.from, edge.to)) {
				totalcost += edge.weight;
				
				if(++edgecnt == v-1)break;
			}
		}
		
		System.out.println(totalcost);
		
	}

}
