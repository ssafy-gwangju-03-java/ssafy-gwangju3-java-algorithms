import java.util.Scanner;

public class B_2_1388{
    static String[][] lst;
    static int x,y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nm=sc.nextLine();
        y=Integer.parseInt(nm.split(" ")[0]);
        x=Integer.parseInt(nm.split(" ")[1]);
        int cnt=0;
        lst=new String[y][x];
        for(int i=0;i<y;i++){
            String[] s=sc.nextLine().split("");
            for(int j=0;j<x;j++){
                lst[i][j]=s[j];
            }
        }
        for(int i=0;i<y;i++){
            for(int j=0; j<x;j++){
                if (lst[i][j].equals("-")){
                    dfs1(j,i);
                    cnt+=1;
                }
                else if (lst[i][j].equals("|")){
                    dfs2(j,i);
                    cnt+=1;
                }
            }
        }
        // for(int i=0;i<y;i++){
        //     for(int j=0;j<x;j++){
        //         System.out.print(lst[i][j]);
        //     }
        //     System.out.println();
        // }
        System.out.println(cnt);


        sc.close();
        
    }
    public static void dfs1(int p,int q){
        lst[q][p]=".";
        int nx=p+1;
        if (nx<x && lst[q][p+1].equals("-")){
            dfs1(nx,q);
        }

    }
    public static void dfs2(int p,int q){
        lst[q][p]=".";
        int ny = q+1;
        if (ny<y && lst[ny][p].equals("|")){
            dfs2(p,ny);
        }
        
    }
}