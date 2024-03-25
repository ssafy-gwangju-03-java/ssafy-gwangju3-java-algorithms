package week_08_투포인터.김가람;

import java.io.*;
public class B_4_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int S = Integer.parseInt(temp[1]);
        int[] arr = new int[N];
        String[] temp2 = br.readLine().split(" ");

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(temp2[i]);
        }

        int i = 0;
        int j = 0;
        int s = arr[i];

        boolean didFound = false;

        /*
         1. 투포인터 시간복잡도 : O(N)
         매 루프마다 항상 두 포인터 중 하나는 1씩 증가하고 각 포인터가 n번 누적 증가하면 탐색 종료
         == 각각 배열 끝에 다다르는데 O(N), 둘을 더해도 여전히 O(N)
         이중 for문 완전탐색 == O(N^2), 인덱스 두개를 쓴다고 투포인터 알고리즘이 아님을 주의

         2. ""자연수""인 부분 배열의 합
         두 개의 포인터를 조작하여 부분합을 구할 수 있는 이유는 배열의 값이 자연수이기 때문
         자연수이기 때문에 right 포인터를 증가시키면 합이 증가하고 start를 증가하면 부분합이 감소
         따라서 음수 섞여있을 시 부적합
        */


        while (true) {
            if (s >= S) {
                didFound = true;
                minLength = Math.min(minLength, j - i + 1);
                if (minLength == 1) break;
                s -= arr[i];
                i++;
            } else {
                j++;
                if (j == N) break;
                s += arr[j];
            }
        }

        System.out.println(didFound ? minLength : 0);
    }
}