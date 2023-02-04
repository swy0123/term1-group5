import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static final int[][] del = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    static int[][] map = new int[501][501];
    static int[][] res = new int[501][501];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                res[i][j] = -1;
            }
        }

        System.out.println(dfs(m - 1, n - 1));
    }

    private static int dfs(int x, int y) {
        if (res[x][y] != -1) return res[x][y];
        if (x == 0 && y == 0) return 1;

        res[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + del[i][0], ny = y + del[i][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (map[x][y] < map[nx][ny]) res[x][y] += dfs(nx, ny);
        }
        return res[x][y];
    }
}