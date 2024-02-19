package study_week4;

import java.util.Scanner;

public class B_4_1932 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr = new int [n+1][n+1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i = n-1; i >=0; i--) {
			for(int j = 0; j <n;j++) {
				if(arr[i+1][j]>arr[i+1][j+1]) {
					arr[i][j] += arr[i+1][j];
				}else{
					arr[i][j] += arr[i+1][j+1];
				}
			}
		}
		System.out.println(arr[0][0]);
		
	}
	

}
