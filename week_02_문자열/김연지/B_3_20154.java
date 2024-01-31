package baekjoon;

import java.util.Scanner;

public class B_3_20154 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String [] arr = sc.next().split("");
		int total = 0;
		String [] arr3 = {"A","E","F","G","H","K","M","N"};
		String [] arr2 = {"B","D","P","Q","R","T","W","X","Y"};
		String [] arr1 = {"C","I","J","L","O","S","U","V","Z"};
		int [] result = new int [arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr3.length; j++) {
				if(arr[i].equals(arr3[j])) {
					result[i] = 3;
				}
			}
			for(int j = 0; j < arr2.length; j++) {
				if(arr[i].equals(arr2[j])) {
					result[i] = 2;
				}
			}
			for(int j = 0; j < arr1.length; j++) {
				if(arr[i].equals(arr1[j])) {
					result[i] = 1;
				}
			}
		}
		for(int i = 0; i < result.length; i++) {
			total += result[i];
			if(total>=10) {
				total = total%10;
			}
		}
		if(total % 2 == 0) {
			System.out.println("You're the winner?");
		} else {
			System.out.println("I'm a winner!");
		}

	}

}
