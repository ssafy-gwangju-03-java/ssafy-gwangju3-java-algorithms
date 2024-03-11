package week_06_BFS.전기철;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B_3_14502{
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][]lst;
    static int m,n;

public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    n=sc.nextInt();
    m=sc.nextInt();
    sc.nextLine();
    lst=new int[n][m];
    List<int[]> virus = new ArrayList<>();
    List<int[]> empty = new ArrayList<>();
    for(int i=0;i<n;i++){
        String[] s = sc.nextLine().split(" ");
        for(int j=0;j<m;j++){
            lst[i][j]=Integer.parseInt(s[j]);
        }
    }
    for (int i=0;i<n;i++){
        for(int j=0; j<m;j++){
            if(lst[i][j]==2){
                virus.add(new int[]{j,i});
            }
            else if (lst[i][j]==0){
                empty.add(new int[]{j,i});
            }
        }
    }
    int cnt=empty.size()+virus.size();
    int ans=0;
    for(int i=0;i<empty.size()-2;i++){
        for(int j=0;j<empty.size()-1;j++){
            for(int k=0;k<empty.size();k++){
                int[][] temp=new int[n][m];
                for(int x=0;x<n;x++){
                    System.arraycopy(lst[x],0,temp[x],0,m);
                }
                temp[empty.get(i)[1]][empty.get(i)[0]]=1;
                temp[empty.get(j)[1]][empty.get(j)[0]]=1;
                temp[empty.get(k)[1]][empty.get(k)[0]]=1;
                ans=Math.max(ans,cnt-3-bfs(temp,virus));
            }
        }
    }
    System.out.println(ans);
    sc.close();
}
public static int bfs(int[][] lst,List<int[]> virus){
    int[][] vis =new int[n][m];
    int chk=0;
    Queue<int[]> q = new LinkedList<>(virus);
    while (!q.isEmpty()){
        int[] temp=q.poll();
        int x=temp[0];
        int y=temp[1];
        if (vis[y][x]==0){
            vis[y][x]=2;
            chk+=1;
        }
        for(int i=0; i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(0<=nx&&nx<m&&0<=ny&&ny<n){
                if(lst[ny][nx]==0&&vis[ny][nx]==0){
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }


    return chk;
}
}