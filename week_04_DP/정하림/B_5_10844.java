package java_study.w4;

import java.util.Scanner;

public class B_5_10844 {
    // 22까지만 구해지고 메모리 초과
//    static int[][] step;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        step = new int[N+1][(int) Math.pow(2,N) * 9];
//        step[1]= new int[]{1,2,3,4,5,6,7,8,9};
//        int c = 9, cn = 9;
//        int End;
//        for (int i = 2; i < N+1 ; i++) {
//            c = 0;
//            for (int j = 0; j < step[i-1].length; j++) {
//                if (step[i-1][j] == 0) {
//                    break;
//                }
//                End = step[i - 1][j] % 10;
//                switch (End) {
//                    case 0: step[i][c] = step[i-1][j] * 10 + 1;
//                        c++;
//                        break;
//                    case 9: step[i][c] = step[i-1][j] * 10 + 8;
//                        c++;
//                        break;
//                    default: step[i][c] = step[i-1][j] * 10 + (End-1);
//                        c++;
//                        step[i][c] = step[i-1][j] * 10 + (End+1);
//                        c++;
//                        break;
//                }
//            }
//        }
//        System.out.println(c % 1000000000);
//    }
}

//0 1
//1 9
//2 17 9*2-1
//3 32 17*2-2
//4 61 32*2-3 4-1
//5 116 61*2-6 6-0
//6 222 116*2 -10 12-2
//7 424 - 20 20-0
//8 813 - 35 40-5
//9 1556 70 70-0
//10 2986 - 126 140-14
//11 5541 - 431