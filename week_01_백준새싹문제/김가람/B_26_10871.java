import java.io.*;
public class B_26_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s1 = br.readLine();
        String firstArr[] = s1.split(" ");
        int x = Integer.parseInt(firstArr[1]);

        String s2 = br.readLine();
        String secondArr[] = s2.split(" ");
        
        for (int i = 0; i < secondArr.length; i++) {
            if (Integer.parseInt(secondArr[i]) < x) {
                System.out.print(secondArr[i] + " ");
            }
        }       
    }
}
