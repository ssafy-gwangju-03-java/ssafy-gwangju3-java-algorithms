package week_07_완전탐색.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_0_9663 {
    static int cnt;
    static int N;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        cnt = 0;
        queen(0);
        System.out.println(cnt);
    }

    static void queen(int row) {
        if (row == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            boolean canPlace = true;
            for (int j = row - 1; j >= 0; j--) {
                if (board[j] == i || row - j == Math.abs(board[j] - i)) {
                    canPlace = false;
                    break;
                }
            }
            if (canPlace) {
                board[row] = i;
                queen(row + 1);
                board[row] = 0;
            }
        }
    }
}
