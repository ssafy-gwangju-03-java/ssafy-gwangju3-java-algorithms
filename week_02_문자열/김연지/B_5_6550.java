package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_5_6550 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String a = sc.next();
			String [] a_arr = a.split("");
			String b = sc.next();
			String [] b_arr = b.split("");
			List <String> arr = new ArrayList <>();
			int cnt = 0;
			int x = 0;
			for(int j = 0; j < b_arr.length; j++) {
				if(b_arr[j].equals(a_arr[x])) {
					arr.add(b_arr[j]);
					x += 1;
				}
				if (x == a_arr.length) {
					break;
				}
			}
			String str = String.join("",arr);
			if (str.equals(a)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

	}

}
