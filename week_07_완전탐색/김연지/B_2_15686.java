package study_week7;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2_15686 {
    static ArrayList<int[]>home;
    static ArrayList<int[]>ck;
    static int n,m;
    static boolean[] open;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int [][] city = new int [n][n];
        home = new ArrayList<>();
        ck = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j]==1){
                    home.add(new int[]{i,j});
                }
               else if(city[i][j]==2){
                   ck.add(new int[]{i,j});
                }
            }
        }
        open = new boolean[ck.size()];

//        for(int i = 0; i < home.size(); i++){
//            for(int j = 0; j < home.get(i).length; j++){
//                System.out.print(home.get(i)[j]+" ");
//            }
//            System.out.println();
//        }


        dfs(0,0);
        System.out.println(result);

    }
//    static int dis(int[]home, int []ck){
//        return Math.abs(home[0] - ck[0]) + Math.abs(home[1] - ck[1]);
//    }

    static void dfs(int start, int cnt){
        if(cnt==m){
            int sum = 0;
            for(int i = 0; i < home.size(); i++){
                int d = Integer.MAX_VALUE;
                for(int j = 0; j < ck.size(); j++){
                    if(open[j]){
                        int distance = Math.abs(home.get(i)[0]-ck.get(j)[0]) + Math.abs(home.get(i)[1]-ck.get(j)[1]);
                        d = Math.min(d,distance);
                    }
                }
                sum+=d;
            }
            result = Math.min(result,sum);
            return;
        }
        for(int i = start; i < ck.size(); i++){
            open[i] = true;
            dfs(i+1,cnt+1);
            open[i] = false;
        }
    }
}
