package java_study.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3_9024 {
    // 이분 탐색은 아니고 투포인터...?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int key = Integer.parseInt(st.nextToken());

            int[] arr = new int[n]; //서로 다른 n개의 정수 arr
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int l = 0, r = n-1, cnt = 0;
            long  result = Math.abs(arr[0] + arr[n-1] - key);
            while (l < r) {
                long sum = arr[l] + arr[r];

                if (result > Math.abs(sum-key)) {
                    result = Math.abs(sum-key);
                    cnt = 1;
                } else if (result == Math.abs(sum-key)) {
                    cnt++;
                }
                if (sum <= key) l++;
                else r--;
            }
            System.out.println(cnt);

        }

    }
}
