package week_06_BFS.전기철;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2_16236 {
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static int[][] lst;
    static int[] shark;
    static int size;
    static int eat;
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        sc.nextLine();
        lst=new int[n][n];
        shark = new int[2];
        size=2;
        eat=0;
        for(int i=0;i<n;i++){
            String []s=sc.nextLine().split(" ");
            for (int j=0;j<n;j++){
                lst[i][j]=Integer.parseInt(s[j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(lst[i][j]==9){
                    shark[0]=j;
                    shark[1]=i;
                    lst[i][j]=0;
                }
            }
        }
        int ans=0;
        while (true){
            int cnt=bfs();
            if (cnt==-1){
                break;
            }
            ans+=cnt;
        }
        System.out.println(ans);





        sc.close();
    }
    

    public static int bfs(){
        int[][] vis=new int[n][n];
        Queue<int[]> q=new LinkedList<>();
        int r = shark[0];
        int c = shark[1];
        q.add(new int[]{r,c});
        vis[c][r]=1;
        int chk_y=n;
        int chk_x=n;
        int chk_t=n*n;
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int x=temp[0];
            int y=temp[1];
            if(vis[y][x]>=chk_t){
                break;
            }
            for (int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if (0<=nx &&nx<n &&0<=ny &&ny<n &&vis[ny][nx]==0){
                    if(lst[ny][nx]==0 || lst[ny][nx]==size){
                        vis[ny][nx]=vis[y][x]+1;
                        q.add(new int[]{nx,ny});
                    }
                    else if(lst[ny][nx]<size){
                        vis[ny][nx]=vis[y][x]+1;
                        if(ny<chk_y||(ny==chk_y&&nx<chk_x)){
                            chk_x=nx;
                            chk_y=ny;
                            chk_t=vis[ny][nx];
                        }
                    }
                }
            }
        }
        if(chk_x==n){
            return -1;
        }

        lst[chk_y][chk_x]=0;
        eat+=1;
        if(eat==size){
            size+=1;
            eat=0;
        }
        shark[0]=chk_x;
        shark[1]=chk_y;
        return vis[chk_y][chk_x]-1;
    
}
}