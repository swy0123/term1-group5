import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 파이프 옮기기 1
public class mon_baek_17070 {
    static int[][] map, del = { {0, 1}, {1, 0}, {1, 1} };
    static int[][][] res;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        res = new int[n][n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(res[i][j], -1);
            }
        }

        System.out.println(dfs(0, 1, 0));
    }

    private static int dfs(int x, int y, int k) {
        if (x == n - 1 && y == n - 1) return 1;

        if (res[x][y][k] != -1) return res[x][y][k];
        res[x][y][k] = 0;
        for (int i = 0; i < 3; i++) {
            if (k == 0 && i == 1) continue;
            else if (k == 1 && i == 0) continue;
            int nx = x + del[i][0];
            int ny = y + del[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] == 1) continue;
            if (i == 2 && (map[x + 1][y] == 1 || map[x][y + 1] == 1)) continue;
            res[x][y][k] += dfs(nx, ny, i);
        }
        return res[x][y][k];
    }
}