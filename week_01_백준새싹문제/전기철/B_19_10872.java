import java.util.Scanner;

public class B_19_10872 {
			public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=1;
		for(int i=1;i<a+1;i++){
			b*=i;
		}
		System.out.println(b);
		sc.close();
	}
}
