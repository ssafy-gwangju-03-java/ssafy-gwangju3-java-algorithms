import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class B_25_15552 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t= Integer.parseInt(br.readLine());
		for (int i=0;i<t;i++){
			String s=br.readLine();
			int a= Integer.parseInt(s.split(" ")[0]);
			int b= Integer.parseInt(s.split(" ")[1]);
			bw.write(a+b+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}

//throw IOException -> 이 에러 날리겠다
// bufferedReader a = new bu~ (new InputStreamReader(system.in))
// int t =Integer.parseInt(br.readLine())
// 한줄로 읽기 - String s = br.readLine();
// 읽기 = readLine(), 쓰기 = write
// 마지막에 flush
// 형변환 ->bw.write(Integer.parseInt(i)+10+ "\n"); // 요렇게 개행문자를 넣거나
//          bw.write("이렇게하면 출력 가능 : "+ (Integer.parseInt(i)+10));
// https://terianp.tistory.com/19 <- 참고 링크