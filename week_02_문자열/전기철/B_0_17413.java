import java.util.Scanner;

public class B_0_17413 {
	public static void main (String [] args) {
        // Welcome
		Scanner sc = new Scanner(System.in);
        int chk = 1; // chk 0이면 정방향, 1이면 역방향
        String s = sc.nextLine();
        StringBuilder p = new StringBuilder();//답 문자열
        StringBuilder q = new StringBuilder();//< > " " 아니면 저장할 저장소
        for(int i=0; i<s.length();i++){
            //String k = s.valueOf(s.charAt(i)); <- 실제 코드
			String k = new String(); // <- 임시용
            if (chk==1){//역방향
                if (k.equals("<")){
                    p.append(q.reverse());
                    p.append("<");
                    q.setLength(0);
                    chk=0;
                }
                else if (k.equals(" ")){
                    p.append(q.reverse());
                    p.append(" ");
                    q.setLength(0);
                }
                else{
                    q.append(k);
                }
                if (i==s.length()-1){
                    p.append(q.reverse());
                }
            }
            else{//정방향
                if(k.equals(">")){
                    p.append(k);
                    chk=1;
                }
                else{
                    p.append(k);
                }
            }
        }
        System.out.println(p);

		sc.close();
    }
    
}
