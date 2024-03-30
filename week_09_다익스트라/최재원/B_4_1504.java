import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_4_1504 {
    static final int INF = 200000 * 1000;
    static int V, E;

    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int dist1 = 0;
        dist1 += dijkstra(1, v1);
        dist1 += dijkstra(v1, v2);
        dist1 += dijkstra(v2, V);

        int dist2 = 0;
        dist2 += dijkstra(1, v2);
        dist2 += dijkstra(v2, v1);
        dist2 += dijkstra(v1, V);

        System.out.println((dist1 >= INF && dist2 >= INF) ? -1 : Math.min(dist1, dist2));
    }

    static int dijkstra(int start, int end) {
        int[] distance = new int[V + 1];
        Arrays.fill(distance, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.add(new int[]{start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int now = edge[0];
            int dist = edge[1];

            if (distance[now] < dist) {
                continue;
            }

            for (int[] next : graph.get(now)) {
                int nextNode = next[0];
                int cost = next[1];

                int newCost = dist + cost;

                if (newCost >= distance[nextNode]) {
                    continue;
                }

                distance[nextNode] = newCost;
                pq.add(new int[]{nextNode, newCost});
            }
        }

        return distance[end];
    }
}
