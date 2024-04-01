package study_week10;

import java.util.Arrays;
import java.util.Scanner;

public class B_0_2110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[]house = new int[n];
		for(int i = 0; i < n; i++) {
			house[i] = sc.nextInt();
		}
		Arrays.sort(house);
		int start = 1;
		int end = house[n-1] - house[0]+1;
		while(start < end) {
			int mid = (start + end) / 2;
			int res = 1;
			int last = house[0];
			for(int i = 1; i < house.length; i++) {
				int t = house[i];
				if(t - last >= mid) {
					res++;
					last = t;
				}
			}
			if(res >= c) {
				start = mid+1;
			} else {
				end = mid;
			}
		}
		System.out.println(end-1);
	}
}
