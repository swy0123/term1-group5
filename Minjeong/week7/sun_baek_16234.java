import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class sun_baek_16234 {
    private static int n, l, r;
    private static int[][] map, del = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            // bfs로 국경선을 여는 도시끼리 라벨링(열린 국경선이 하나도 없으면 루프 종료)
            int[][] label = new int[n][n];
            boolean[][] v = new boolean[n][n];
            int idx = 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j]) {
                        int polulation = bfs(i, j, label, idx, v);
                        mark(polulation, idx++, label);
                        cnt++;
                    }
                }
            }
            if (cnt == n * n) break;
            days++;
        }
        System.out.println(days);
    }

    private static int bfs(int sx, int sy, int[][] label, int idx, boolean[][] v) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(sx, sy));
        v[sx][sy] = true;
        label[sx][sy] = idx;
        int total = map[sx][sy];
        int cnt = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + del[i][0];
                int ny = cur.y + del[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny]) continue;
                int gap = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
                if (gap >= l && gap <= r) {
                    v[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                    label[nx][ny] = idx;
                    total += map[nx][ny];
                    cnt++;
                }
            }
        }

        return total / cnt;
    }

    private static void mark(int polulation, int idx, int[][] label) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (label[i][j] == idx) map[i][j] = polulation;
            }
        }
    }
}
