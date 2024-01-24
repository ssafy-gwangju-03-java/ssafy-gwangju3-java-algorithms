import java.util.Scanner;

public class B_27_10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] lst= new int[a];
		int cnt=0;
		for(int i=0;i<a;i++){
			int b = sc.nextInt();
			lst[i]=b;
		}
		int c= sc.nextInt();
		for (int i=0;i<a;i++){
			if(lst[i]==c){
				cnt+=1;
			}
		}
		System.out.println(cnt);
		sc.close();
	}	
}
