package week_10_이분탐색.김가람;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class B_3_9024 {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] temp1 = br.readLine().split(" ");
            int N = Integer.parseInt(temp1[0]);
            K = Integer.parseInt(temp1[1]);

            String[] temp2 = br.readLine().split(" ");
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(temp2[j]);
            }

            Arrays.sort(arr);

            int ansDiff = Integer.MAX_VALUE;
            int ansCnt = 0;

            for (int j = 0; j < N; j++) {
                int curr = arr[j];      // j번째 원소를 순차적으로 골라
                int l = j + 1;          // j+1부터 N-1, 즉 현재 선택된 원소 다음부터 배열 끝까지 탐색
                int r = N - 1;
                int m = 0;

                // 1. 만약 내가 찾는 target이 현재 배열에 존재하지 않는다고 가정했을 떄
                // target과 가장 가까운 작은 수를 먼저 탐색한 경우: l = m + 1이 되어 다음 다음 원소(target과 가장 가까운 큰 수)를 탐색
                // target과 가장 가까운 큰 수를 먼저 탐색한 경우: r = m - 1이 되어 그 전 전 원소(target과 가장 가까운 작은 수)를 탐색
                // 2. 조건: l <= r인 경우
                // l과 r이 겹치는 맨 마지막 케이스도 경우의 수에 넣어줘야 함

                while (l <= r) {
                    m = (l + r) / 2;
                    int currSum = curr + arr[m];
                    if (currSum > K) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                    // 탐색 시마다 갱신
                    int currDiff = Math.abs(currSum - K);

                    if (currDiff < ansDiff) {
                        ansDiff = currDiff;
                        ansCnt = 1;
                    } else if (currDiff == ansDiff) {
                        ansCnt++;
                    }
                }
            }

            System.out.println(ansCnt);
        }
    }
}
