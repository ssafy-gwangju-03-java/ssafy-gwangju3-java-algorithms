import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_0_9663 {
    static int N, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        count = 0;

        queen(0);

        System.out.println(count);
        br.close();
    }

    static void queen(int row) {
        if (row == N) {
            count += 1;
            return;
        }

        for (int column = 0; column < N; column++) {
            boolean canPlace = true;
            for (int i = 0; i < row; i++) {
                if (arr[i] == column || Math.abs(row - i) == Math.abs(column - arr[i])) {
                    canPlace = false;
                    break;
                }
            }

            if (canPlace) {
                arr[row] = column;
                queen(row + 1);
            }
        }
    }
}
