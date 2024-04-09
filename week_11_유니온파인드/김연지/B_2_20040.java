package study_week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B_2_20040 {
	static int[]p;
//	static int[]p2;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n];
		for(int i = 0; i < n; i++) {
			p[i] = i;
		}
		
		int cnt = 0;
		for(int i= 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(findset(a)==findset(b)) {
				cnt = i;
				break;
			}
			union(a,b);

		}
		System.out.println(cnt);
		


	}
	static void union(int a, int b) {
		if(findset(a)==findset(b)) {
			return;
		}
		p[findset(b)] = p[findset(a)];
	}
	static int findset(int a) {
		if(p[a]==a) {
			return a;
		}
		return p[a] = findset(p[a]);
	}

}
