package study_week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_0_1753 {
	static int INF = Integer.MAX_VALUE;
	static int v;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		visited = new boolean[v + 1];
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		int[] dis = new int[v + 1];
		Arrays.fill(dis, INF);
		int start = Integer.parseInt(br.readLine());
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new int[] { b, c });
		}
		dijkstra(start, graph, dis);
		for (int i = 1; i < dis.length; i++) {
			if (dis[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dis[i]);
			}
		}
	}

	static void dijkstra(int start, List<List<int[]>> graph, int[] dis) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
//        boolean [] check = new boolean[v+1];
		pq.offer(new int[] { start, 0 });
		dis[start] = 0;

		while (!pq.isEmpty()) {
			int[] edge = pq.poll();
			int distance = edge[1];
			int now = edge[0];

//            if(check[distance] == true) continue;
//            check[distance] = true;

			if (dis[now] < distance) {
				continue;
			}

			for (int[] next : graph.get(now)) {
				int dest = next[0];
				int cost = distance + next[1];

				if (cost < dis[dest]) {
					dis[dest] = cost;
					pq.offer(new int[] { dest, cost });
				}
			}

		}
	}

}
