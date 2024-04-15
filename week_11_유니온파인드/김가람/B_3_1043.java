package 김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_3_1043 {
    static int truthRep;
    static int N;
    static int M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        String[] truthInfo = br.readLine().split(" ");
        int truthPpl = Integer.parseInt(truthInfo[0]);

        // 진실 팀의 대표자 선정
        if (truthPpl >= 1) {
            truthRep = Integer.parseInt(truthInfo[1]);
        }

        for (int i = 2; i <= truthPpl; i++) {
            int temp = Integer.parseInt(truthInfo[i]);
            union(truthRep, temp);
        }

        // 파티 회차마다의 참여자 정보를 party 이차원 ArrayList에 저장
        ArrayList<ArrayList<Integer>> party = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            // i회차 파티 정보
            ArrayList<Integer> currParty = new ArrayList<>();
            String[] temp = br.readLine().split(" ");
            int partyPpl = Integer.parseInt(temp[0]);

            for (int j = 1; j <= partyPpl; j++) {
                currParty.add(Integer.parseInt(temp[j]));
            }

            // 파티 진행시마다 참여자들끼리 union
            for (int j = 1; j < partyPpl; j++) {
                union(currParty.get(j), currParty.get(j-1));
            }

            party.add(currParty);
        }

        int ans = 0;

        for (int i = 0; i < M; i++) {
            // i회차 파티 정보
            ArrayList<Integer> currParty = party.get(i);

            boolean hasTruth = false;
            for (int j = 0; j < currParty.size(); j++) {
                // j번째 파티 참여자의 최종부모가 truthRep이라면 true 저장
                if (find(currParty.get(j)) == truthRep) {
                    hasTruth = true;
                    break;
                }
            }

            if (!hasTruth) ans++;
        }

        System.out.println(ans);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;

        // truthRep의 팀으로 편입
        if (x == truthRep) parent[y] = x;
        else parent[x] = y;
    }
}
