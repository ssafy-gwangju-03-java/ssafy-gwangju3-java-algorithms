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

public class B_0_1753 {
    static final int INF = Integer.MAX_VALUE;
    static int V, E, start;

    static int[] dis;

    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_09_다익스트라/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        dis = new int[V + 1];
        Arrays.fill(dis, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
        }

        dijkstra();

        for (int i = 1; i < V + 1; i++) {
            System.out.println(dis[i] == INF ? "INF" : dis[i]);
        }

        br.close();
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.add(new int[]{start, 0});
        dis[start]= 0;

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int distance = edge[1];
            int now = edge[0];

            if (dis[now] < distance) {
                continue;
            }

            for (int[] next : graph.get(now)) {
                int dest = next[0];
                int cost = distance + next[1];

                if (cost < dis[dest]) {
                    dis[dest] = cost;
                    pq.add(new int[]{dest, cost});
                }
            }
        }
    }
}
