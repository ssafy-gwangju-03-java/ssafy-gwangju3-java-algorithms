package week_06_BFS.전기철;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1_3055{
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] lst;
    static int[][] lst2;
    static int[][] lst3;
    static int r,c;
    static Queue<int[]> q;
    static ArrayList<ArrayList<Integer>> water = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();
        sc.nextLine();
        lst=new int[r][c];
        int[] escape=new int[2];
        int[] beaver=new int[2];
        for(int i=0; i<2501;i++){
            water.add(new ArrayList<>());
        }
        int h=0;
        lst2=new int[r][c];
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                lst2[i][j]=lst[i][j];
            }
        }
        lst3=new int[r][c];
        for(int i=0;i<r;i++){
            String[] s=sc.nextLine().split("");
            for(int j=0;j<c;j++){
                if(s[j].equals("D")){
                    lst2[i][j]=-1;
                    escape[0]=j;
                    escape[1]=i;
                }
                else if (s[j].equals("S")){
                    beaver[0]=j;
                    beaver[1]=i;
                }
                else if (s[j].equals("*")){
                    water.get(h).add(j);
                    water.get(h).add(i);
                    h+=1;
                }
                else if (s[j].equals("X")){
                    lst[i][j]=-1;
                    lst2[i][j]=-1;
                }
            }
        }

        beaver_run(beaver[0],beaver[1]);
        for(int i=0;i<h;i++){
            water_run(water.get(i).get(0),water.get(i).get(1));
        }
        for(int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if(lst[i][j]!=0 && lst2[i][j]==0){
                    lst3[i][j]=1;
                }
                else if(lst[i][j]!=-1 && lst2[i][j]!=-1 && lst[i][j]<lst2[i][j]){
                    lst3[i][j]=1;
                }
            }
        }

        lst3[escape[1]][escape[0]]=1;
        bfs(beaver[0],beaver[1]);
        // for (int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         System.out.print(lst[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println("========================");
        // for (int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         System.out.print(lst2[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println("----------------");
        // for (int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         System.out.print(lst3[i][j]);
        //     }
        //     System.out.println();
        // }
        int ans=lst3[escape[1]][escape[0]];
        if (ans==1){
            System.out.println("KAKTUS");
        }
        else{
            System.out.println(ans-2);
        }

        sc.close();
    }
    public static void beaver_run(int m,int n){
        q=new LinkedList<>();
        q.add(new int[]{m,n});
        lst[n][m]=1;
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int x=temp[0];
            int y=temp[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=nx && nx<c && 0<=ny && ny<r){
                    if (lst[ny][nx]==0){
                        lst[ny][nx]=lst[y][x]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            
        }
    }
    public static void water_run(int m,int n){
        q=new LinkedList<>();
        q.add(new int[]{m,n});
        lst2[n][m]=1;
        while (!q.isEmpty()){
            int[] temp=q.poll();
            int x=temp[0];
            int y=temp[1];
            for (int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=nx &&nx<c && 0<=ny &&ny<r){
                    if(lst2[ny][nx]==0 || lst2[ny][nx]>lst2[y][x]+1){
                        lst2[ny][nx]=lst2[y][x]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
    public static void bfs(int m, int n){
        q=new LinkedList<>();
        q.add(new int[]{m,n});
        lst3[n][m]=2;
        while (!q.isEmpty()){
            int[] temp=q.poll();
            int x=temp[0];
            int y=temp[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(0<=nx &&nx<c && 0<=ny &&ny<r){
                    if (lst3[ny][nx]==1){
                        lst3[ny][nx]=lst3[y][x]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
    
}