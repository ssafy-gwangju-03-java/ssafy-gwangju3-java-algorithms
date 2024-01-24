import java.util.Scanner;

public class B_28_5597 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] lst=new int[31];
		for(int i=0;i<28;i++){
			int a=sc.nextInt();
			lst[a]=1;
		}
		for (int i=1;i<31;i++){
			if(lst[i]==0){
				System.out.println(i);
			}
		}
		sc.close();
	}	
	
}
