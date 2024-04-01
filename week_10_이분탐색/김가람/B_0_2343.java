package week_10_이분탐색.김가람;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_0_2343 {
    static int N;
    static int M;
    static int[] lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp1 = br.readLine().split(" ");
        N = Integer.parseInt(temp1[0]);
        M = Integer.parseInt(temp1[1]);

        String[] temp2 = br.readLine().split(" ");
        lectures = new int[N];
        int total = 0;
        int l = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(temp2[i]);
            l = Math.max(l, lectures[i]);
            total += lectures[i];
        }
        int r = total;
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (record(m) > M) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println(r);
    }

    public static int record(int capacity) {
        int cnt = 0;
        int s = 0;
        int i = 0;
        while (i < N) {
            if (s + lectures[i] <= capacity) {
                s += lectures[i];
                i++;
            } else {
                cnt++;
                s = 0;
            }
        }
        return cnt+1;
    }
}
