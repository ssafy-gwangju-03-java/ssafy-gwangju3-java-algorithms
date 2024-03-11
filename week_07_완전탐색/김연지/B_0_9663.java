import java.util.Scanner;

public class Main {
	static int [][]board;
	static int cnt;
	static int n;
	static int[]cols;
	static int[]dia;
	static int[]udia;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cols = new int[n+1];
		dia = new int[2*n+1];
		udia = new int[2*n+1];
		cnt = 0;
		
		queen(1);
		System.out.println(cnt);
		
		
	}
	public static void queen(int row) {
		if (row == n+1) {
			cnt++;
			return;
		}
		for(int col = 1; col <= n; col++) {
			if((cols[col]==1)||dia[row+col]==1||udia[n+(row-col)+1]==1) continue;
			cols[col]=1;
			dia[row+col]=1;
			udia[n+(row-col)+1]=1;
			queen(row+1);
			cols[col]=0;
			dia[row+col]=0;
			udia[n+(row-col)+1]=0;
			
		}
	}

}
