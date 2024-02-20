import java.util.Scanner;

public class B_1_4963 {
    static int[][] lst;
    static int[] dx={-1,1,0,0,-1,-1,1,1};
    static int[] dy={0,0,-1,1,-1,1,-1,1};
    static int m,n;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(true){
            m= sc.nextInt();
            n= sc.nextInt();
            int cnt=0;
            if(m==0 && n==0){
                break;
            }
            lst=new int[n][m];
            for(int i=0;i<n;i++){
                for (int j=0; j<m;j++){
                    lst[i][j]=sc.nextInt();
                }
            }
            
            for (int i=0; i<n;i++){
                for(int j=0; j<m;j++){
                    if(lst[i][j]==1){
                        dfs(j,i);
                        cnt+=1;
                    }
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }


    public static void dfs(int x, int y){
        lst[y][x]=0;
        for(int i=0;i<8;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(0<=nx && 0<=ny && nx<m && ny<n){

                if(lst[ny][nx]==1){
                    dfs(nx,ny);
                }

            }
        }
    }
}
