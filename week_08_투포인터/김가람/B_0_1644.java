package week_08_투포인터.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_0_1644 {
    static int N;
    static boolean[] sieve;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N < 2) {
            System.out.println(0);
        } else {
            // 체 만들기
            sieve = new boolean[N+1];
            for (int i = 2; i <= N; i++) {
                sieve[i] = true;
            }
            int sqrtN = (int) Math.sqrt(N);
            for (int i = 2; i <= sqrtN; i++) {
                if (sieve[i]) {
                    for (int j = i * i; j <= N; j += i) {
                        sieve[j] = false;
                    }
                }
            }

            int l = 2;      // left pointer
            int r = l;      // right pointer
            int s = l;      // sum
            int ans = 0;    // 경우의 수 카운터

            while (true) {
                if (l > r) break;

                if (s == N) {
                    ans++;
                    if (l == N) break;
                    r = movePointer(r);
                    if (r == -1) break;     // 다음 소수 못 찾고 N 초과하면 break
                    s += r;
                } else if (s < N) {
                    r = movePointer(r);
                    if (r == -1) break;     // 다음 소수 못 찾고 N 초과하면 break
                    s += r;
                } else {
                    s -= l;
                    l = movePointer(l);
                    if (l == -1) break;     // 다음 소수 못 찾고 N 초과하면 break
                }
            }

            System.out.println(ans);
        }
    }

    // 다음 소수를 구해주는 함수
    // N 넘어가면 -1 반환
    static int movePointer(int i) {
        i++;
        while (!sieve[i]) {
            i++;
            if (i > N) {
                return -1;
            }
        }
        return i;
    }

}

