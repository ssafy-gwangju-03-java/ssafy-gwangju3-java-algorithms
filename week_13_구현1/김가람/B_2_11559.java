package week_13_구현1.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B_2_11559 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int combo = 0;
        while (true) {
            visited = new boolean[12][6];

            boolean didCombo = false;

            // 배열 전체를 순회
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {

                    // '.' 혹은 '0'(뿌요가 터지고 남은 자리)을 만나면 넘어감
                    if (map[i][j] == '.' || map[i][j] == 0) continue;

                    // 아직 순회하지 않은 뿌요를 만나면 bombCheck 함수 호출
                    // bombCheck 함수는 뿌요가 4개 이상 만나 터지면 true 반환, 터진 적 없으면 false 반환
                    if (!visited[i][j] && bombCheck(i, j, map[i][j])) {
                        didCombo = true;
                    }
                }
            }

            if (didCombo) {
                combo++;
            }
            else break;

            // 중력의 영향을 받아 뿌요가 떨어진다
            gravity();
        }

        System.out.println(combo);
    }

    static void gravity() {
        for (int i = 0; i < 6; i++) {
            Queue<Character> puyos = new LinkedList<>();
            int zeroCnt = 0;

            for (int j = 11; j >= 0; j--) {
                if (map[j][i] == '.') break;
                else {
                    // '0' == 뿌요가 터지고 남은 자리
                    if (map[j][i] == '0') {
                        zeroCnt++;
                    } else {
                        puyos.add(map[j][i]);
                    }
                }
            }

            // 뿌요가 터지고 남은 자리 '0'이 존재한다면
            if (zeroCnt > 0) {
                // 맨 아래에서부터 뿌요를 순차적으로 채워주고 뿌요가 다 떨어진 다음부터는 '.'로 채워준다
                for (int j = 11; j >= 0; j--) {
                    if (map[j][i] == '.') break;    // 이미 '.'인 칸 == 원래 '.'였던 칸, 더 이상 채워줄 필요 없음
                    if (!puyos.isEmpty()) {
                        map[j][i] = puyos.poll();
                    } else {
                        map[j][i] = '.';
                    }
                }
            }
        }
    }

    static boolean bombCheck(int r, int c, char color) {
        visited[r][c] = true;

        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> nodes = new ArrayList<>();
        q.add(new int[]{r, c});
        nodes.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if (0 <= nr && nr < 12 && 0 <= nc && nc < 6) {
                    if (!visited[nr][nc] && map[nr][nc] == color) {
                        nodes.add(new int[]{nr, nc});
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        // 상하좌우로 인접한 뿌요 다 셌는데 4개 이하면 터지지 않음
        if (nodes.size() < 4) {
            return false;
        } else {
            // 4개 이상이면 터짐
            // 지금까지 세준 뿌요들을 불러와서 빈자리 '0'으로 채워줌
            for (int[] node : nodes) {
                map[node[0]][node[1]] = '0';
            }
            return true;
        }
    }
}


