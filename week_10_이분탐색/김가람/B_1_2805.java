package week_10_이분탐색.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1_2805 {
    static int N;
    static int M;
    static long[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        trees = new long[N];
        String[] temp2 = br.readLine().split(" ");
        long l = 0;
        long r = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(temp2[i]);
            r = Math.max(r, trees[i]);
        }
        long m;
        while (l <= r) {
            m = (l + r) / 2;
            if (cut(m) < M) r = m - 1;
            else l = m + 1;
        }
        System.out.println(r);
    }

    static long cut(long cutter) {
        long cutTree = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > cutter) cutTree += trees[i] - cutter;
        }
        return cutTree;
    }
}
