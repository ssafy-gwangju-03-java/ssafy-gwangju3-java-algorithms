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

public class B_0_1916 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, start, end;
    static int[] dis;

    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_09_다익스트라/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        dis = new int[N + 1];
        Arrays.fill(dis, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dis[end]);
        br.close();
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        pq.add(new int[]{start, 0});
        dis[start] = 0;

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
