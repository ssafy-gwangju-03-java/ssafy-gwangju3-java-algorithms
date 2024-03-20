package study_week8;

import java.util.Scanner;

public class B_4_1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (true) {
            if (s <= sum) {
                sum -= arr[left];
                result = Math.min(result, right - left);
                left++;
            } else if (right == n) {
                break;
            } else {
                sum += arr[right];
                right++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }

}
