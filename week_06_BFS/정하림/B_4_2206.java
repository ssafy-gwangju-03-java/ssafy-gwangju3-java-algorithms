package java_study.w6;
import java.io.*;
import java.util.*;
public class B_4_2206 {
    static int N, M;
    static int[][] map;
    static int[][] D = {{-1,1,0,0},{0,0,-1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] s = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        if(N ==1 && M ==1) System.out.println(1);
        else System.out.println(f());
    }

    public static int f(){
        int [][][] v = new int[2][N][M]; //....
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0,0});
        v[0][0][0] = 1;

        while(true) {
            int[] poll = q.poll();
            if(poll == null) return -1;

            int w = poll[0], r = poll[1], c = poll[2];

            for (int d = 0; d < 4; d++) {
                int nr = r + D[0][d], nc = c + D[1][d];
                if(nr>=0 && nr < N && nc >=0 && nc < M) {
                    if(w == 0) {
                        if(map[nr][nc] == 0 && v[0][nr][nc]== 0) {
                            q.add(new int[] {0,nr,nc});
                            v[0][nr][nc] = v[0][r][c]+1;
                        } else if(map[nr][nc]==1 && v[0][nr][nc]==0) {
                            if(v[1][nr][nc]==0) {
                                q.add(new int[] {1,nr,nc});
                                v[1][nr][nc] = v[0][r][c] + 1;
                            }
                        }
                    }else {
                        if(map[nr][nc]==0) {
                            if(v[1][nr][nc]==0) {
                                q.add(new int[] {1,nr,nc});
                                v[1][nr][nc] = v[1][r][c] + 1;
                            }
                        }
                    }
                    if(nr == N -1 && nc == M -1) {
                        return Math.max(v[0][nr][nc], v[1][nr][nc]);
                    }
                }
            }
        }
    }
}