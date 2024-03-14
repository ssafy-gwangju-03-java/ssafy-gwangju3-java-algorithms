package study_week7;

import java.io.*;
import java.util.*;

public class B_3_6443 {
    static BufferedWriter bw;
    static int n;
    static char[] arr, result,max;
    static boolean[]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        while(n-->0){
            arr = br.readLine().toCharArray();
            int len = arr.length;
            result = new char[len];
            max = new char[len];
            visited = new boolean[len];

            Arrays.sort(arr);
            perm(len,0);
        }
        bw.flush();
        bw.close();
    }

    static void perm(int len, int depth) throws IOException{
        if(depth==len){
            bw.write(result);
            bw.write("\n");
            return;
        }
        max[depth] = 0;
        for(int i = 0; i < len; i++){
            if(visited[i]) continue;
            if(max[depth]>=arr[i]) continue; // 백트래킹
            max[depth] = arr[i];

            visited[i] = true;
            result[depth] = arr[i];
            perm(len,depth+1);
            visited[i] = false;
        }
    }

}

