package week_08_투포인터.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1_2467 {
    static int N;
    static long minSum;
    static long[] samples;
    static long[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        samples = new long[N];      // 용액 담을 배열
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            samples[i] = Long.parseLong(temp[i]);
        }

        minSum = Integer.MAX_VALUE;
        ans = new long[2];

        // 양 끝에서 탐색을 시작할 2개의 포인터 i, j
        int i = 0;
        int j = N - 1;

        // i, j 번째의 부호와 절댓값에 따라 경우의 수를 나눈다
        while (i < j) {

            // 양 끝쪽의 원소가 둘 다 음수인 경우
            // 둘의 합으로 최솟값을 갱신해 준 후 왼쪽 포인터를 증가시킨다
            if (samples[i] < 0 && samples[j] < 0) {
                exchangeMinimum(i, j);
                i++;
            }
            // 양 끝쪽의 원소가 둘 다 양수인 경우 경우
            // 둘의 합으로 절댓값을 갱신해 준 후 오른쪽 포인터를 증가시킨다
            else if (samples[i] >= 0 && samples[j] >= 0) {
                exchangeMinimum(i, j);
                j--;
            }
            // 왼쪽 끝 원소가 음수 && 오른쪽 끝 원소가 양수
            else if (samples[i] < 0 && samples[j] >= 0) {
                exchangeMinimum(i, j);

                // 만약 현재 원소들의 합이 0이라면 최솟값 도달하여 break
                if (minSum == 0) break;

                // 왼쪽 원소(음수)의 절댓값이 오른쪽 원소(양수)보다 크면 왼쪽 포인터 증가시킨 후 더 작은 값 모색
                if (-samples[i] < samples[j]) {
                    j--;
                }
                // 오른쪽 원소(양수)의 절댓값이 왼쪽 원소(음수)보다 크면 오른쪽 포인터 감소시킨 후 더 작은 값 모색
                else if (-samples[i] > samples[j]) {
                    i++;
                }
            }
        }
        System.out.printf("%d %d", ans[0], ans[1]);
    }

    // 두 원소의 합으로 최솟값 교체해 줄 함수
    static void exchangeMinimum(int i, int j) {
        long currSum = Math.abs(samples[i] + samples[j]);
        if (currSum < minSum) {
            minSum = currSum;
            ans[0] = samples[i];
            ans[1] = samples[j];
        }
    }
}

}
