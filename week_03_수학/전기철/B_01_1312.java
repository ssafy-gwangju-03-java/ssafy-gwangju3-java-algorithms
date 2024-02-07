import java.util.Scanner;

public class B_01_1312 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt();
		int n =sc.nextInt();
		int c = a%b;
		for(int i=0;i<n;i++){
			a=(a%b)*10;
			c=(int)(a/b);
		}
		System.out.println(c);
		sc.close();
	}
}
