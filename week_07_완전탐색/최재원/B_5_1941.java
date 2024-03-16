import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B_5_1941 {
    static int N = 5;
    static char[][] arr;
    static int[] c;

    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_07_완전탐색/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[N][N];
        c = new int[7];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            arr[i] = line;
        }

        comb(0, 0);

        System.out.println(answer);
    }

    private static void comb(int idx, int start) {
        if (idx == 7) {
            validate(c);
            return;
        }

        for (int i = start; i < 25; i++) {
            c[idx] = i;
            comb(idx + 1, i + 1);
        }
    }

    private static void validate(int[] selected_nums) {
        int[][] students = comb_to_index(selected_nums);

        if (validate_SCount(students)) {
            int[][] temp = new int[5][5];

            for (int[] student : students) {
                int r = student[0];
                int c = student[1];

                temp[r][c] = 1;
            }

            int count = 0;
            visited = new boolean[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (temp[i][j] == 1 && !visited[i][j]) {
                        count += 1;
                        bfs(i, j, temp);
                    }
                }
            }

            if (count == 1) {
                answer += 1;
            }
        }
    }

    private static int[][] comb_to_index(int[] selected_nums) {
        int[][] students = new int[7][2];

        for (int i = 0; i < selected_nums.length; i++) {

            int r = selected_nums[i] / 5;
            int c = selected_nums[i] % 5;

            students[i] = new int[]{r, c};
        }

        return students;
    }

    private static boolean validate_SCount(int[][] students) {
        int count = 0;

        for (int[] student : students) {
            int r = student[0];
            int c = student[1];

            if (arr[r][c] == 'S') {
                count += 1;
            }
        }

        return count >= 4;
    }

    private static void bfs(int i, int j, int[][] temp) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                boolean inRange = (0 <= nr && nr < 5 && 0 <= nc && nc < 5);

                if (inRange && temp[nr][nc] == 1 && !visited[nr][nc]) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

    }
}
