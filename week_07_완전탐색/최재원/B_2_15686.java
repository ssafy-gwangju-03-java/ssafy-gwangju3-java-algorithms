import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2_15686 {
    static int N, M;
    static ArrayList<int[]> chicken, house;
    static int[][] c;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        c = new int[M][2];
        chicken = new ArrayList<>();
        house = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if (arr[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        comb(0, 0);

        System.out.println(answer);
    }

    private static void comb(int idx, int start) {
        if (idx == M) {
            int min_distance = 0;

            for (int[] house_rc : house) {
                int temp = Integer.MAX_VALUE;

                for (int[] chicken_rc: c) {
                    int dist = Math.abs(chicken_rc[0] - house_rc[0]) + Math.abs(chicken_rc[1] - house_rc[1]);
                    temp = Math.min(dist, temp);
                }

                min_distance += temp;
            }

            answer = Math.min(min_distance, answer);

            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            c[idx] = chicken.get(i);
            comb(idx + 1, i + 1);
        }
    }
}
