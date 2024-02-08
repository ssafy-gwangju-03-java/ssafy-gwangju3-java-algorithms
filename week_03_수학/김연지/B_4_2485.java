package study;

import java.util.Arrays;
import java.util.Scanner;

public class B_4_2485 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int [n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int [] arr2 = new int [n-1];
		for(int i = 0; i < n-1; i++) {
			arr2[i]= arr[i+1] - arr[i];
		}
		int result = 0;
		int temp = gcd(arr2[0],arr2[1]);
		for(int i = 2; i < n-1; i++) {
			temp = gcd(temp,arr2[i]);
		}
		for(int i = 0; i < n-1; i++) {
			result += arr2[i]/temp-1;
		}
		System.out.println(result);

	}
	
	public static int gcd(int a ,int b){
	    if (b == 0) return a;
	    return gcd(b, a % b);
	}
	

}
