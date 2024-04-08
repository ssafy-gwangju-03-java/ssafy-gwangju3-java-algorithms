package week_10_이분탐색.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_4_7453 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // long으로 안해줘서 계속 틀림 ㅡㅡ 하 ..........
        long[] A = new long[N];
        long[] B = new long[N];
        long[] C = new long[N];
        long[] D = new long[N];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            A[i] = Long.parseLong(temp[0]);
            B[i] = Long.parseLong(temp[1]);
            C[i] = Long.parseLong(temp[2]);
            D[i] = Long.parseLong(temp[3]);
        }

        long[] arr1 = arrSum(A, B);
        long[] arr2 = arrSum(C, D);

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        long ans = 0;

        // 원래는 lowerBound만 구해줘서 같은 값일때까지 오른쪽으로 한칸씩 셌음
        // 그러나 같은 값이 무수히 많은 배열이 있어서 시간초과가 났던듯
        for (int i = 0; i < N * N; i++) {
            long curr = arr1[i];
            long lowest = lowerBound(arr2, -curr);
            long highest = upperBound(arr2, -curr);
            ans += (highest - lowest);
        }

        System.out.println(ans);
    }

    static long[] arrSum(long[] P, long[] Q) {
        long[] result = new long[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i*N + j] = (P[i] + Q[j]);
            }
        }
        return result;
    }

    static long lowerBound(long[] arr, long target) {
        int l = 0;
        int r = N * N;
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (arr[m] >= target) {
                r = m;
            } else l = m + 1;
        }
        return l;
    }

    static int upperBound(long[] arr, long target) {
        int l = 0;
        int r = N * N;
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (arr[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
