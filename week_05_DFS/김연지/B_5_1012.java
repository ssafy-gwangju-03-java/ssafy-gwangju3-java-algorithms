package study_week5;

import java.util.ArrayList;
import java.util.Scanner;

import static study_week5.B_4_11724.dfs;

public class B_5_1012 {
    static int [][] arr;
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static int n,m;

//    static ArrayList<ArrayList<Integer>>arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc < t; tc++){
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            arr = new int[n][m];

            for (int j = 0; j < k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[b][a] = 1;
            }

            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j]==1){
                        dfs(i,j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
    public static void dfs(int r, int c){
        arr[r][c] = 0;
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && arr[nr][nc]==1){
                dfs(nr,nc);
            }
        }
    }
}
