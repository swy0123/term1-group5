import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 서강그라운드
public class tue_beak_14938 {

    static class Vertex {

        private int e;
        private int cost;

        public Vertex(int e, int cost) {
            super();
            this.e = e;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Vertex [e=" + e + ", cost=" + cost + "]";
        }

    }

    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] map = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, List<Vertex>> graph = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(node1).add(new Vertex(node2, cost));
            graph.get(node2).add(new Vertex(node1, cost));
        }

        // 2차원 배열 만들기
        // 자기자신은 0 아닌곳은 INF 값으로 계산
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        // graph의 값으로 배열 채우기
        for (int i = 1; i < n + 1; i++) {
            List<Vertex> nexts = graph.get(i);
            for (Vertex vertex : nexts) {
                dist[i][vertex.e] = vertex.cost;
            }
        }

        // 거쳐가는것 생각해서 배열 체ㅐ우기
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            int tmpSum = 0;
            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] <= m) {
                    tmpSum += map[j];
                }
            }
            answer = Math.max(tmpSum, answer);
        }
        System.out.println(answer);
    }
}
