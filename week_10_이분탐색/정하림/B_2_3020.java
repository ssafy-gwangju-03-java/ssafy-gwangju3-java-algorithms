package java_study.w10;

import java.util.*;

public class B_2_3020 {

    static int N, H;
    static int[] bottom, top;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();

        int[] bottom = new int[N/2];
        int[] top = new int[N/2];
        for (int i = 0; i < N/2; i++) {
            bottom[i] = sc.nextInt();
//            top[i] = (H - sc.nextInt());
            top[i] = sc.nextInt();
        }
        Arrays.sort(bottom);
        Arrays.sort(top);
        int cnt = N;
        int cnt_cnt = 0;
        for (int i = 1; i <= H; i++) {
            int l_b = 0, h_b = N / 2, l_t = 0, h_t = N / 2;
            while (l_b < h_b) {
                int m = (l_b + h_b) / 2;
                if (bottom[m] >= i) h_b = m;
                else l_b = m + 1;
            }
            while (l_t < h_t) {
                int m = (l_t + h_t) / 2;
                if (top[m] > H-i) h_t = m;
                else l_t = m+1;
            }

            if (N - h_b - h_t < cnt) {
                cnt = N - h_b - h_t;
                cnt_cnt = 1;
            } else if (N - h_b - h_t == cnt) cnt_cnt++;

//            System.out.println(cnt);
        }

        System.out.print(cnt);
        System.out.print(" ");
        System.out.print(cnt_cnt);

    }
}
