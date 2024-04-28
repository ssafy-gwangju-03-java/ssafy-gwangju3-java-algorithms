import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_14503 {
    static int N, M;
    static int r, c, d; // 0: 북, 1: 동, 2: 남, 3: tj
    static int[][] matrix;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        // 1 벽
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 1;
        matrix[r][c] = 2;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                d = (d+3)%4;
                if (matrix[r+dr[d]][c+dc[d]] == 0) {
                    r += dr[d];
                    c += dc[d];

                    matrix[r][c] = 2;
                    cnt++;
//                    System.out.printf("%d %d %n",r, c);
                    flag = false;
                    break;
                }
            }

            if (flag) {
//                System.out.println("--------------------------------------");
                r += dr[(d+2)%4];
                c += dc[(d+2)%4];
                if (matrix[r][c] == 1) {
                    matrix[r][c] = 8;
                    break;
                }

            }
        }

        System.out.println(cnt);

    }
}
