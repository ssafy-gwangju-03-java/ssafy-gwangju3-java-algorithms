package java_study.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_3_6443 {
    static int N;
    static String[] eng;
    static int[] sel;
    static int R;
    static List<String> result_lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.read();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            result_lst = new ArrayList<>();
            R = s.length();
            eng = new String[R];
            sel = new int[R];
            eng = s.split("");
            anagram(0,sel, "");
        }
    }

    public  static void anagram(int cnt, int[] sel, String result) {

        if (cnt == R) {
            if (!result_lst.contains(result)) {
                result_lst.add(result);
                System.out.println(result);
            }
            return;
        }

        for (int i = 0; i < R; i++) {
            if (sel[i] == 0) {
                sel[i] = 1;
                anagram(cnt + 1, sel, result+eng[i]);
                sel[i] = 0;
            }
        }
    }
}

/*
package java_study.w7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_3_6443 {
    static int N;
    static String eng;
    static int[] sel;
    static int R;
    static List<String> result_lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.read();

        for (int i = 0; i < N; i++) {
             eng = br.readLine();
            result_lst = new ArrayList<>();
            R = eng.length();
            sel = new int[R];
            String[] tmp = eng.split("");
            Arrays.sort(tmp);
            eng = Arrays.toString(tmp);
            anagram(0,sel, "");
        }
    }

    public  static void anagram(int cnt, int[] sel, String result) {
        if (cnt == R) {
            if (!result_lst.contains(result)) {
                result_lst.add(result);
                System.out.println(result);
            }
            return;

        }

        for (int i = 0; i < R; i++) {
            if (sel[i] == 0) {
                sel[i] = 1;
                anagram(cnt + 1, sel, result+Character.toString(eng.charAt(i)));
                sel[i] = 0;
            }
        }
    }
}

 */