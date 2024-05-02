import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B_3_17281 {
    static int[][] lst;
    static int[] arr;
    static int n;

    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        ans = 0;
        lst = new int[n][9];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 9; j++) {
                lst[i][j] = Integer.parseInt(s[j]);
            }
        }

        permutation(new ArrayList<Integer>(), 8);
        System.out.println(ans);

        sc.close();
    }

    public static void permutation(ArrayList<Integer> list, int cnt) { 
        // 다 뽑았을 때
        if (cnt == 0) {
            int[] lineup = new int[9];
            // 4번 자리에 1번타자 넣는 과정
            for (int i = 0; i < 3; i++) {
                lineup[i] = list.get(i);
            }
            lineup[3] = 0;
            for (int j = 4; j < 9; j++) {
                lineup[j] = list.get(j - 1);
            }

            ans = Math.max(ans, game(lineup)); // 게임 시작
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (list.contains(arr[i])) {
                continue;
            }
            list.add(arr[i]);
            permutation(list, cnt - 1);
            list.remove(list.size() - 1);
        }
    }

    static int game(int[] lineup) {
        int batter = 0;
        int score = 0;
        for (int[] inning : lst) {
            int out = 0;
            int b1 = 0;
            int b2 = 0;
            int b3 = 0;
            while (true) {
                if (out == 3) {
                    break;
                }
                if (inning[lineup[batter]] == 0) { // out
                    out += 1;
                } else if (inning[lineup[batter]] == 1) { // 안타
                    score += b3;
                    b3 = b2;
                    b2 = b1;
                    b1 = 1;
                } else if (inning[lineup[batter]] == 2) { // 2루타
                    score += (b2 + b3);
                    b3 = b1;
                    b2 = 1;
                    b1 = 0;
                } else if (inning[lineup[batter]] == 3) { // 3루타
                    score += (b1 + b2 + b3);
                    b3 = 1;
                    b2 = 0;
                    b1 = 0;
                } else { // 홈런
                    score += (1 + b1 + b2 + b3);
                    b3 = 0;
                    b2 = 0;
                    b1 = 0;
                }
                batter = (batter + 1) % 9;
            }
        }
        return score;
    }
}
