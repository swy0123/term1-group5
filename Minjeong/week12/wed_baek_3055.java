import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈출
public class wed_baek_3055 {
    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int r, c, res = Integer.MAX_VALUE;
    static char[][] arr;
    static int[][] del = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static Node hedgehog;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'S') {
                    hedgehog = new Node(i, j, 0);
                    arr[i][j] = '.';
                }
            }
        }

        solve();

        if (res == Integer.MAX_VALUE) System.out.println("KAKTUS");
        else System.out.println(res);
    }

    private static void solve() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(hedgehog.x, hedgehog.y, 0));
        boolean[][][] v = new boolean[r][c][4];

        while(!q.isEmpty()) {
            fillWater();
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + del[i][0];
                    int ny = cur.y + del[i][1];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    if (arr[nx][ny] == '.' && !v[nx][ny][i]) {
                        v[nx][ny][i] = true;
                        q.offer(new Node(nx, ny, cur.cnt + 1));
                    }
                    else if (arr[nx][ny] == 'D') res = Math.min(res, cur.cnt + 1);
                }
            }
        }
    }


    private static void fillWater() {
        boolean[][] v = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (v[i][j] || arr[i][j] != '*') continue;
                for (int d = 0; d < 4; d++) {
                    int nx = i + del[d][0];
                    int ny = j + del[d][1];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    if (arr[nx][ny] == '.' && !v[nx][ny]) {
                        v[nx][ny] = true;
                        arr[nx][ny] = '*';
                    }
                }
            }
        }
    }
}