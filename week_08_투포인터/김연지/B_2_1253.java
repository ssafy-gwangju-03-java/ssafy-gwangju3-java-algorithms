package study_week8;

import java.util.Scanner;

public class B_2_1253 {
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(check(i)){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    static boolean check(int a){
        for(int i = 0; i < n-1; i++){
            int sum = 0;
            for(int j = i+1; j < n; j++){
                if(i!=j && i!= a && j!= a){
                    sum = arr[i] + arr[j];
                    if (sum == arr[a]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
