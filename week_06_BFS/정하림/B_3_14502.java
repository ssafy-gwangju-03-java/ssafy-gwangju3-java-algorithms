package java_study.w6;

import java.io.*;
import java.util.*;

public class B_3_14502 {
    static int N, M;
    static int[][] arr;
    static int[][] arr2;
    static int[][] D = {{-1,1,0,0},{0,0,-1,1}};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        f1(0);
        System.out.println(max);
    }
    public static void f1(int wall) {
        if (wall == 3) {
            f2();
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    f1(wall + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void f2() {
        Queue<int[]> q = new ArrayDeque<>();
        arr2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr2[i][j] = arr[i][j];
                if(arr2[i][j] == 2) q.add(new int[] {i,j});
            }
        }

        while(!q.isEmpty()) {
            int [] poll = q.poll();
            int r = poll[0], c = poll[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + D[0][d], nc = c + D[1][d];
                if(0<=nr && nr<N && 0<=nc && nc<M && arr2[nr][nc] == 0) {
                    arr2[nr][nc] = 2;
                    q.add(new int[] {nr,nc});
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr2[i][j] == 0) cnt++;
            }
        }
        max = Math.max(max, cnt);
    }

}
