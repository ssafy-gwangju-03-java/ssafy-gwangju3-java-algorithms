import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_3_2667 {
    static int n;
    static int[][] lst;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int size;
    static ArrayList<Integer> ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= Integer.parseInt(sc.nextLine());
        lst=new int[n][n];
        for(int i=0; i<n;i++){
            String[] s = sc.nextLine().split("");
            for(int j=0;j<n;j++){
                lst[i][j]=Integer.parseInt(s[j]);
            }
        }
        int cnt=0;
        size=0;
        ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(lst[i][j]==1){
                    dfs(j,i,size);
                    cnt+=1;
                    ans.add(size);
                    size=0;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(ans);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
        sc.close();
    }
    public static void dfs(int x,int y,int z){
        lst[y][x]=0;
        size+=1;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 &&nx<n &&ny>=0 &&ny<n){
                if(lst[ny][nx]==1){
                    dfs(nx,ny,size);
                }
            }
        }
    }
}
