package study;

import java.util.Scanner;

public class B_1_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] arr = new long [n+10];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        for(int i = 4; i < n+1; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        System.out.println(arr[n]);

    }
}
