package baekjoon;

import java.util.Scanner;

public class B_33_2754 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c = sc.next();
		if (c.equals("A+")) {
			System.out.println(4.3);
		} else if (c.equals("A0")) {
			System.out.println(4.0);
		} else if (c.equals("A-")) {
			System.out.println(3.7);
		} else if (c.equals("B+")) {
			System.out.println(3.3);
		} else if (c.equals("B0")) {
			System.out.println(3.0);
		} else if (c.equals("B-")) {
			System.out.println(2.7);
		} else if (c.equals("C+")) {
			System.out.println(2.3);
		} else if (c.equals("C0")) {
			System.out.println(2.0);
		} else if (c.equals("C-")) {
			System.out.println(1.7);
		} else if (c.equals("D+")) {
			System.out.println(1.3);
		} else if (c.equals("D0")) {
			System.out.println(1.0);
		} else if (c.equals("D-")) {
			System.out.println(0.7);
		} else if (c.equals("F")) {
			System.out.println(0.0);
		}
	}
}
