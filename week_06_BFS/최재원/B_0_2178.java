import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_0_2178 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new int[N][M];
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int r = 0;
        int c = 0;

        int count = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        visited[r][c] = 1;
        boolean check = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            count += 1;

            for (int s = 0; s < size; s++) {
                int[] poll = queue.poll();
                r = poll[0];
                c = poll[1];

                if (r == N - 1 && c == M - 1) {
                    check = true;
                    break;
                }


                for (int i = 0; i < 4; i++) {
                    int nr = r + dy[i];
                    int nc = c + dx[i];

                    if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                        if (visited[nr][nc] == 0 && arr[nr][nc] == 1) {
                            queue.add(new int[]{nr, nc});
                            visited[nr][nc] = 1;
                        }
                    }
                }
            }
            if (check) {
                break;
            }
        }

        System.out.println(count);
    }
}