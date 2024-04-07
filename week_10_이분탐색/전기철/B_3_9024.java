import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3_9024 {
    public static void main(String[] args) throws IOException{
        // System.setIn(new FileInputStream("ssafy-gwangju3-java-algorithms\\week_10_이분탐색\\전기철\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            int[] lst = new int[n];
            
            for (int i = 0; i < n; i++) {
                lst[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(lst);


            int start = 0;
            int end = n - 1;
            int cnt = 0;
            int mx = 5 * (int) (Math.pow(10, 8)) + 1;
            while (start < end) {
                int sm = lst[start] + lst[end];
                if (sm > k) {
                    if (Math.abs(sm - k) < mx) {
                        mx = Math.abs(sm - k);
                        cnt = 1;
                    } else if (Math.abs(sm - k) == mx) {
                        cnt += 1;
                    }
                    end -= 1;
                } else if (sm < k) {
                    if (Math.abs(sm - k) < mx) {
                        mx = Math.abs(sm - k);
                        cnt = 1;
                    } else if (Math.abs(sm - k) == mx) {
                        cnt += 1;
                    }
                    start += 1;
                } else {
                    if (Math.abs(sm - k) < mx) {
                        mx = Math.abs(sm - k);
                        cnt = 1;
                    } else {
                        cnt += 1;
                    }
                    start += 1;
                }
            }
            System.out.println(cnt);
            
        }
        br.close();
    }
}
