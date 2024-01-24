import java.util.Scanner;

public class B_29_2738 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int[][] lst1=new int[a][b];
		int[][] lst2=new int[a][b];
		int[][] lst3=new int[a][b];
		for (int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				int c=sc.nextInt();
				lst1[i][j]=c;
			}
		}
		for (int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				int c=sc.nextInt();
				lst2[i][j]=c;
			}
		}
		for (int i=0;i<a;i++){
			for(int j=0;j<b;j++){
				lst3[i][j]=lst1[i][j]+lst2[i][j];
				System.out.print(lst3[i][j]+" ");
			}
			System.out.println();
		}

		sc.close();
	}
}
