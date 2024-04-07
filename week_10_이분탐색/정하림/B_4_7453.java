package java_study.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 시간 초과.. 
public class B_4_7453 {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] AB = new int[n*n];
        int[] CD = new int[n*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[i*n+j]=arr[i][0] + arr[j][1];
                CD[i*n+j]=arr[i][2] + arr[j][3];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        int ab = 0, cd = n * n - 1;
        long ans =0, cnt_ab, cnt_cd;
        while (ab < n*n && cd >= 0) {
            if (AB[ab] + CD[cd] == 0) {
                cnt_ab = 1;
                cnt_cd = 1;
                while (ab+1 < n*n && AB[ab] == AB[ab+1]) {
                    ab++;
                    cnt_ab++;
                }
                while (cd-1 >= 0 && CD[cd] == CD[cd-1]) {
                    cd--;
                    cnt_cd++;
                }
                ans += cnt_ab * cnt_cd;
            } else if (AB[ab]+ CD[cd] > 0) cd--;
            else ab++;
        }
        System.out.println(ans);

    }
}