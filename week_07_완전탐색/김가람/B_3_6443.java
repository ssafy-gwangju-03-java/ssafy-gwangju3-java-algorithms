package week_07_완전탐색.김가람;

import java.io.*;

public class B_3_6443 {
    static BufferedWriter bw;
    static int[] chars;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            // chars == 예제 알파벳의 계수를 세어줄 배열
            // 각 알파벳을 위한 26칸의 배열을 먼저 설정한 뒤 카운팅 해준다
            // 이러한 형태의 배열을 쓰는 이유는 메모리 초과를 방지하기 위해서이다
            // 한없이 긴 예제(예: 'aaaabbbcccccc....')를 입력해야 하는 경우가 생기면 매우 큰 배열을 생성해야 한다
            // 따라서 26칸으로 크기가 한정된 배열을 사용한다
            chars = new int[26];
            N = 0;
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                chars[c - 'a']++;
                N++;
            }
            perm(0, new char[N]);
            bw.flush();
        }
    }
    static void perm(int lev, char[] ans) throws IOException {
        if (lev == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(ans[i]);
            }
            bw.write(String.valueOf(sb));
            bw.newLine();
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] > 0) {
                chars[i]--;
                ans[lev] = (char) ('a' + i);
                perm(lev + 1, ans);
                chars[i]++;
            }
        }
    }
}
