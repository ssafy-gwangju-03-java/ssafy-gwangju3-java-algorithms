import java.io.IOException;
import java.util.Scanner;

public class B_29_2738 {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] aArr = new int[n][m];
        int[][] bArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                aArr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bArr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ans = aArr[i][j] + bArr[i][j];
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}
