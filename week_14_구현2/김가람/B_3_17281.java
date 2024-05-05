package week_14_구현2.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_3_17281 {
    static int INNING;
    static int ans;
    static int[][] game;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        INNING  = Integer.parseInt(br.readLine());
        game = new int[INNING][9];

        for (int i = 0; i < INNING; i++) {
            String[] info = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                game[i][j] = Integer.parseInt(info[j]);
            }
        }

        ans = Integer.MIN_VALUE;
        perm(0, new int[8], new boolean[9]);
        System.out.println(ans);
    }

    // 순열로 타순 정해줌
    public static void perm (int lev, int[] selected, boolean[] visited) {
        if (lev == 8) {

            // 1번 선수는 고정이므로 8명의 선수들을 먼저 섞은 후 4번 자리에 1번 선수를 끼워넣는다
            int[] selectedWithFirstPlayer = new int[9];
            for (int i = 0; i < 3; i++) {
                selectedWithFirstPlayer[i] = selected[i];
            }
            selectedWithFirstPlayer[3] = 0;
            for (int i = 4; i < 9; i++) {
                selectedWithFirstPlayer[i] = selected[i-1];
            }

            // 배치 완료 후 play
            ans = Math.max(ans, play(selectedWithFirstPlayer));
            return;
        }

        for (int i = 1; i <= 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[lev] = i;
                perm(lev + 1, selected, visited);
                visited[i] = false;
            }
        }
    }

    public static int play(int[] players) {
        int score = 0;
        int currPlayer = 0;     // 타순은 이닝이 변경되어도 순서를 유지

        for (int i = 0; i < INNING; i++) {
            int[] base = new int[3];
            int out = 0;

            // 3 아웃이 발생할때까지 1 이닝은 계속됨
            while (out < 3) {
                int currHit = game[i][players[currPlayer]];

                if (currHit == 0) {
                    out++;
                } else if (currHit == 1) {
                    score += base[2];
                    for (int j = 2; j >= 1; j--) {
                        base[j] = base[j-1];
                    }
                    base[0] = 1;
                } else if (currHit == 2) {
                    score += (base[1] + base[2]);
                    base[2] = base[0];
                    base[0] = 0;
                    base[1] = 1;
                } else if (currHit == 3) {
                    score += (base[0] + base[1] + base[2]);
                    base = new int[]{0, 0, 1};
                } else if (currHit == 4) {
                    score += (base[0] + base[1] + base[2] + 1);
                    base = new int[]{0, 0, 0};
                }

                // 9번 타자까지 쳤으면 1번부터 다시 시작
                currPlayer = (currPlayer + 1) % 9;
            }
        }

        return score;
    }
}


