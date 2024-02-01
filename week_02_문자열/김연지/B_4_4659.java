package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_4_4659 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			String s = sc.next();
			if (s.equals("end")) {
				break;
			}
			String[] arr = s.split("");
			int cnt = 0;
			if (!s.contains("a") && !s.contains("e") && !s.contains("i") && !s.contains("o") && !s.contains("u")) {
				cnt++;
			}
			List <String> alp1 = new ArrayList<>();
			alp1.add("a");
			alp1.add("e");
			alp1.add("i");
			alp1.add("o");
			alp1.add("u");

			for (int i = 0; i < arr.length; i++) {
				if (i + 2 < arr.length) {
					if(alp1.contains(arr[i])&&alp1.contains(arr[i+1])&&alp1.contains(arr[i+2])) {
						cnt++;
					} else if(!alp1.contains(arr[i])&&!alp1.contains(arr[i+1])&&!alp1.contains(arr[i+2])) {
						cnt++;
					}
				}
			}

			for (int i = 0; i < arr.length; i++) {
				if (i + 1 < arr.length) {
					if (arr[i].equals(arr[i + 1]) && !arr[i].equals("e") && !arr[i].equals("o")) {
						cnt++;
					}
				}
			}

			if (cnt == 0) {
				System.out.println("<" + s + ">" + " is acceptable.");
			} else {
				System.out.println("<" + s + ">" + " is not acceptable.");
			}

		}

	}

}
