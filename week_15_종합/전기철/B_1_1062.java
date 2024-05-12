package week_15_종합.전기철;

import java.util.Scanner;

public class B_1_1062 {
    static int ans;
    static int k;
    static int[] check;
    static String[] words;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        words = new String[n];
        check = new int[26];

        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        for (char word : new char[] { 'a', 'n', 't', 'i', 'c' }) {
            check[word - 'a'] = 1; // 보유 처리
        }
        ans = 0;

        if (k < 5) {
            System.out.println(0); // 문자 5개 미만이면 0
        } else if (k == 26) {
            System.out.println(n); // 문자 전부 배울수 있으면 n
        } else {
            dfs(0, 0);
            System.out.println(ans);
        }
    }

    public static void dfs(int x, int now) {
        if (x == k - 5) {
            int cnt = 0;
            for (String word : words) {
                int chk = 1;
                for (char i : word.toCharArray()) {
                    if (check[i - 'a'] != 1) {
                        chk = 0;
                        break;
                    }
                }
                if (chk == 1) { // 그 단어 배울 수 있으면
                    cnt += 1;
                }
            }
            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = now; i < 26; i++) {
            if (check[i] != 1) {
                check[i] = 1;
                dfs(x + 1, i);
                check[i] = 0;
            }
        }
    }
}
