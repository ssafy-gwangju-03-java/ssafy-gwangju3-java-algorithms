import java.util.Scanner;

public class B_26_10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] lst= new int[a];
		int b = sc.nextInt();
		int cnt = 0;
		for(int i=0;i<a;i++){
			int c = sc.nextInt();
			if(b>c){
				lst[cnt]=c;
				cnt+=1;
			}
		}
		for(int i=0;i<cnt;i++){
			System.out.print(lst[i]+" ");
		}
		sc.close();
	}	

}
