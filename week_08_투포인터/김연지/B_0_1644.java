package study_week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_0_1644 {
	static boolean prime[] = new boolean[4000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		prime[0] = prime[1] = true;
		for(int i = 2; i*i<= n; i++) {
			if(!prime[i]) {
				for(int j = i*i; j <= n; j+=i)prime[j] = true;
			}
		}
	
		List<Integer>prime_lst = new ArrayList<>();
		for(int i = 2; i <= n; i++) {
			if(prime[i]==false) {
				prime_lst.add(i);
			}
		}
		int ans = 0;
		for(int i = 0; i < prime_lst.size();i++) {
			int total = 0;
			for(int j = i; j < prime_lst.size();j++) {
				total += prime_lst.get(j);
				if(total == n) {
					ans ++;
				}else if (total > n) {
					break;
				}
			}
		}
		System.out.println(ans);
		
	}


}
