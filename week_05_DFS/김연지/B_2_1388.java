package study_week5;

import java.util.Scanner;

public class B_2_1388_바닥장식 {
//    static int n,m;
    static String [][] floor;
    static int [] c_dr = {0,0};
    static int [] c_dc = {-1,1};
    static int [] r_dr = {-1,1};
    static int [] r_dc = {0,0};
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        n = Integer.parseInt(temp.split(" ")[0]);
        m = Integer.parseInt(temp.split(" ")[1]);
        floor = new String[n][m];
        for(int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                floor[i][j] = s[j];
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(floor[i][j].equals("-")){
                    dfs_col(i,j);
                    cnt++;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(floor[i][j].equals("|")){
                    dfs_row(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
    public static void dfs_col (int r, int c){
        floor[r][c] = ".";
        for (int i = 0; i < 2; i++){
            int nr = r + c_dr[i];
            int nc = c + c_dc[i];
            if(nr>=0 && nr < n && nc>=0 && nc<m && floor[nr][nc].equals("-")){
                dfs_col(nr,nc);
            }
        }
    }
    public static void dfs_row (int r, int c){
        floor[r][c] = ".";
        for (int i = 0; i < 2; i++){
            int nr = r + r_dr[i];
            int nc = c + r_dc[i];
            if(nr>=0 && nr < n && nc>=0 && nc<m && floor[nr][nc].equals("|")){
                dfs_row(nr,nc);
            }
        }
    }
}
