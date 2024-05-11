package study_week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_1062 {
	static int n,k;
	static int max;
	static boolean[]visited;
	static String[] word;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		word = new String[n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			s = s.replace("anta", "");
			s = s.replace("tica", "");
			word[i] = s;
		}
		if(k<5) {
			System.out.println(0);
		}else if(k==26){
			System.out.println(n);
		}
		visited = new boolean[26];
		visited['a'-'a'] = true;
		visited['c'-'a'] = true;
		visited['i'-'a'] = true;
		visited['n'-'a'] = true;
		visited['t'-'a'] = true;
		find(0,0);
		System.out.println(max);
	}
	static void find(int alp, int len) {
		if(len == k-5) {
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				boolean r = true;
				for(int j = 0; j < word[i].length();j++) {
					if(!visited[word[i].charAt(j)-'a']) {
						r = false;
						break;
					}
				}
				if(r) cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		for(int i = alp; i < 26; i++) {
			if(visited[i]==false) {
				visited[i]=true;
				find(i,len+1);
				visited[i]=false;
			}
		}
	}

}
