import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B_04_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n-1];
        HashSet<Integer> gcdBasket = new HashSet<>(n);

        int prev = Integer.parseInt(br.readLine());
        for (int i = 0; i < n-1; i++) {
            int curr = Integer.parseInt(br.readLine());
            nums[i] = curr - prev;
            prev = curr;
        }

        int myGcd = nums[0];

        for (int i = 1; i < n-1; i++) {
            myGcd = gcd(myGcd, nums[i]);
        }

        int s = 0;
        for (int i = 0; i < n-1; i++) {
            s += (nums[i]/myGcd - 1);
        }

        System.out.println(s);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {return a;}
        return gcd(b, a%b);
    }
}
