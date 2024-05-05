package study_week14;

import java.util.Scanner;

public class B_3_17281 {
	static int N;
	static int[][]arr;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][9];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		ans = 0;
		find(new int[9], new boolean[9],0);
		System.out.println(ans);
	}
	
	static void cal(int[]result) {
		int score = 0;
		int idx = 0;
		for(int n = 0; n < N; n++) {
			int out = 0;
			boolean[]field = new boolean[4];
			while(out<3) {
				int cmd = arr[n][result[idx++ % 9]];
				if(cmd == 0) out++;
				else if(cmd < 4) {
					field[0] = true;
					for(int i = 3; i >= 0; i--) {
						if(field[i]) {
							field[i] = false;
							if(i+cmd >= 4) score++;
							else {
								field[i+cmd] = true;
							}
						}
					}
					} else if (cmd == 4){
						field[0] = true;
						for(int i = 0; i < 4; i++) {
							if(field[i]) {
								field[i] = false;
								score++;
							}
						}
					}
				}
			}
				ans = Math.max(ans, score);
		}
	
	static void find(int[]result, boolean[]visited, int depth) {
		if(depth == 8) {
			result[3] = 0;
			cal(result);
			return;
		}
		for(int i = 1; i < 9; i++) {
			if(!visited[i]) {
				visited[i]=true;
				result[depth >= 3 ? depth + 1 : depth] = i;
				find(result, visited, depth+1);
				visited[i] = false;
			}
		}
	}
	
}
