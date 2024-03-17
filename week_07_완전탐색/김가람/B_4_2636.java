package week_07_완전탐색.김가람;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_4_2636 {
    static int R;
    static int C;
    static int[] start;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static int[][] map;
    static int[][] visited;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        R = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);
        map = new int[R][C];
        q = new LinkedList<>();
        start = new int[]{0, 0};

        for (int i = 0; i < R; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        int day = 0;
        int cheese = 0;

        while (true) {
            if (countCheese() == 0) break;      // 치즈가 모두 녹으면 break
            cheese = countCheese();             // 시간 +1 될 때마다 치즈의 양을 세어주어 답을 편하게 도출
            visited = new int[R][C];            // 시간 +1 될 때마다 방문체크배열 초기화
            day++;
            dfs(start);                         // dfs로 막혀있는 부분의 0만 탐색 후 치즈의 겉 부분만 큐에 넣어줌
            melt();                             // 해당 큐를 이용해 치즈 녹이기
        }

        System.out.println(day);
        System.out.println(cheese);
    }

    static void dfs(int[] start) {
        int r = start[0];
        int c = start[1];
        visited[r][c] =  1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (inRange(nr, nc) && visited[nr][nc] == 0) {
                if (map[nr][nc] == 0) dfs(new int[]{nr, nc});
                if (map[nr][nc] == 1) q.add(new int[]{nr, nc});
            }
        }
    }

    static void melt() {
        start = q.peek();          // dfs 시작점 재설정 (딱히 필요하진 않은듯)
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int[] loc = q.poll();
            int r = loc[0];
            int c = loc[1];
            map[r][c] = 0;         // 치즈 녹이기
        }
    }

    static int countCheese() {
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) count++;
            }
        }
        return count;
    }

    static boolean inRange(int r, int c) {
        return (0 <= r && r < R && 0 <= c && c < C);
    }
}

