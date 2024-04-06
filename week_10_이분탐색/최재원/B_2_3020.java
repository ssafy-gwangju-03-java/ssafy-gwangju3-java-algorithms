import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2_3020 {
    static int N, H, len;
    static int[] top, bottom;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("week_10_이분탐색/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int len = N / 2;

        top = new int[len];
        bottom = new int[len];

        for (int i = 0; i < len; i++) {
            top[i] = Integer.parseInt(br.readLine());
            bottom[i] = Integer.parseInt(br.readLine());
        }

        int min_v = N;
        int count = 0;

        Arrays.sort(top);
        Arrays.sort(bottom);

        for (int i = 1; i <= H; i++) {
            int temp = binarySearch(0, len, i, bottom)
                    + binarySearch(0, len, H - i + 1, top);

            if (min_v == temp) {
                count += 1;
            } else if (min_v > temp) {
                min_v = temp;
                count = 1;
            }
        }

        System.out.println(min_v + " " + count);
        br.close();
    }

    static int binarySearch(int left, int right, int h, int[] arr) {
        while (left < right) {
            int middle = (left + right) / 2;

            if (arr[middle] >= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return arr.length - right;
    }
}
