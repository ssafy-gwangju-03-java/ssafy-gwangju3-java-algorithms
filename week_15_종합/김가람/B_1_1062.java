package week_15_종합.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B_1_1062 {
    static int N;
    static int K;
    static int ans = 0;
    static boolean[] alp;
    static String[] words;
    static ArrayList<Character> newChars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        K = Integer.parseInt(info[1]);

        // 남극언어의 모든 단어는 "anta"로 시작하고 "tica"로 끝나므로 a, n, t, i, c 최소 5개의 알파벳을 알아야 읽을 수 있다
        // 따라서 5개 이상의 글자를 배우지 못하면 어떤 단어도 읽지 못한다
        if (K < 5) {
            System.out.println(0);
        } else {
            ArrayList<Character> antarcticChars = new ArrayList<>(Arrays.asList('a', 'n', 't', 'i', 'c'));

            // 각 알파벳을 아는지 모르는지를 boolean으로 체크해줄 배열
            alp = new boolean[26];

            // 'a', 'n', 't', 'i', 'c' 5개 글자는 무조건 배워야 함
            // 따라서 이후 배워야할 새로운 글자는 K-5개여야 함
            for (char c : antarcticChars) {
                alp[c - 'a'] = true;
            }

            words = new String[N];              // N개의 단어들을 저장해줄 배열
            newChars = new ArrayList<>();       // 단어들 중 a, n, t, i, c를 제외한 알파벳을 중복없이 저장할 ArrayList

            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                words[i] = word;

                for (int j = 4; j < word.length() - 4; j++) {
                    char c = word.charAt(j);
                    if (!newChars.contains(c) && !antarcticChars.contains(c)) {
                        newChars.add(c);
                    }
                }
            }

            // a, n, t, i, c 5개의 알파벳 + 새로운 알파벳의 갯수가 K보다 작거나 같다면 모든 글자를 배울 수 있다
            // 따라서 제시된 단어 전부를 읽을 수 있다
            if (newChars.size() + 5 <= K) {
                System.out.println(N);

            // 새로운 알파벳의 갯수가 K-5개보다 많다면 그 중에서 무슨 알파벳을 배울지 조합으로 K-5개 고른다
            } else {
                ans = 0;
                comb(0, 0);
                System.out.println(ans);
            }
        }
    }

    public static void comb(int lev, int start) {
        // 조합으로 선택 완료된 K-5개의 알파벳을 배우기 시작
        // 제시된 단어들을 순회하며 어떤 단어를 읽을 수 있는지 판별한 후 ans값 갱신
        if (lev == K - 5) {
            int currAns = 0;
            for (String word : words) {
                boolean canRead = true;
                for (int i = 0; i < word.length(); i++) {
                    if (!alp[word.charAt(i) - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) currAns++;
            }
            ans = Math.max(currAns, ans);
        }

        for (int i = start; i < newChars.size(); i++) {
            alp[newChars.get(i) - 'a'] = true;
            comb(lev + 1, i + 1);
            alp[newChars.get(i) - 'a'] = false;
        }
    }
}


