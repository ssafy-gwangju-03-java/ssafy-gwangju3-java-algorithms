package study_week10;

import java.util.Scanner;

public class B_5_1300 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long start = 1;
		long end = k;
		while(start<end) {
			long mid = (start+end)/2;
			long idx = 0;
			for(int i = 1; i <= n; i++) {
				idx += Math.min(mid/i, n);
			}
			if(idx < k) {
				start = mid+1;
			}else {
				end = mid;
			}
		}
		System.out.println(start);
	}

}
