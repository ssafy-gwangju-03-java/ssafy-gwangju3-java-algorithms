import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_05_1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target_num = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0;
        int right = 0;

        if(target_num < arr[0]) {
            left = 0;
            right = arr[0];
        } else{
            for (int i = 0; i < arr.length - 1; i++) {
                if (target_num >= arr[i] && target_num <= arr[i + 1]) {
                    left = arr[i];
                    right = arr[i + 1];
                }
            }
        }

        int interval = right - left - 1;
        int total = interval * (interval - 1) / 2;

        int left_space = target_num - left - 1;
        int left_cnt = 0;

        if (left_space > 1) {
            left_cnt = left_space * (left_space - 1) / 2;
        }

        int right_space = right - target_num - 1;
        int right_cnt = 0;

        if (right_space > 1) {
            right_cnt = right_space * (right_space - 1) / 2;
        }

        System.out.println(total - right_cnt - left_cnt);
    }
}
