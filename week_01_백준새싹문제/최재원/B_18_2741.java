import java.util.Scanner;
import java.util.stream.IntStream;

public class B_18_2741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        IntStream.range(1, num + 1).forEach(System.out::println);
    }
}
