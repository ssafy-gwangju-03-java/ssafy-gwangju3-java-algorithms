package study;

import java.util.Scanner;

public class B_3_19532 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		int x = 0;
		int y = 0;
		int n = 0;
		int m = 0;
		if(a == 0) {
			y = c/b;
			x = (f-e*y)/d;
		}else if(d == 0) {
			y = c / b;
			x = (c - b*y)/a;
		}else {
			n = lcm(a,d)/a;
			m = lcm(a,d)/d;
		}
		
		if((n*b-m*e)== 0) {
			
			if(b == 0) {
				x = c/a;
				y = (f-d*x)/e;
			}else if(e == 0) {
				x = f/d;
				y = (c-a*x)/b;
			}else {
				n = lcm(a,d)/a;
				m = lcm(a,d)/d;
			}
			n = lcm(b,e)/b;
			m = lcm(b,e)/e;
			x = (n*c-m*f)/(n*a-m*d);
			y = (c-a*x)/b;
		}else {
			
			y = (n*c - m*f)/(n*b-m*e);
			x = (c-b*y)/a;
		}
		
		System.out.println(x+" "+y);
		
		
		

	}
	
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

}
