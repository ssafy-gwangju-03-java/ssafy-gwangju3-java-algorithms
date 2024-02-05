import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B_00_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nums = br.readLine().split("");

        int sum = 0;

        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        Arrays.sort(nums, Collections.reverseOrder());

        if(sum % 3 == 0 && Integer.parseInt(nums[nums.length - 1]) == 0){
            for (String num : nums) {
                sb.append(num);
            }
            System.out.println(sb);
        }else{
            System.out.println(-1);
        }
    }
}
