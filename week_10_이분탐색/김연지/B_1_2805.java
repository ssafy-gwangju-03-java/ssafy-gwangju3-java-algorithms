package study_week10;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class B_1_2805 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[]tree = new int[n];
		for(int i = 0; i < n; i++) {
			tree[i] = sc.nextInt();
		}
		Arrays.sort(tree);
		int ans = 0;
		int start = 0;
		int end = tree[n-1];
		while(start <= end) {
			int mid = (start+end)/2;
			long sum = 0;
			for(int i = n-1; i >=0; i--) {
				if(tree[i] > mid) {
					sum += (tree[i] - mid);
				}else {
					break;
				}
			}
			if(sum < m) {
				end = mid-1;
			}else {
				ans = mid;
				start = mid+1;
			}
		}
		System.out.println(ans);
	}

}
