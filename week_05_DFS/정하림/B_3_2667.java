package java_study.w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class B_3_2667 {
    static int[][] map;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int N, cnt, apt;
    static ArrayList<Integer> lst = new ArrayList<>();

    public static void complex(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + d[0][i];
            int nc = c + d[1][i];
            map[r][c] = 0;
            boolean inRange  = (0<=nr && nr<N && 0<=nc && nc<N);
            if (inRange && map[nr][nc] == 1) {
                apt++;
                complex(nr,nc);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            // Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray()
            map[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    apt = 1;
                    cnt++;
                    complex(i, j);
                    lst.add(apt);
                }
            }
        }

        Collections.sort(lst);
        System.out.println(cnt);
        System.out.println(lst);
        for (int i = 0; i < cnt; i++) {
            System.out.println(lst.get(i));
        }

    }
}
