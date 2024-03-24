import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_3_1484 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int p1 = 1;
        int p2 = 2;

        while (p1 < 50000 && p1 != p2) {
            int rem = p1 * p1;
            int cur = p2 * p2;

            if (cur - rem == G) {
                list.add(p2);
                p2 += 1;
            } else if (cur - rem < G) {
                p2 += 1;
            } else {
                p1 += 1;
            }

        }

        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}