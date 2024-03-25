package week_08_투포인터.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_5_1450 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        long C = Integer.parseInt(temp[1]);

        if (N == 1) {
            long curr = Long.parseLong(br.readLine());
            if (curr <= C) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        } else {
            // 참고 1: https://wch18735.github.io/algorithm/Meet_in_the_Middle/
            // 참고 2: https://youtu.be/naz_9njI0I0?si=vuxmOJMK7-FqNHrK
            // MITM (Meet in the middle) 알고리즘
            // 모든 원소에 대해 부분 집합의 합을 구한다면 2^N 만큼의 시간이 발생
            // 그러나 이렇게 하면 해당 문제에서는 시간초과가 발생
            // 따라서 집합을 두개로 나눈 후 필요한 연산을 각각 수행
            String[] tempArr = br.readLine().split(" ");

            // 주어진 집합을 두개로 분리
            ArrayList<Long> arr1 = new ArrayList<>();
            ArrayList<Long> arr2 = new ArrayList<>();

            for (int i = 0; i < N / 2; i++) {
                arr1.add(Long.parseLong(tempArr[i]));
            }

            for (int i = N / 2; i < N; i++) {
                arr2.add(Long.parseLong(tempArr[i]));
            }

            // 두 집합의 각각의 원소들에 대해 부분집합의 합을 생성
            long[] arr1SubsetSum = subsetSum(arr1);
            long[] arr2SubsetSum = subsetSum(arr2);

            // 두 배열 중 하나를 선택해 이분탐색을 실시
            // 이 때 이분 탐색을 할 배열은 정렬되어 있어야 한다
            // 여기서는 전체 배열의 크기가 홀수일 경우 arr2의 크기가 1만큼 더 크기 때문에
            // 더 짧은 배열인 arr1을 선택해 정렬 (정렬에 소요되는 시간 줄이기)
            Arrays.sort(arr1SubsetSum);

            int ans = 0;
            for (int i = 0; i < arr2SubsetSum.length; i++) {
                // arr2의 원소를 하나씩 뽑아 pivot으로 삼기
                // arr1의 원소 중 현재 뽑힌 arr2의 원소와의 합이 C보다 작거나 같은 숫자 중 최댓값을 구한다
                long curr = arr2SubsetSum[i];

                // 만약 이미 arr2의 원소(curr, 선택된 원소들의 합)가 C를 초과한다면 탐색할 필요 없다
                // (C - curr)보다 작거나 같은 값 중 최댓값 찾기
                if (curr <= C) {
                    long target = C - curr;
                    int l = 0;
                    int r = arr1SubsetSum.length - 1;
                    int m = 0;
                    boolean found = false;
                    while (l <= r) {
                        m = (l + r) / 2;
                        // 작거나 같은 값 중에
                        if (arr1SubsetSum[m] <= target) {
                            l = m + 1;
                        } else {
                            r = m - 1;
                        }
                    }
                    // 최댓값
                    ans += (r + 1);

                    // 이분탐색 때문에 2시간 이상 소요
                    // 이분탐색은 언젠가 꼭 각잡고 공부하기 ...
                }
            }

            System.out.println(ans);
        }

    }

    static long[] subsetSum(ArrayList<Long> arr) {
        int arrLength = arr.size();

        long[] subset = new long[1 << (arrLength)];

        for (int i = 0; i < (1 << (arrLength)); i++) {
            long currSubsetSum = 0;
            for (int j = 0; j < arrLength; j++) {
                if ((i & (1 << j)) != 0) {
                    currSubsetSum += arr.get(j);
                }
            }
            subset[i] = currSubsetSum;
        }

        return subset;
    }
}

