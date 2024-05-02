import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1_2573{

    static int[]dx={-1,1,0,0};
    static int[]dy={0,0,-1,1};
    static int n,m;
    static int[][] vis;
    static int[][] arr;
    public static void main(String[] args) { 
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();
        int[][] lst=new int[n][m];
        for(int i=0;i<n;i++){
            String[] s = sc.nextLine().split(" ");
            for(int j=0;j<m;j++){
                lst[i][j]=Integer.parseInt(s[j]);
            }
        }
        int ans=0;
        int chk=0; // 빙산 2개이상 생성 확인 변수
        while (true) {
            int bing=0;
            arr=new int[n][m];
            vis=new int[n][m];
            for(int i=0;i<n;i++){ // 배열 복사
                for(int j=0;j<m;j++){
                    arr[i][j]=lst[i][j];
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if (arr[i][j]!=0) { // 얼음 만남
                        for(int k=0;k<4;k++){
                            int nx=j+dx[k];
                            int ny=i+dy[k];
                            if (0<=nx && nx<m && 0<=ny && ny<n) {
                                if(lst[ny][nx]==0)
                                {
                                    arr[i][j]-=1; // 1층 깎음
                                    if (arr[i][j]==0) { // 0이되면 더이상 깎으면 안되므로 break
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if (arr[i][j]!=0 && vis[i][j]==0) { // 얼음 있는데 방문x
                        bfs(j,i);
                        bing+=1;
                    }
                }
            }

            ans+=1;
            for(int i=0;i<n;i++){ // 배열 복사 (1번 진행)
                for(int j=0;j<m;j++){
                    lst[i][j]=arr[i][j];
                }
            }
            if (bing==0) { // 남은 빙산이 없음 -> break
                break;
            }
            if (bing>=2) { // 빙산이 2개 이상 생성 -> chk=1 하고 break
                chk=1;
                break;
            }
        }

        if (chk==1) {
            System.out.println(ans);
        }
        else{
            System.out.println(0);
        }
    }
    static void bfs(int r,int c){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c});
        while (!q.isEmpty()) {
            int[] temp=q.poll();
            int x=temp[0];
            int y=temp[1];
            for (int i = 0; i < 4; i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                if (0<=nx && nx<m && 0<=ny && ny<n) {
                    if (vis[ny][nx]==0 && arr[ny][nx]!=0) { // 얼음은 있는데 방문안함
                        vis[ny][nx]=1; // 방문처리
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}