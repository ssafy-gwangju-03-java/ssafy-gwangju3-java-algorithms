import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_4_11724 {
    static int N, M;
    static int[] visited;
    static int[][] adjm;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_05_DFS/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjm = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adjm[s][e] = 1;
            adjm[e][s] = 1;
        }

        int answer = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (visited[i] == 0) {
                    answer += 1;
                    dfs(i);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int r) {
        visited[r] = 1;

        for (int i = 1; i < N + 1; i++) {
            if (adjm[r][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }
}
