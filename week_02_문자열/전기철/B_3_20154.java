import java.util.Scanner;

public class B_3_20154 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String s = sc.nextLine();
		int cnt=0;
		int[] lst = new int[]{3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
		for(int i=0;i<s.length();i++){
			cnt+=lst[s.charAt(i)-65];
		}
		if(cnt%2==0){
			System.out.println("You're the winner?");
		}
		else{
			System.out.println("I'm a winner!");
		}
	sc.close();
	}
}
