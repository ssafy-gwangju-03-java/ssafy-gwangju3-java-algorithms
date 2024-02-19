import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_0_2606 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int computer_num = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[N];

        for (int i = 0; i < computer_num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        dfs(0);

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) {
                count += 1;
            }
        }

        System.out.println(count - 1);
    }

    private static void dfs(int s) {
        visited[s] = 1;

        for (int i = 0; i < graph.get(s).size(); i++) {
            if (visited[graph.get(s).get(i)] != 1) {
                visited[graph.get(s).get(i)] = 1;
                dfs(graph.get(s).get(i));
            }
        }
    }
}
