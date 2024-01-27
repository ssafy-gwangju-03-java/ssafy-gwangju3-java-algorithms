package baekjoon;

import java.util.Scanner;

public class B_36_9086 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            String a = sc.next();
            String [] arr = a.split("");
            System.out.print(arr[0]);
            //System.out.print(arr.length);
             System.out.print(arr[arr.length-1]);
             System.out.println();
        }

	}

}
