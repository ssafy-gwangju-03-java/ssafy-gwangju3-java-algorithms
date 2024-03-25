package week_08_투포인터.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(temp[i]);
        }

        // 정렬이 되어있어야 합의 크기를 비교하며 포인터를 움직일 수 있음
        Arrays.sort(arr);
        long ans = 0;

        for (int i = 0; i < N; i++) {

            // 0과 음수 또한 포함하므로 전 범위 탐색
            int l = 0;
            int r = N - 1;

            while (l < r) {

                // 자신과 다른 수만 탐색해야 함
                // 따라서 자기 자신을 만나면 그냥 지나치기
                if (l == i) {
                    l++;
                    continue;
                } else if  (r == i) {
                    r--;
                    continue;
                }

                // 합의 크기를 비교하며 포인터 움직임
                long s = arr[l] + arr[r];
                if (s == arr[i]) {
                    ans++;
                    break;
                } else if (s < arr[i]) {
                    l++;
                } else {
                    r--;
                }

            }
        }
        System.out.println(ans);
    }
}