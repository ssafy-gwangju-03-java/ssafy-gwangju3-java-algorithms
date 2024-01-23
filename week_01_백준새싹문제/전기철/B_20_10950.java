import java.util.Scanner;

public class B_20_10950 {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		for(int i=1;i<x+1;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			System.out.println(a+b);
		}
		sc.close();
	}
}
