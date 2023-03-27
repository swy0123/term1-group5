import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리 만들기 2
public class mon_baek_17472 {
    static class Node implements Comparable<Node> {
        int s;
        int e;
        int c;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public Node(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.c, o.c);
        }
    }
    static int n, m;
    static int[][] map, del = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<Node>[] graph;
    static int[] parents;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 라벨링
        boolean[][] v = new boolean[n][m];
        int label = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && map[i][j] == 1) {
                    bfs(v, i, j, label++);
                }
            }
        }

        // 다리 연결(크루스칼)
        graph = new List[label];
        for (int i = 1; i < label; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) calcLen(i, j);
            }
        }

        parents = new int[label];
        for (int i = 1; i < label; i++) {
            parents[i] = i;
        }

        int cnt = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!union(cur.s, cur.e)) continue;
            res += cur.c;
            cnt++;
            if (cnt == label - 2) break;
        }

        if (cnt != label - 2) System.out.println(-1);
        else System.out.println(res);
    }

    private static void bfs(boolean[][] v, int x, int y, int label) {
        Queue<Node> q = new ArrayDeque<>();
        v[x][y] = true;
        q.offer(new Node(x, y));
        map[x][y] = label;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.s + del[i][0];
                int ny = cur.e + del[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || v[nx][ny]) continue;
                if (map[nx][ny] == 1) {
                    v[nx][ny] = true;
                    map[nx][ny] = label;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    private static void calcLen(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            int len = 0;
            while(true) {
                nx += del[i][0];
                ny += del[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == map[x][y]) break;
                if (map[nx][ny] != 0) {
                    if (len > 1) pq.offer(new Node(map[x][y], map[nx][ny], len));
                    break;
                }
                len++;
            }
        }
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;
        parents[pb] = pa;
        return true;
    }
}
