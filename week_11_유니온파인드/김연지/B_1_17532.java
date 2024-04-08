package study_week11;

import java.util.Arrays;
import java.util.Scanner;

public class B_1_17532 {
	static int[]p;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		p = new int[n+1];
		for(int i = 1; i <= n; i++) {
			p[i] = i;
		}
		for(int i = 0; i < n-2; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a,b);
		}
//		System.out.println(Arrays.toString(p));
		for(int i = 1; i <= n; i++) {
			if(findset(i)==i) {
				System.out.print(i+" ");
			}
		}

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
