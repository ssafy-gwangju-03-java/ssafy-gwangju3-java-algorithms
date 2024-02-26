package week_06_BFS.전기철;

import java.io.IOError;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_0_7576 {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] lst;
    static int m,n;
    static Queue<int[]> q;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        lst=new int[n][m];
        for (int i=0;i<n;i++){
            String[] s = sc.nextLine().split(" ");
            for (int j=0;j<m;j++){
                lst[i][j]=Integer.parseInt(s[j]);
            }
        }
        q = new LinkedList<>();
        for(int i=0; i<n;i++){
            for (int j=0;j<m;j++){
                if(lst[i][j]==1){
                    q.add(new int[]{j,i});
                }
            }
        }
        bfs();
        System.out.println(result());
        sc.close();
    }
    public static int result(){
        int ans=0;
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (lst[i][j]==0){
                    return -1;
                }
                if(lst[i][j]>ans){
                    ans=lst[i][j];
                }
            }
        }
        return ans-1;
    }
    public static void bfs(){
        while(!q.isEmpty()){
        int[] temp=q.poll();
        int x=temp[0];
        int y=temp[1];
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(0<=nx && nx<m && 0<=ny && ny<n){
                if(lst[ny][nx]==0){
                    lst[ny][nx]=lst[y][x]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
    }
}
