import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_04_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        ArrayList<Integer> intervals = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            intervals.add(list.get(i) - list.get(i - 1));
        }

        int min_num = gcd(intervals.get(0), intervals.get(1));
        for (int i = 2; i < intervals.size(); i++) {
            min_num = gcd(min_num, intervals.get(i));
        }

        int count = 0;

        for (int i = 1; i < list.size(); i++) {
            long temp = list.get(i) - list.get(i - 1);

            count += (temp / min_num) - 1;
        }

        System.out.println(count);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
