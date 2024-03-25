package java_study.w8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] seq = new int[N]; // 수열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int e = 0;
        int sum = 0;
        int cnt = 100000+1;
        for (int i = 0; i < N; i++) {
            while (sum < S && e < N) {
                sum += seq[e];
                e++;
            }
            if (sum >= S) {
                cnt = Math.min(cnt, e - i);
            }
            sum -= seq[i];
        }
        if (cnt == 100000+1) {
            System.out.println(0);
        } else {
            System.out.println(cnt);
        }
    }
}
