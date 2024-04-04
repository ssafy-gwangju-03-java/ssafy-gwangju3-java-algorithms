import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_4_7453 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];
        int[] b=new int[n];
        int[] c=new int[n];
        int[] d=new int[n];
        for (int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            a[i]=q;
            b[i]=w;
            c[i]=e;
            d[i]=r;
        }
        int[] left=new int[n*n];
        int[] right=new int[n*n];
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                left[idx]=a[i]+b[j];
                right[idx]=c[i]+d[j];
                idx+=1;
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        long cnt=0;
        int i=0;
        int j=right.length-1;
        while (i<left.length && j>=0) {
            if (left[i]+right[j]>0){
                j-=1;
            }
            else if (left[i]+right[j]<0){
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
