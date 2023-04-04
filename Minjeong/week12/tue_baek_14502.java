import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소
public class tue_baek_14502 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, res;
    static int[][] arr, del = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        installWall(0, new boolean[n][m]);
        System.out.println(res);
    }

    private static void installWall(int cnt, boolean[][] v) {
        if (cnt == 3) {
            int[][] tmp = new int[n][m];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = arr[i].clone();
            }

            res = Math.max(res, findSafeArea(tmp));
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && arr[i][j] == 0) {
                    v[i][j] = true;
                    arr[i][j] = 1;
                    installWall(cnt + 1, v);
                    v[i][j] = false;
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static int findSafeArea(int[][] tmp) {
        boolean[][] v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && tmp[i][j] == 2) bfs(i, j, tmp, v);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    private static void bfs(int x, int y, int[][] tmp, boolean[][] v) {
        Queue<Node> q = new ArrayDeque<>();
        v[x][y] = true;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + del[i][0];
                int ny = cur.y + del[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || v[nx][ny]) continue;
                if (tmp[nx][ny] != 1) {
                    v[nx][ny] = true;
                    tmp[nx][ny] = 2;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
}