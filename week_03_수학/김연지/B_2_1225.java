package study;

import java.util.Scanner;

public class B_2_1225 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long total = 0;
		
		String s_a = sc.next();
		String s_b = sc.next();
		String[]arr_a = s_a.split("");
		String[]arr_b = s_b.split("");
		
		for(int i = 0; i < arr_a.length; i++) {
			for(int j = 0; j < arr_b.length; j++) {
				total += Integer.parseInt(arr_a[i])*Integer.parseInt(arr_b[j]);
			}
		}
		System.out.println(total);
		

	}

}
