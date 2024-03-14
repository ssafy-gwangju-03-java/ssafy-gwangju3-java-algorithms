import java.util.Scanner;

public class B_1_2961 {
  static int n;
  static int[][] lst; 
  static int s,b,mn;
  public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    n=sc.nextInt();
    sc.nextLine();
    lst=new int[n][2];
    for(int i=0; i<n;i++){
      String[] s=sc.nextLine().split(" ");
      for(int j=0;j<2;j++){
        lst[i][j]=Integer.parseInt(s[j]);
      }
    }
    mn=1000000000;
    for(int i=1;i<=n;i++){
      boolean[] vis =new boolean[n];

      comb1(lst,vis,0,i);
    }
  System.out.println(mn);
  sc.close();
  }
  static void comb1(int[][] arr, boolean[] visited, int start, int r) {
    if(r == 0) {
      s=1;
      b=0;
        for(int i=0;i<arr.length;i++){
          if(visited[i]==true){
            s*=arr[i][0];
            b+=arr[i][1];
          }
        }
        mn=Math.min(Math.abs(s-b),mn);
        return;
    } 
    else {
        for(int i = start; i < arr.length; i++) {
            visited[i] = true;
            comb1(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }
}
  
}
