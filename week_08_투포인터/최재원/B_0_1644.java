import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_0_1644 {
    static int N;
    static ArrayList<Integer> prime_numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("week_08_투포인터/최재원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        findPrimeNumbers();

        int i = 0;
        int j = 0;

        int count = 0;

        while (i < prime_numbers.size() && j < prime_numbers.size()) {
            int sum = 0;

            for (int k = i; k <= j; k++) {
                sum += prime_numbers.get(k);
            }

            if (sum == N) {
                count += 1;
                i += 1;
            } else if (sum < N) {
                j += 1;
            } else {
                i += 1;
            }
        }

        System.out.println(count);
    }

    private static void findPrimeNumbers() {
        boolean[] prime = new boolean[N + 1];

        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!prime[i]) {
                prime_numbers.add(i);
            }
        }
    }
}
