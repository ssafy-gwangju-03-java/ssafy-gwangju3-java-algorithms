import java.util.Scanner;

public class B_38_2475 {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int cnt=0;
	for(int i=0;i<5;i++){
		int x= sc.nextInt();
		cnt+=x*x;
	}
	System.out.println(cnt%10);
}
}
