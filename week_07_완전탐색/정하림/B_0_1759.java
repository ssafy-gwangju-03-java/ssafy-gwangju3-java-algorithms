package java_study.w7;

import java.util.*;
import java.io.*;
import java.lang.*;
public class B_0_1759 {
    static int L, C;
    static String [] ABC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ABC = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            ABC[i] = st.nextToken();
        }
        Arrays.sort(ABC);

        combi(0, 0, "");

    }
    // 조합; c개 중 l개 뽑기
    public static void combi(int c, int l, String result) {
        if (l == L) {
            if (aeiBCD(result)) {
                System.out.println(result);
            }
            return;
        }
        if (c == C) return;

        combi(c + 1, l + 1, result + ABC[c]);
        combi(c + 1, l, result);
    }

    // 모음 1개 이상, 자음 2개 이상
    public static boolean aeiBCD(String result) {
        int aei = 0;
        int BCD = 0;
        for (int i = 0; i < L; i++) {
            if ("aeiou".contains(Character.toString(result.charAt(i)))) {
                aei ++;
            }
            else BCD++;
        }

        if ((aei >= 1) && (BCD >= 2)) return true;
        else return false;
    }

}
