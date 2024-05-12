import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1_1062 {
    static int N, K;
    static  String[] words;
    static boolean[] readable = new boolean[26];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replace("anat | tica", "");
        }


        boolean[] readable = new boolean[26];
        for (char c : "antatica".toCharArray()) {
            readable[c - 'a'] = true;
        }
        if (K < 5) {
            System.out.println(0);
        } else if (K == 26) {
            System.out.println(N);

        } else {
            teach(readable, 0, 0);
            System.out.println(ans);
        }


    }

    private static void teach(boolean[] readable, int abc, int k) {
        if (k == K-5) {
            count(readable);
            return;
        }

        for (int i = abc; i < 26; i++) {
            if (readable[i]) continue;
            readable[i] = true;
            teach(readable, i, k+1);
            readable[i] = false;
        }
    }

    private static void count(boolean[] readable) {
        int cnt = 0;
        for (String word : words) {
            boolean flag = true;
            for (char abc : word.toCharArray()) {
                if (!readable[abc - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }

        ans = Math.max(ans, cnt);
    }
}