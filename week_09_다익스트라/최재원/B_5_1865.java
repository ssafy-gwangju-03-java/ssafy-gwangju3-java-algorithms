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

public class B_5_1865 {
    static final int INF = (int) 1e9;
    static int N, M, W;
    static int[] dist;

    static List<Edge> graph;

    static class Edge {
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_09_다익스트라/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());


            graph = new ArrayList<>();

            dist = new int[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph.add(new Edge(a, b, c));
                graph.add(new Edge(b, a, c));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph.add(new Edge(a, b, -c));
            }

            boolean hasNegativeCycle = false;

            for (int i = 1; i < N + 1; i++) {
                if (BellmanFord(i)) {
                    hasNegativeCycle = true;
                    break;
                }
            }

            if (hasNegativeCycle) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

        }

        System.out.println(sb);
        br.close();
    }

    public static boolean BellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < N; i++) {
            boolean isUpdated = false;
            for (Edge edge : graph) {
                int v = edge.v;
                int w = edge.w;
                int cost = edge.cost;

                if (dist[v] == INF) {
                    continue;
                }

                if (dist[v] != INF && dist[w] > dist[v] + cost) {
                    dist[w] = dist[v] + cost;
                    isUpdated = true;

                    if (i == N - 1) {
                        return true;
                    }
                }
            }

            if (!isUpdated) {
                break;
            }
        }

        return false;
    }

}
