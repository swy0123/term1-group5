import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 레이저 통신
public class sat_baek_6087 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int d;
        int cnt;

        public Node(int x, int y, int d, int cnt) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }
    static int[][] del = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[] x = new int[2], y = new int[2];
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        map = new char[h][w];

        int idx = 0;
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'C') {
                    x[idx] = i;
                    y[idx++] = j;
                }
            }
        }

        System.out.println(bfs(w, h));
    }

    private static int bfs(int w, int h) {
        boolean[][][] v = new boolean[h][w][4];
        int[][] cost = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(x[0], y[0], -1, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                if (i != cur.d && (i % 2 == cur.d % 2)) continue;
                int nx = cur.x + del[i][0];
                int ny = cur.y + del[i][1];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '*') continue;
                int nd = cur.d;
                int ncnt = cur.cnt;
                if (i != nd) {
                    nd = i;
                    if (cur.d != -1) ncnt += 1;
                }

                if (cost[nx][ny] == ncnt && v[nx][ny][nd]) continue;
                if (cost[nx][ny] >= ncnt) {
                    cost[nx][ny] = ncnt;
                    v[nx][ny][nd] = true;
                    q.offer(new Node(nx, ny, nd, ncnt));
                }
            }
        }

        return cost[x[1]][y[1]];
    }
}