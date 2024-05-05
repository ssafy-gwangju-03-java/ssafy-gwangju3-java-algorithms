import java.util.Scanner;

public class B_3_17281 {
    static int N;
    static int[][] inning;
    static int maxScore;
    static int[] lineup = new int[10];
    static boolean[] selected = new boolean[10];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        inning = new int[N][10];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= 9; j++) {
                inning[i][j] = sc.nextInt();
            }
        }

        // 1번 선수를 4번 타자
        lineup[4] = 1;
        selected[4] = true;

        // 2번 선수 부터
        perm(2);
        System.out.println(maxScore);


    }

    private static void perm(int turn) {
        if (turn == 10) {
            maxScore = Math.max(play(), maxScore);
            return;
        }

        for (int p = 1; p <= 9; p++) {
            if (!selected[p]) {
                selected[p] = true;
                lineup[p] = turn;
                perm(turn + 1);
                selected[p] = false;
            }
        }
    }

    private static int play() {
        int score = 0;
        int player = 1;
        for (int i = 0; i < N; i++) {
            int out = 0;
            boolean[] base = new boolean[4]; // 1,2,3루
            while (out < 3) {
                switch (inning[i][lineup[player]]) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[2] = true;
                            base[1] = false;
                        }
                        base[1] = true;
                        break;
                    case 2:
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;
                        break;
                    case 3:
                        for (int b = 1; b <= 3; b++) {
                            if (base[b]) score++;
                        }
                        base = new boolean[4];
                        base[3] = true;
                        break;
                    case 4:
                        for (int b = 1; b <= 3; b++) {
                            if (base[b]) score++;
                        }
                        score++;
                        base = new boolean[4];
                        break;
                }
                player++;
                player = player > 9 ? 1: player;

            }

        }
        return score;
    }
}
