package java_study.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_5_1941 {
    static int[] p7 = new int[7]; // 7공주 인덱스 모음
    static int[] checked = new int[25]; // 7공주면 1 표시
    static int[] visited = new int[25];

    static String tmp = ""; // toCharArray()쓰려고
    static char[] map = new char[25];

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0 ,-1, 1};

    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            tmp += br.readLine();
        }
        // 자리배치도 1차원 배열로 받음
        // 따라서 r = idx/5, c = idx%5
        map = tmp.toCharArray();

        // n: 0~24로 모든 학생 훑으면서
        // r: 0~7번의 공주 뽑기
        combi(0, 0);

        System.out.println(total);
    }
    public static void combi(int n, int r) {
        if (r == 7) {
            visited = new int[25];
            // 이다솜이 우위 인지 && 연결됐는지
            if (S_prior() && isLinked(p7[0])) {
                total++;
            }
            return;
        }
        if (n == 25) {
            return;
        }
        // 뽑았으면
        p7[r] = n;
        checked[n] = 1;
        combi(n + 1, r + 1);
        // 복구
        checked[n] = 0;
        // 안뽑았으면
        combi(n+1, r);
    }

    public static boolean S_prior() {
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            if (map[p7[i]] == 'S') {
                cnt++;
            }
        }
        // 이다솜이 우위 차지 했으면 true;
        if (cnt >= 4) {
            return true;
        } else return false;
    }
                                    // rc = idx = r*5+c
    public static boolean isLinked(int rc) {
        // 방문 표시
        visited[rc] = 1;
        for (int d = 0; d < 4; d++) {
            int nr = rc / 5 + dr[d];
            int nc = rc % 5 + dc[d];
            int nrc = nr * 5 + nc;
            boolean inRange = (0 <= nr && nr < 5 && 0 <= nc && nc < 5);
            // 범위 안  &&  7공주 && 방문한적 없음
            if (inRange && checked[nrc] == 1 && visited[nrc] == 0) {
                isLinked(nrc);
            }
        }
        for (int i = 0; i < 7; i++) {
            if (visited[p7[i]] == 0) {
                return false;
            }
        }
        return true;
    }
}
