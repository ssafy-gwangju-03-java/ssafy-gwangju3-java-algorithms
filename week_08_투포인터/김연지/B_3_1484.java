package study_week8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_3_1484 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int cnt = 0;
        for(int i = 1; i <= 50000; i++){
//            if(i>g)break;
            for(int j = 1; j < i; j++){
                if((i+j) > g) break;

                else if((i+j)*(i-j)==g){
                    cnt++;
                    System.out.println(i);
                }
            }
        }
        if(cnt == 0){
            System.out.println(-1);
        }

    }
}
