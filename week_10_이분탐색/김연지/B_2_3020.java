package study_week10;

import java.util.Arrays;
import java.util.Scanner;

public class B_2_3020 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		int[]jong = new int[n/2];
		int[]seok = new int[n/2];
		for(int i = 0; i < n/2; i++) {
			jong[i] = sc.nextInt();
			seok[i] = sc.nextInt();
		}
		Arrays.sort(jong);
		Arrays.sort(seok);
		int min = n;
		int cnt = 0;
		for(int i = 1; i <= h; i++) {
			int con = binary(0,n/2,i,jong) + binary(0,n/2,h-i+1,seok);
			if(min == con) {
				cnt++;
			}
			if(min > con) {
				min = con;
				cnt = 1;
			}
		}
		System.out.println(min+" "+cnt);
		
		
	}
	static int binary(int left, int right,int h, int[]arr) {
		while(left<right) {
			int mid = (left + right) / 2;
			if(arr[mid] >= h) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return arr.length - right;
	}

}
