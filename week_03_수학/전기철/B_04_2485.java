import java.util.ArrayList;
import java.util.Scanner;

public class B_04_2485 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> lst = new ArrayList<>();
		ArrayList<Integer> lst2 = new ArrayList<>();
		for (int i=0; i<n; i++){
			int x=sc.nextInt();
			lst.add(x);
		}		
		int cnt=0;
		int min=0;
		for (int i=0;i<n-1;i++){
			lst2.add(lst.get(i+1)-lst.get(i));
		}
		for(int i=0;i<n-1;i++){
			min=gcd(lst2.get(i),min);
		}
		for (int i=0;i<n-1;i++){
			cnt+=(int)(lst2.get(i)/min)-1;
		}

		System.out.println(cnt);
		sc.close();
	}
	public static int gcd(int a,int b) {
		if (b==0) return a;
		return gcd(b,a%b);
	}
}
