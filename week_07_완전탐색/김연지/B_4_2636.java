package study_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4_2636 {
	
	static int n,m;
	static int[][]map;
	static boolean[][]visited;
	static int[]dr = {-1,1,0,0};
	static int[]dc = {0,0,-1,1};
	static List<Integer>cnt_lst;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		cnt_lst = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = true;
		int time = 0;
		int first = getCount(); // 초기상태 치즈의 개수

        while (flag) {
            time++;

            bfs(0,0);

            for (int i = 0; i < n; i++)
                Arrays.fill(visited[i], false); // 다음 시간에 치즈를 녹이기 위해 visited 배열 전부 false를 넣어줌

            int count = getCount();

            if (count == 0)
                flag = false;
            else
                cnt_lst.add(count);
        }

        System.out.println(time);

        if (cnt_lst.size() > 0) // 치즈가 전부 녹는데 2시간 이상인 경우
            System.out.println(cnt_lst.get(cnt_lst.size() - 1));
        else // 1시간만에 치즈가 다 녹는 경우 혹은 치즈가 하나도 없을 때.
            System.out.println(first);
	}
	
	static void bfs(int a, int b) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a,b});
        visited[a][b] = true;

        while (!q.isEmpty()) {
        	
        	int[]temp = q.poll();
        	int r = temp[0];
        	int c = temp[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!visited[nr][nc]) {
                        if (map[nr][nc] == 1) { // 치즈의 모서리를 2로 변경
                            map[nr][nc] = 2;
                            visited[nr][nc] = true;
                        }
                        if (map[nr][nc] == 0) {
                            visited[nr][nc] = true;
                            q.add(new int[] {nr,nc});
                        }
                    }
                }
            }
        }

        removeCheese(); // 배열의 값이 2면 치즈의 모서리이므로 0으로 바꿈
    }

    static void removeCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2)
                    map[i][j] = 0;
            }
        }
    }

    static int getCount() {

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

}
