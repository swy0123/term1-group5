import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 달이 차오른다, 가자.
public class wed_baek_1194 {
    static class Node {
        int x;
        int y;
        int cnt;
        int keys;

        public Node(int x, int y, int cnt, int keys) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.keys = keys;
        }
    }
    static int[][] del = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n, m;
    static char[][] miro;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new char[n][m];
        int sx = -1, sy = -1;
        for (int i = 0; i < n; i++) {
            miro[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (miro[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
            }
        }

        int res = bfs(sx, sy);
        if (res == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(res);
    }

    private static int bfs(int sx, int sy) {
        boolean[][][] v = new boolean[n][m][1 << 6];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sx, sy, 0, 0));
        int res = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.cnt > res) continue;
            if (miro[cur.x][cur.y] == '1') res = cur.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + del[i][0];
                int ny = cur.y + del[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m
                        || v[nx][ny][cur.keys] || miro[nx][ny] == '#') continue;
                v[nx][ny][cur.keys] = true;

                if (miro[nx][ny] >= 'A' && miro[nx][ny] <= 'F') {
                    if ((cur.keys & (1 << (miro[nx][ny] - 'A'))) > 0) {
                        q.offer(new Node(nx, ny, cur.cnt + 1, cur.keys));
                    }
                }
                else if (miro[nx][ny] >= 'a' && miro[nx][ny] <= 'f') {
                    q.offer(new Node(nx, ny, cur.cnt + 1, cur.keys | 1 << (miro[nx][ny] - 'a')));
                }
                else {
                    q.offer(new Node(nx, ny, cur.cnt + 1, cur.keys));
                }
            }
        }

        return res;
    }
}