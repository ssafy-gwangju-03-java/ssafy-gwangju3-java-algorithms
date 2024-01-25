
import java.util.Scanner;
public class B_33_2754 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String score = sc.nextLine();
        double result = 0.0;
        switch (score) {
            case "A+":
                result = 4.3;
                break;
            case "A0":
                result = 4.0;
                break;
            case "A-":
                result = 3.7;
                break;
            case "B+":
                result = 3.3;
                break;
            case "B0":
                result = 3.0;
                break;
            case "B-":
                result = 2.7;
                break;
            case "C+":
                result = 2.3;
                break;
            case "C0":
                result = 2.0;
                break;
            case "C-":
                result = 1.7;
                break;
            case "D+":
                result = 1.3;
                break;
            case "D0":
                result = 1.0;
                break;
            case "D-":
                result = 0.7;
                break;
            case "F":
                result = 0.0;
                break;
        }

        System.out.println(result);
    }
}
