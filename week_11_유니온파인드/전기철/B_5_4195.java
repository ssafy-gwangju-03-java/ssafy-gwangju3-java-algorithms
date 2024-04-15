package week_11_유니온파인드.전기철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_5_4195 {
    static HashMap<String,String> dic;
    static HashMap<String,Integer> cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for (int tc=0;tc<t;tc++){
            dic=new HashMap<>();
            cnt=new HashMap<>();
            int f=Integer.parseInt(br.readLine());
            for(int i=0;i<f;i++){
                st=new StringTokenizer(br.readLine());
                String x=st.nextToken();
                String y=st.nextToken();
                if(!dic.containsKey(x)){
                    dic.put(x,x);
                    cnt.put(x,1);
                }
                if(!dic.containsKey(y)){
                    dic.put(y,y);
                    cnt.put(y,1);
                }
                union(x, y);
                System.out.println(cnt.get(findset(x)));
            }
        }
    }

    static void union(String a, String b) {
        String pa = findset(a);
        String pb = findset(b);

        if (pa != pb) {
            dic.put(pb,pa);
            cnt.put(pa,cnt.get(pa)+cnt.get(pb));
        }
        return;
    }

    static String findset(String a) {
        if (a == dic.get(a)) {
            return a;
        }
        dic.put(a,findset(dic.get(a)));
        return dic.get(a);
    }
}

