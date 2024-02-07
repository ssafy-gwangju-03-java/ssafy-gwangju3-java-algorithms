import java.util.Scanner;

public class B_02_1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();
        long a=0;
        long b=0;
        for (int i=0;i<x.length();i++){
            a+=x.charAt(i)-48;
        }
        for(int i=0;i<y.length();i++){
            b+=y.charAt(i)-48;
        }
        System.out.println(a*b);
        sc.close();
    }

    }