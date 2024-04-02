package java_study.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_0_2343 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int min = 0, max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i]; // 블루레이 크기 최대 = 총합
            min = Math.max(min, arr[i]); // 블루레이 크기 최소 = arr 최대
        }
        int cnt, sum;
        while (min <= max) {
            int mid = (min + max) / 2;

            cnt = 1;
            sum = 0;
            for (int i = 0; i < N; i++) {
                // arr[i] 추가 불가능
                if (sum + arr[i] > mid) {
                    sum = 0; // 초기화
                    cnt++;   // 다음 블루레이
                }
                // 추가 가능
                sum += arr[i];
            }
            // 블루레이 개수가 많으면 크기 늘리기
            if(cnt > M) min = mid + 1;
            else max = mid - 1;
        }

        System.out.println(min);
    }
}
