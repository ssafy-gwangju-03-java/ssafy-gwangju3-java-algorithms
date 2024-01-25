import java.util.Scanner;

public class B_32_2744 {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s = sc.nextLine();
	for (int i=0;i<s.length();i++){
		int x = s.charAt(i);
		if(x>=97){
			x-=32;
			char m= (char) x;
			System.out.print(m);
		}
		else{
			x+=32;
			char m = (char) x;
			System.out.print(m);
		}
	}
	sc.close();
}
}
