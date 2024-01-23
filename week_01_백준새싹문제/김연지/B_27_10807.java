package baekjoon;

import java.util.Scanner;

public class B_27_10807 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int [n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i]==v) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
