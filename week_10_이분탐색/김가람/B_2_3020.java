package week_10_이분탐색.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2_3020 {
    static int ans;
    static int ansCnt;
    static int[] ground;
    static int[] ceiling;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int H = Integer.parseInt(temp[1]);
        ground = new int[N/2];
        ceiling = new int[N/2];
        for (int i = 0; i < N/2; i++) {
            ground[i] = Integer.parseInt(br.readLine());
            ceiling[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ground);
        Arrays.sort(ceiling);

        ans = N;
        ansCnt = 0;

        for (int i = 1; i <= H; i++) {
            int curr = lowerBound(0, N/2, i, ground) + lowerBound(0, N/2, H-i+1, ceiling);
            if (curr < ans) {
                ans = curr;
                ansCnt = 1;
            } else if (curr == ans) ansCnt++;
        }

        System.out.printf("%d %d", ans, ansCnt);
    }

    static int lowerBound(int s, int e, int height, int[] arr) {
        int l = s;
        int r = e;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= height) {
                r = m;
            } else l = m + 1;
        }

        return arr.length - l;
    }
}
