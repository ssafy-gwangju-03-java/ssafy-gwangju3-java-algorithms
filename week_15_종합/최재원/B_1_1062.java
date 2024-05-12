package week_15_종합.최재원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1_1062 {
    static int N, K;
    static String[] arr;
    static boolean[] selected;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        if (K < 5) {
            System.out.println(answer);
        } else if (K == 26) {
            System.out.println(N);
        } else {
            char[] initialArr = {'a', 'n', 't', 'i', 'c'};
            selected = new boolean[26];

            for (char c : initialArr) {
                selected[c - 'a'] = true;
            }

            selectWordsToLearn(0, 0);
            System.out.println(answer);
        }

        br.close();
    }


    static void selectWordsToLearn(int idx, int start) {
        if (idx == K - 5) {
            countReadableWords();
            return;
        }

        for (int i = start; i < 26; i++) {
            if (selected[i]) {
                continue;
            }

            selected[i] = true;
            selectWordsToLearn(idx + 1, i + 1);
            selected[i] = false;
        }
    }

    static void countReadableWords() {
        int count = 0;

        for (String word : arr) {
            word = word.substring(4, word.length() - 4);
            boolean containsWord = true;

            for (int i = 0; i < word.length(); i++) {
                if (!selected[word.charAt(i) - 'a']) {
                    containsWord = false;
                    break;
                }
            }

            if (containsWord) {
                count += 1;
            }
        }

        answer = Math.max(count, answer);
    }
}
