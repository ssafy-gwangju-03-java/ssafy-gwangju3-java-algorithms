import java.util.*;

public class B_5_4195 {
    static int[]parent;
    static int[]level;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < T; tc++){
            int f = sc.nextInt();
            parent = new int[f*2];
            level = new int[f*2];
            for(int i = 0; i < f*2;i++){
                parent[i]=i;
                level[i]=1;
            }
            int idx = 0;
            Map<String,Integer> map = new HashMap<>();

            for(int i = 0; i < f; i++){
                String a = sc.next();
                String b = sc.next();
                if(!map.containsKey(a)){
                    map.put(a,idx++);
                }
                if(!map.containsKey(b)){
                    map.put(b,idx++);
                }
                sb.append(union(map.get(a),map.get(b))+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static int union(int x,int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            parent[y] = x;
            level[x] += level[y];
            level[y] = 1;
        }
        return level[x];
    }
}
