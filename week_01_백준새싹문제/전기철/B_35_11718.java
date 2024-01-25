import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class B_35_11718 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt=0;
		while(cnt<100){
			String s=br.readLine();
			if (s==null || s.equals("")){
				break;
			}
			System.out.println(s);
		}

		br.close();
		bw.flush();
		bw.close();
	}	
}
