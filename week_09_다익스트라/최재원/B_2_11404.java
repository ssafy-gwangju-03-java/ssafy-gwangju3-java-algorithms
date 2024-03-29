import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2_11404 {
    static final int INF = (int) 1e9;
    static int n, m;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_09_다익스트라/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] x = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(x[i], INF);
        }
        for (int i = 1; i < n + 1; i++) {
            x[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (x[a][b] > c) {
                x[a][b] = c;
            }
        }

        for (int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    x[a][b] = Math.min(x[a][b], x[a][k] + x[k][b]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sb.append(x[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
