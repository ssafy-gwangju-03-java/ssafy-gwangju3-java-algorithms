package java_study.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_2_15686 {
    static int N, M;
    static int[][] city;
    static List<int[]> H_rc = new ArrayList<>();
    static List<int[]> C_rc = new ArrayList<>();
    static int min_total = 50*2*M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) H_rc.add(new int[]{i,j});
                else if (city[i][j] == 2) C_rc.add(new int[]{i, j});
            }
        }
        combi(0,0,new ArrayList<>());
        System.out.println(min_total);
    }
    public static void combi(int n, int r, List<Integer> remove_list) {
        if (r == M) {
            min_total = Math.min(min_total, calc(remove_list));
            return;
        }
        if (n == C_rc.size())return;

        List<Integer> tmp = new ArrayList<>(remove_list);
        tmp.add(n);
        combi(n + 1, r + 1, tmp);
        combi(n+1, r, remove_list);
    }

    public static int calc(List<Integer> remove_list) {
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < C_rc.size(); i++) {
            if (!remove_list.contains(i)) tmp.add(C_rc.get(i));
        }

        int total = 0;
        for (int i = 0; i < H_rc.size(); i++) {
            int d = 50 * 2;
            for (int j = 0; j < tmp.size(); j++) {
                int[] H = new int[2];
                H = H_rc.get(i);
                int[] C = new int[2];
                C = tmp.get(i);
                int Hr = H[0], Hc = H[1], Cr = C[0], Cc = C[1];
//                d = Math.min(d, (Math.abs(Hr - Cr) + Math.abs(Hc - Cc)));
                System.out.println(Hr);
                System.out.println(Hc);
                System.out.println(Cr);
                System.out.println(Cc);
            }
            total += d;

        }
        return total;
    }
}
