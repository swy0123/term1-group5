import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 등산
public class sat_beak_1486 {

    static class Vertex {

        int e;
        int cost;

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
    private static final int[][] vector = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // int 배열로 그래프 만들기
        int[][] table = new int[n][m];

        for (int i = 0; i < n; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < m; j++) {
                char charAt = readLine.charAt(j);
                if (Character.isLowerCase(charAt)) {
                    table[i][j] = (int) (charAt - 'a') + 26;
                } else {
                    table[i][j] = (int) (charAt - 'A');
                }
            }
        }

        // 그래프 생성
        Map<Integer, List<Vertex>> graph = new HashMap<>();
        for (int i = 0; i < n * m; i++) {
            graph.put(i, new ArrayList<>());
        }

        int y = 0;
        int x = 0;
        for (int i = 0; i < n * m; i++) {
            if (x == m) {
                y++;
                x = 0;
            }

            for (int j = 0; j < vector.length; j++) {
                int ny = y + vector[j][0];
                int nx = x + vector[j][1];

                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }

                int diff = table[y][x] - table[ny][nx];
                if (Math.abs(diff) > t) {
                    continue;
                }
                int cost;
                if (table[y][x] >= table[ny][nx]) {
                    cost = 1;
                } else {
                    cost = diff * diff;
                }
                int idx = ny * m + nx;
                graph.get(i).add(new Vertex(idx, cost));
            }
            x++;
        }

        // 플로이드 알고리즘 진행
        int len = n * m;
        int[][] dist = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            List<Vertex> list = graph.get(i);
            for (Vertex vertex : list) {
                dist[i][vertex.e] = vertex.cost;
            }
        }

        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        int answer = table[0][0];
        for (int i = 1; i < len; i++) {
            if (dist[0][i] + dist[i][0] <= d) {
                answer = Math.max(answer, table[i / m][i % m]);
            }
        }

        System.out.println(answer);
    }
}
