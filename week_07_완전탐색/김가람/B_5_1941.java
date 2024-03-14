package week_07_완전탐색.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_5_1941 {
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static char[][] map;
    static ArrayList<int[]> locs;
    static int[][] newMap;
    static int[][] visited;
    static int dfsResult;
    static int gang;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // locs == locations, 25개의 좌표값을 넣을 ArrayList
        // 25개 좌표값 중에서 7개를 조합으로 추출하여 '소문난 칠공주'를 결성하였는지의 여부를 모든 경우의 수에서 체크
        locs = new ArrayList<>();
        map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                map[i][j] = s[j];
                locs.add(new int[]{i, j});
            }
        }

        ans = 0;
        comb(0, 0, new int[7]);
        System.out.println(ans);
    }

    // 조합으로 range(25)에서 7개의 숫자를 추출하는 combination 함수
    static void comb(int lev, int start, int[] indices) {

        // 7개의 숫자가 완성되면 7공주 여부를 판단해주는 isSevenPrinces 함수 호출
        if (lev == 7) {
            if (isSevenPrinces(indices)) ans++;
            return;
        }

        for (int i = start; i < 25; i++) {
            indices[lev] = i;
            comb(lev + 1, i + 1, indices);
        }
    }

    static boolean isSevenPrinces(int[] indices) {
        newMap = new int[5][5];
        visited = new int[5][5];

        // 25개의 좌표값을 갖고 있는 loc에서 조합으로 추출된 indices를 이용해 7개의 좌표 선정
        // 7개의 좌표 값을 새 지도에 1로 표시
        for (int i = 0; i < 7; i++) {
            int[] loc = locs.get(indices[i]);
            newMap[loc[0]][loc[1]] = 1;
        }

        // 1로 표시된 부분에서 dfs 구동
        // dfsResult == dfs가 탐색한 칸의 갯수
        // gang == 이다솜파 학생
        boolean didDfs = false;
        dfsResult = 0;
        gang = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (newMap[i][j] == 1 && visited[i][j] == 0) {
                    dfs(i, j);
                    didDfs = true;
                    break;
                }
            }
            if (didDfs) break;
        }

        // true 반환 조건:
        // dfs가 7개의 칸을 탐색 완료 하였고 (7명의 학생이 서로 가로나 세로로 인접해 있고)
        // 이다솜파 학생이 적어도 4명 이상일 때
        return (dfsResult == 7 && gang >= 4);
    }

    static void dfs(int r, int c) {
        dfsResult++;
        if (map[r][c] == 'S') gang++;
        visited[r][c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (inRange(nr, nc) && newMap[nr][nc] == 1 && visited[nr][nc] == 0) {
                dfs(nr, nc);
            }
        }
    }

    static boolean inRange(int r, int c) {
        return (0 <= r && r < 5 && 0 <= c && c < 5);
    }
}


