import java.util.*;
public class B_13_1330 {
	public static void main (String [] args) {
        // Welcome
		Scanner sc = new Scanner(System.in);
		int a,b;
		a=sc.nextInt();
		b=sc.nextInt();
		if (a>b){
			System.out.println(">");
		}
		else if (a==b){
			System.out.println("==");
		}
		else{
			System.out.println("<");
		}
		sc.close();
    }
}
