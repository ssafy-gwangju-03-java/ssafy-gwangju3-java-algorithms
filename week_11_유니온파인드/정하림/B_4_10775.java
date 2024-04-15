package java_study.w11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_4_10775 {
    static int G,P;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        p = new int[G + 1];
        for(int i = 1; i <= G; i++) p[i] = i;

        int cnt = 0;
        for(int i = 0; i < P; i++) {
            int gi = Integer.parseInt(br.readLine());
            if (findSet(gi) == 0) break;
            cnt++;
            unionSet(findSet(gi)-1, findSet(gi));
        }
        System.out.println(cnt);
    }

    public static void unionSet(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);
        if (pa == pb) return;
        p[pb] = pa;
    }

    public static int findSet(int a) {
        if(a == p[a]) return a;
        return p[a] = findSet(p[a]);
    }
}