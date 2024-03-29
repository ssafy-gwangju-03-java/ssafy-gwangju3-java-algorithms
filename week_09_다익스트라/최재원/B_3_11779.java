import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_3_11779 {
    static final int INF = Integer.MAX_VALUE;
    static int n, m, start, end;

    static int[] distance;

    static List<List<int[]>> graph;
    static List<List<Integer>> path;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("ssafy-gwangju3-java-algorithms/week_09_다익스트라/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());


        graph = new ArrayList<>();
        path = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            path.add(new ArrayList<>());
        }


        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n + 1; i++) {
            path.get(i).add(start);
        }


        dijkstra(start);

        System.out.println(distance[end]);
        System.out.println(path.get(end).size());
        for (int i = 0; i < path.get(end).size(); i++) {
            System.out.print(path.get(end).get(i) + " ");
        }

    }

    static void dijkstra(int start) {
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
                };

                List<Integer> newPath = new ArrayList<>(path.get(now));
                newPath.add(nextNode);
                path.set(nextNode, newPath);

                distance[nextNode] = newCost;
                pq.add(new int[]{nextNode, newCost});
            }
        }
    }

}
