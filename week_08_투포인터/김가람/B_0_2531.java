package week_08_투포인터.김가람;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_0_2531 {
    static int N;
    static int ans;
    static int furthest;
    static int[] visited;
    static ArrayList<int[]>[] adjl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp1 = br.readLine().split(" ");
        int N = Integer.parseInt(temp1[0]);
        int d = Integer.parseInt(temp1[1]);
        int k = Integer.parseInt(temp1[2]);
        int c = Integer.parseInt(temp1[3]);
        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            int temp2 = Integer.parseInt(br.readLine());
            belt[i] = temp2;
        }
        int ans = Integer.MIN_VALUE;
        int i = 0;
        while (i < N) {
            HashSet<Integer> menus = new HashSet<>();
            for (int j = 0; j < k; j++) {
                int idx = i + j;
                if (idx >= N) idx -= N;
                menus.add(belt[idx]);
            }
            menus.add(c);
            ans = Math.max(ans, menus.size());
            i++;
        }
        System.out.println(ans);
    }
}

