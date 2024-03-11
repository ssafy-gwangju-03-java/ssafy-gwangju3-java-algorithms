package week_07_완전탐색.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_0_1759 {
    static int L;
    static int C;
    static String[] chars;
    static int[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        L = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);
        chars = br.readLine().split(" ");
        Arrays.sort(chars);
        password(0, 0, new String[L], 0, 0);
    }

    static void password(int lev, int start, String[] ans, int vow, int cons) {
        if (lev == L) {
            if (vow >= 1 && cons >= 2) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < L; i++) {
                    sb.append(ans[i]);
                }
                System.out.println(sb);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (isVowel(chars[i])) {
                ans[lev] = chars[i];
                password(lev + 1, i + 1, ans, vow + 1, cons);
            } else {
                ans[lev] = chars[i];
                password(lev + 1, i + 1, ans, vow, cons + 1);
            }
        }
    }

    static boolean isVowel(String c) {
        if (c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u")) return true;
        return false;
    }
}
