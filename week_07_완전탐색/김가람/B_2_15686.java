package week_07_완전탐색.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2_15686 {
    static int N;
    static int M;
    static int answer;
    static int[][] map;
    static ArrayList<int[]> chickenStores;
    static ArrayList<int[]> house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        map = new int[N][N];
        chickenStores = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if (map[i][j] == 1) house.add(new int[]{i, j});
                if (map[i][j] == 2) chickenStores.add(new int[]{i, j});
            }
        }

        answer = Integer.MAX_VALUE;
        chooseChicken(0, 0, new int[M]);
        System.out.println(answer);
    }

    // combIdx == 전체 치킨집의 갯수를 나타내는 숫자(1~N)에서 M개의 숫자를 추출한 조합
    // 해당 경우의 수를 인덱스로 사용하여 치킨집 선택 예정
    static void chooseChicken(int lev, int start, int[] combIdx) {
        if (lev == M) {
            // s == 해당 회차의 치킨거리의 합
            int s = 0;
            for (int i = 0; i < house.size(); i++) {
                int[] houseLoc = house.get(i);
                int hr = houseLoc[0];
                int hc = houseLoc[1];
                int chickenDistance = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    int[] chickenLoc = chickenStores.get(combIdx[j]);
                    int cr = chickenLoc[0];
                    int cc = chickenLoc[1];
                    int tempDistance = Math.abs(hr - cr) + Math.abs(hc - cc);
                    chickenDistance = Math.min(chickenDistance, tempDistance);
                }
                s += chickenDistance;
            }
            answer = Math.min(answer, s);
            return;
        }

        for (int i = start; i < chickenStores.size(); i++) {
            combIdx[lev] = i;
            chooseChicken(lev + 1, i + 1, combIdx);
        }
    }
}
