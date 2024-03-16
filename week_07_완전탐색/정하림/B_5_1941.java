package java_study.w7;


import java.io.*;
import java.util.*;

public class B_5_1941 {
    static char[][] map;
    static int answer = 0;
    static boolean[] visited;
    static int[] selected = new int[7];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[5][5];

        for(int r = 0 ; r < 5 ; r++) {
            map[r] = br.readLine().toCharArray();
        }

        backTracking(0, 0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    static void backTracking(int depth, int numY, int start) { //25C7 (map중에 무작위 7칸)
        if(numY >= 4) return;

        if(depth == 7) {
            visited = new boolean[7];
            BFS();
            return;
        }

        //백트래킹은 0 ~ 24지만, 배열은 5*5 2차원이다.
        //즉, 5로 나눈 몫을 행으로, 나머지를 열로 설정해주면 5*5 행렬을 표현 가능하다.
        for(int i = start ; i < 25 ; i++) {
            selected[depth] = i;
            if(map[i/5][i%5] == 'Y') {
                backTracking(depth+1, numY+1, i+1);
            }
            else {
                backTracking(depth+1, numY, i+1);
            }

        }
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {selected[0]/5, selected[0]%5}); //가장 처음 slected[0] 넣기
        visited[0] = true;
        int conn = 1; //몇개 연결되어있는지

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0 ; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int ni = nr*5 + nc; //0~24의 다음 index

                if(!isValid(nr, nc)) continue;

                //내가 뽑은 7개의 index가, 서로 연결되어있는지를 검사해주는 로직.
                //selected[0]과 selected[6], 이런식으로 떨어진 숫자끼리 선택되어 연결되어 있더라도
                //아래의 for문을 통해 다 만날 수 있다.
                for(int j = 0 ; j < 7 ; j++) {
                    if(!visited[j] && selected[j] == ni) {
                        q.add(new int[] {nr, nc});
                        visited[j] = true;
                        conn++;
                    }
                }


            }
        }

        if(conn == 7) answer++;

    }

    static boolean isValid(int r, int c) { //r, c index가 유효한지
        if(r >= 0 && r < 5 && c >= 0 && c < 5) return true;
        return false;
    }



}