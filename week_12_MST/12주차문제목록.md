## 이번주의 알고리즘: 최소 신장 트리 (Minimum Spanning Tree)
- `신장 트리`: 그래프 상에서 모든 노드가 사이클 없이 연결된 무방향 그래프
- 최소 신장 트리: 간선들의 `가중치의 합`이 `최소`인 신장 트리
- 가중치가 가장 작은 간선부터 `greedy`하게 선택

<br>

### 크루스칼 알고리즘
1. 특징
- `union-find`를 사용하여 사이클 여부를 체크
    - 트리는 사이클이 없이 모든 정점이 `V-1`개의 간선으로 연결되어있는 그래프
    - 간선이 `V-1`개를 초과하는 순간 사이클이 발생하며 트리의 정의를 위반하게 됨 

<br>

2. 시간 복잡도
- `O(ElogV)`
- E == Edge (간선), V == Vertex (정점)
- 간선의 수 * 모든 가중치 정렬에 걸리는 시간
    - `ElogE` == `ElogV^2` == `E2logV` == `ElogV`
- 간선의 개수가 많으면 정렬에 많은 시간이 소요된다

<br>

```java
static class Edge implements Comparable<Edge> {
    int from, to, weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}


public class Main {
    static Edge[] edgeList;
    static int V, E;
    static int[] parents;
    
    static void makeSet() {
        parents = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        // 사이클 발생하면 false 반환
        if (x == y) return false;

        // 사이클이 없다면 union 후 true 반환
        parents[y] = parents[x];
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new Edge[E];

        // 간선 리스트 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }

        // 간선리스트를 가중치 기준 오름차순 정렬
        Arrays.sort(edgeList);

        // V개의 정점으로 make-set 작업 진행
        makeSet();

        int totalCost = 0; // MST 비용
        int EdgeCnt = 0; // 연결된 간선수

        // 비용이 작은 간선순서대로 꺼내어 처리 진행
        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                totalCost += edge.weight;

                // MST가 완성 되었다면 더이상 불필요한 연산 수행하지 않고 break
                // 이 코드가 없으면 MST 완성 후에도 탈락한 간선들을 계속해서 방문체크
                if (++EdgeCnt == V - 1) break;
            }
        }

        System.out.println(totalCost);
    }
}
```

<br>
<br>



### 프림 알고리즘
1. 특징
- 크루스칼과 같은 로직으로 전개되나 이미 만들어진 트리에 `인접`한 간선만 고려한다는 점이 조금 다름
- 시작 정점을 `우선순위 큐`에 포함
- `인접`한 정점들 중 최소 가중치로 연결된 정점을 선택, `V-1`개의 간선을 가질 때까지 이를 반복

<br>

2. 시간복잡도
- 우선순위 큐를 사용하면 크루스칼과 마찬가지로 `O(ElogV)`
- 인접 행렬을 사용하면 `O(V^2)`

<br>

```java
static int V;
static int total;
static List<Edge>[] adjl;
static boolean[] visited;

class Edge implements Comparable<Edge> {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

static int prim(int start) {
    Queue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(start, 0));

    boolean[] MST = new boolean[V + 1];
    int totalCost = 0;

    while (!pq.isEmpty()) {
        Edge curr = pq.poll();
        int next = curr.to;
        int weight = curr.weight;

        if (MST[next]) continue;
        
        MST[next] = true;
        totalCost += weight;

        for (Edge nextNode : adjl[next]) {
            if (!MST[nextNode.to]) {
                pq.add(nextNode);
            }
        }
    }
    
    return totalCost;
}
```


<br>
<br>

### 크루스칼 vs 프림
- 크루스칼
    - 간선 위주 탐색 
    - 간선이 적은 희소 그래프(Sparse Graph)의 경우 적합
- 프림
    - 정점 위주 탐색
    - 간선이 많은 밀집 그래프(Dense Graph)의 경우 적합

<br>
<br>

### MST vs 다익스트라
- MST
    - `모든 정점을 연결`하는데 의의가 있다
    - 어느 정점에서 시작해도 같은 그래프를 도출
    - 두 노드 사이의 **최단거리를 보장하지 않는다**
    - 정점의 저장 값: 자신과 연결된 간선의 가중치

<br>

- 다익스트라
    - 두 정점 간의 `최단 경로`를 찾는데 의의가 있다
    - `시작점` S로부터 모든 정점까지의 최단 경로
        - 따라서 시작 정점이 바뀔 때마다 최단 경로 그래프가 다르게 도출
    - 또한 `경로`를 구하는 것이기 때문에 `누적` 값으로 가중치를 판별
    - 정점의 저장 값: 시작점으로부터의 경로

<br>
<br>




## 예시 문제

| **순번** | **문제 번호** | **문제 제목 (링크)**                                 | 난이도       | 
|--------|-----------|------------------------------------------------|-----------| 
| 1      | 1197      | [최소 스패닝 트리](https://www.acmicpc.net/problem/1197) | &nbsp; G4 |
| 2      | 1922      | [네트워크 연결](https://www.acmicpc.net/problem/1922) | &nbsp; G4 |

<br>
<br>

## 문제 목록

| **순번** | **문제 번호** | **문제 제목 (링크)**                                               | 난이도       | 
|--------|-----------|--------------------------------------------------------------|-----------| 
| 1      | 16398     | [행성 연결](https://www.acmicpc.net/problem/16398) | &nbsp; G4 |
| 2      | 21924     | [도시 건설](https://www.acmicpc.net/problem/21924)              | &nbsp; G4 |
| 3      | 1774      | [우주신과의 교감](https://www.acmicpc.net/problem/1774)                  | &nbsp; G3 |
| 4      | 14621     | [나만 안되는 연애](https://www.acmicpc.net/problem/14621)                  | &nbsp; G3 |
| 5      | 1368      | [물대기](https://www.acmicpc.net/problem/1368)              | &nbsp; G2 |

<br>
<br>

## 참고
[[Java]크루스칼 알고리즘(Kruskal Algorithm)](https://sskl660.tistory.com/72)

[[알고리즘/ 그래프] 최소 스패닝 트리 - 크루스칼(Kruskal)과 프림(Prim) 알고리즘 (Java)](https://loosie.tistory.com/159)