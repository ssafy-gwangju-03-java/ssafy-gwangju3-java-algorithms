package week_09_다익스트라.김가람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_5_11657 {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp1 = br.readLine().split(" ");

        N = Integer.parseInt(temp1[0]);
        M = Integer.parseInt(temp1[1]);
        Edge[] edges = new Edge[M];

        // s: start, e: end, w: weight
        for (int i = 0; i < M; i++) {
            String[] temp2 = br.readLine().split(" ");
            int s = Integer.parseInt(temp2[0]);
            int e = Integer.parseInt(temp2[1]);
            int w = Integer.parseInt(temp2[2]);
            edges[i] = new Edge(s, e, w);
        }

        long[] result = bellmanFord(edges);

        StringBuilder ans = new StringBuilder();

        for (long num : result) {
            if (num == Integer.MAX_VALUE) ans.append(-1 + "\n");
            else ans.append(num + "\n");
        }

        System.out.println(ans);
    }

    static long[] bellmanFord(Edge[] edges) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        /*
         * 1. 다익스트라: 그리디, 벨만포드: DP
         * 2. 한 번의 loop -> 두 정점 간의 경로 하나를 갱신
         *    M(간선의 갯수)번의 loop -> 모든 정점간의 경로를 갱신
         *       - dist 배열은 현재 INF 값으로 채워져 있고, 시작점 1번의 값만 0으로 설정된 상태
         *       - 그렇다면 첫번째 루프가 돌 때에 갱신될 수 있는 값은 시작점 1번과 연결된 간선들 뿐임
         *       - M번의 loop를 돌리는 이유
         *           - if (모든 정점들이 일렬로 연결된 그래프 ㅇ-ㅇ-ㅇ-ㅇ 의 형태라면) -> M번 검사해야 최댓값 도출 가능
         *           - if (1의 차수가 N-1이고 모든 정점들과 1이 연결된 경우) -> 첫번째 루프에서 최단경로를 도출할 수 있음
         *           - 우리는 최악의 경우를 가정하고 M번의 루프를 실행
         * */
        for (int i = 0; i < M; i++) {
            for (Edge edge : edges) {
                long acc = dist[edge.s] + edge.w;
                /*
                 *
                 *  (dist[edge.s] != Integer.MAX_VALUE) 의 의미?
                 *  우리는 현재 시작점 1번에서부터 경로를 순차적으로 탐색하고 있음
                 *  이 과정에서 아직 도달하지 못한 정점(dist배열이 INF값을 가진 인덱스 값)의 경로를 미리 탐색해 버린다면
                 *  정점간의 연결 여부를 무시하게 되어버린다
                 *
                 *   해당 반례:
                 *   3 2
                 *   2 3 -1
                 *   3 2 -2
                 *
                 *   답:
                 *   -1
                 *   -1
                 *
                 *   정점들간의 연결 여부를 확인하기 위해서는 해당 코드가 필수다.
                 * */
                if (dist[edge.s] != Integer.MAX_VALUE && dist[edge.e] > acc) {
                    dist[edge.e] = acc;
                }
            }
        }

        for (Edge edge : edges) {
            long acc = dist[edge.s] + edge.w;
            if (dist[edge.s] != Integer.MAX_VALUE && dist[edge.e] > acc) {
                return new long[]{-1};
            }
        }

        return Arrays.copyOfRange(dist, 2, N+1);
    }

    static class Edge {
        int s, e, w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
