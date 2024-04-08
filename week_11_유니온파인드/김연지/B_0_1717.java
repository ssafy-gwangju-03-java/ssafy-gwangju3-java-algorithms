package study_week11;

import java.util.Scanner;

public class B_0_1717 {
	static int[]p;

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		p = new int[n+1];
		for(int i = 0; i <=n;i++) {
			p[i] = i;
		}
		for(int i = 0; i < m; i++) {
			int op = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(op==0) {
				makeset(a,b);
			}
			if(op==1) {
//				for(int j = 0; j <=n;j++) {
//					findset(j);
//				}
				if(findset(a)==findset(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
		
	}
	
	static void makeset(int a, int b) {
		if (findset(a) == findset(b)) {
			return;
		}
		p[findset(b)] = p[findset(a)];
	}
	
	static int findset(int a) {
		if(p[a] == a) {
			return a;
		}
		return p[a]= findset(p[a]);
	}

}
