import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_0_2644 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int relationships = Integer.parseInt(br.readLine());

        for (int i = 0; i < relationships; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        dfs(from - 1, 0);

        if (visited[to - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(visited[to - 1]);
        }
    }

    private static void dfs(int s, int count) {
        visited[s] = count;

        for (int i = 0; i < graph.get(s).size(); i++) {
            if (visited[graph.get(s).get(i)] == 0) {
                dfs(graph.get(s).get(i), count + 1);
            }
        }
    }
}
