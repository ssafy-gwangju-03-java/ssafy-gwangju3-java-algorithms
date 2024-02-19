import java.util.ArrayList;
import java.util.Scanner;

public class B_0_2606 {
    static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
    static int[] vis= new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for (int i=0; i<101;i++){
            lst.add(new ArrayList<>());
        }
        int x= sc.nextInt();
        for(int i=0;i<x;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        dfs(1);
        int cnt=0;
        for(int i=0; i<n+1;i++){
            if (vis[i]==1){
                cnt+=1;
            }
        }
        System.out.println(cnt-1);
        sc.close();
    }
    public static void dfs(int a){
        vis[a]=1;
        for (int i=0;i<lst.get(a).size();i++){
            if (vis[lst.get(a).get(i)]==0){
                dfs(lst.get(a).get(i));
            }
        }
    }

    }
