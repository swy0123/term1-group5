import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 등산
public class sun_baek_1486 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.t, o.t);
        }
    }
    static int[][] del = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int n, m, t, d;
    static int[][] map, time1, time2;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - 'A';
                if (s.charAt(j) >= 'a') map[i][j] -= 6;
            }
        }
        time1 = new int[n][m];
        time2 = new int[n][m];

        int max = 0;
        dijkstra(time1, 0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dijkstra(time2, i, j);
                if (time1[i][j] + time2[0][0] <= d) {
                    max = Math.max(max, map[i][j]);
                }
            }
        }

        System.out.println(max);
    }

    private static void dijkstra(int[][] time, int x, int y) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE / 2);
        }
        time[x][y] = 0;
        pq.offer(new Node(x, y, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + del[i][0];
                int ny = cur.y + del[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int gap = map[cur.x][cur.y] - map[nx][ny];
                if (Math.abs(gap) > t) continue;
                int nt = cur.t;
                if (gap < 0) nt += (int)Math.pow(gap, 2);
                else nt++;
                if (time[nx][ny] <= nt) continue;
                if (nt <= d) {
                    time[nx][ny] = nt;
                    pq.offer(new Node(nx, ny, nt));
                }
            }
        }
    }
}
