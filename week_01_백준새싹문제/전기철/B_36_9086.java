import java.util.Scanner;

public class B_36_9086 {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int x = sc.nextInt();
	for(int i=0;i<x;i++){
		String s = sc.next();	
		char a = s.charAt(0);
		char b = s.charAt(s.length()-1);
		System.out.print(a);
		System.out.println(b);
	}

	sc.close();	
}
}
