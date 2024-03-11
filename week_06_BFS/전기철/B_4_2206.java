package week_06_BFS.전기철;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_4_2206 {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] lst;
    static int[][] lst2;
    static int[][] lst3;
    static int n,m;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();
        lst=new int[n][m];
        lst2= new int[n][m];
        lst3= new int[n][m];
        for(int i=0;i<n;i++){
            String[] s = sc.nextLine().split("");
            for(int j=0;j<m;j++){
                lst[i][j]=Integer.parseInt(s[j]);
                lst2[i][j]=Integer.parseInt(s[j]);
                lst3[i][j]=Integer.parseInt(s[j]);
            }

        }
        int ans=n*m+2;
        bfs(0,0,lst2);
        bfs(m-1,n-1,lst3);
        if(lst3[0][0]!=0){
            ans=lst3[0][0]-1;
        }
        else{
            ans=n*m+2;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(lst[i][j]==1){
                    ans=Math.min(ans,check(j,i));
                }
            }
        }
        if(ans==n*m+2){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
        sc.close();
    }
    public static void bfs(int c ,int r, int[][] map){
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{c,r});
        map[r][c]=2;
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int x = temp[0];
            int y= temp[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=nx&&nx<m &&0<=ny &&ny<n){
                    if(map[ny][nx]==0){
                        map[ny][nx]=map[y][x]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
    public static int check(int x,int y){
        int chk1=n*m+2;
        int chk2=n*m+2;
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(0<=nx&&nx<m &&0<=ny &&ny<n &&lst2[ny][nx]!=0 &&lst2[ny][nx]!=1){
                chk1=Math.min(chk1,lst2[ny][nx]);
            }
        }
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(0<=nx&&nx<m &&0<=ny &&ny<n &&lst3[ny][nx]!=0 &&lst3[ny][nx]!=1){
                chk2=Math.min(chk2,lst3[ny][nx]);
            }
        }

        if (chk1!=n*m+2 &&chk2!=n*m+2){
            return chk1+chk2-1;
        }
        return n*m+2;
    }
}
