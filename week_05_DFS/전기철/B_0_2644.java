import java.util.ArrayList;
import java.util.Scanner;

public class B_0_2644 {
    static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
    static int[] vis= new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for (int i=0; i<101;i++){
            lst.add(new ArrayList<>());
        }
        int x= sc.nextInt();
        int y= sc.nextInt();
        int p = sc.nextInt();
        for(int i=0;i<p;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        dfs(x,0);
        if(vis[y]==0){
            System.out.println(-1);
        }
        else{
            System.out.println(vis[y]);
        }
        sc.close();
    }
    public static void dfs(int a,int cnt){
        vis[a]=cnt;
        for (int i=0;i<lst.get(a).size();i++){
            if (vis[lst.get(a).get(i)]==0){
                dfs(lst.get(a).get(i),cnt+1);
            }
        }
    }

    }
