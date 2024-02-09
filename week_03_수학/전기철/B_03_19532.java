import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_03_19532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a= Integer.parseInt(st.nextToken());
		int b= Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		int d= Integer.parseInt(st.nextToken());
		int e= Integer.parseInt(st.nextToken());
		int f= Integer.parseInt(st.nextToken());
		System.out.print((int)((c*e-b*f)/(a*e-b*d))+" ");
		System.out.print((int)((c*d-a*f)/(b*d-a*e)));
	}
}
