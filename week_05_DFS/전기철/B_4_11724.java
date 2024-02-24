import java.util.ArrayList;
import java.util.Scanner;

public class B_4_11724 {
    static int[] vis = new int[1001];
    static ArrayList<ArrayList<Integer>> lst=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int cnt=0;
        for(int i=0;i<n+1;i++){
            lst.add(new ArrayList<>());
        }
        for (int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            lst.get(a).add(b);
            lst.get(b).add(a);
        }

        for(int i=1;i<n+1;i++){
            if(vis[i]==0){
                dfs(i);
                cnt+=1;
            }
        }
        System.out.println(cnt);


        sc.close();
    }
    public static void dfs(int x){
        vis[x]=1;
        for(int i=0;i<lst.get(x).size();i++){
            if(vis[lst.get(x).get(i)]==0){
                dfs(lst.get(x).get(i));
            }
        }
    }

}
