package baekjoon;

import java.util.Scanner;

public class B_28_5597 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        boolean [] bool = new boolean [31];
        

        for(int i = 0; i < 28; i++){
            int n = sc.nextInt();
            bool[n] = true;
        }
        int [] result = new int [2];
        int k = 0;
        for(int i = 1; i <= 30; i++){
            if(bool[i]==false){
                result[k] = i;
                k++;
            }
        }

	}

}
