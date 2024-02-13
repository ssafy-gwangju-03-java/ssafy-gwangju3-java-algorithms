package study;

import java.util.Arrays;
import java.util.Scanner;

public class B_5_1059 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int l = Integer.parseInt(sc.nextLine());
		String temp = sc.nextLine();
		String [] tp = temp.split(" ");
		int n = Integer.parseInt(sc.nextLine());
		int [] arr = new int [tp.length];
		for(int i = 0; i < tp.length; i++) {
			arr[i] = Integer.parseInt(tp[i]);
		}
		int start = 0;
		int end = 0;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length-1; i++) {
			if(n>arr[i] && n<arr[i+1]) {
				start = arr[i];
				end = arr[i+1];
			}
		}
		if(start==0 && end ==0) {
			if(n<arr[0]) {
				System.out.println(n*(arr[0]-n)-1);
			}else {
				System.out.println(0);
			}
		} else {
			int total = (n-start-1+1)*(end-n);
//			if(n-1!=start) {
//				total+=end-1-n+1;
//			}
//			
			System.out.println(total-1);
		}
		
		

	}

}
