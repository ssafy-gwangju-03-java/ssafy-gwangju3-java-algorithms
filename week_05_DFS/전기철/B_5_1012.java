import java.util.Scanner;

public class B_5_1012 {
    static int[][] lst;
    static int[]dx = {-1,1,0,0};
    static int[]dy = {0,0,-1,1};
    static int m,n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tc=0;tc<t;tc++){
            int cnt=0;
            m=sc.nextInt();
            n=sc.nextInt();
            int k= sc.nextInt();
            lst=new int[n][m];
            for(int i=0;i<k;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                lst[b][a]=1;
            }
            // for(int i=0;i<n;i++){
            //     for (int j=0;j<m;j++){
            //         System.out.print(lst[i][j]);
            //     }
            //     System.out.println();
            // }
            for(int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (lst[i][j]==1){
                        dfs(j,i);
                        cnt+=1;
                    }
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }
    public static void dfs(int x,int y){
        lst[y][x]=0;
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(0<=nx && 0<=ny && nx<m &&ny<n){
                if(lst[ny][nx]==1){
                    dfs(nx,ny);
                }
            }
        }
    }
}
