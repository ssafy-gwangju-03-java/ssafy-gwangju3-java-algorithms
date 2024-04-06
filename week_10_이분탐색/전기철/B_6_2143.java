import java.util.Arrays;
import java.util.Scanner;

public class B_6_2143 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int n=sc.nextInt();
        sc.nextLine();
        int[] a=new int[n];
        String[] s= sc.nextLine().split(" ");
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s[i]);
        }
        int m=sc.nextInt();
        sc.nextLine();
        int[] b=new int[m];
        String[] x= sc.nextLine().split(" ");
        for(int i=0;i<m;i++){
            b[i]=Integer.parseInt(x[i]);
        }
        int[] left=new int[n*(n+1)/2];
        int[] right=new int[m*(m+1)/2];
        int idx1=0;
        int idx2=0;
        for(int i=0;i<n;i++){
            left[i]=a[i];
            idx1+=1;
        }
        for(int j=0;j<m;j++){
            right[j]=b[j];
            idx2+=1;
        }
        for(int i=0;i<n-1;i++){
            int p=a[i];
            for(int j=i+1;j<n;j++){
                p+=a[j];
                left[idx1]=p;
                idx1+=1;
            }
        }
        for(int i=0;i<m-1;i++){
            int q=b[i];
            for(int j=i+1;j<m;j++){
                q+=b[j];
                right[idx2]=q;
                idx2+=1;
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int i=0;
        int j=right.length-1;
        long cnt=0;
        while (i<left.length && j>=0) {
            if (left[i]+right[j]>t){
                j-=1;
            }
            else if (left[i]+right[j]<t){
                i+=1;
            }
            else{
                long chk1=1;
                long chk2=1;
                while (i+1<left.length && left[i]==left[i+1]) {
                    chk1+=1;
                    i+=1;
                }
                while (j-1>=0 && right[j]==right[j-1]) {
                    chk2+=1;
                    j-=1;
                }
                cnt+=chk1*chk2;
                i+=1;
                j-=1;
            }
        }
        System.out.println(cnt);

    }
}
