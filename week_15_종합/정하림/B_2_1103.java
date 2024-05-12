import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2_1103 {

    static int N, M;
    static int[][] board;
    static int[][] dp;
    static boolean[][] visited;
    static int ans = 0;
    static boolean flag= false;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0, 1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp =  new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i< N; i++) {
            String tmpS = br.readLine();
            for(int j=0; j<tmpS.length(); j++) {
                if(tmpS.charAt(j) =='H') {
                    board[i][j] = 0;
                }else {
                    int num = Integer.parseInt(String.valueOf(tmpS.charAt(j)));
                    board[i][j] = num;
                }
            }
        }

        visited[0][0] = true;
        move(0,0,1);

        if(flag) {
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }
    }

    static void move(int r, int c, int cnt) {
        ans = Math.max(ans, cnt);

        dp[r][c] = cnt;

        for(int i=0; i<4; i++) {
            int nx = r + (board[r][c] * dr[i]);
            int ny = c + (board[r][c] * dc[i]);

            if(nx<0 || ny<0 || nx> N -1 || ny> M -1 || board[nx][ny] == 0) {
                continue;
            }

            if(visited[nx][ny]) {
                flag = true;
                return;
            }

            if(dp[nx][ny] > cnt) continue;

            visited[nx][ny]= true;
            move(nx, ny, cnt+1);
            visited[nx][ny]= false;
        }

    }
}