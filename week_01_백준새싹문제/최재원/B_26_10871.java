import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B_26_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        String[] inputs = br.readLine().split(" ");

        long[] result = IntStream.range(0, count)
                .mapToLong(i -> Long.parseLong(inputs[i]))
                .filter(value -> value < num)
                .toArray();

        IntStream.range(0, result.length)
                .forEach(i -> {
                    if (i == result.length - 1) {
                        System.out.print(result[i]);
                    } else {
                        System.out.print(result[i] + " ");
                    }
                });
    }
}
