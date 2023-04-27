import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점프왕 쩰리 (Small)
public class thu_baek_16173 {
    static int[][] del = {{0, 1}, {1, 0}};
    static int n;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, 0, 0, new boolean[n][n]);
        if (flag) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }

    private static void dfs(int[][] map, int x, int y, boolean[][] v) {
        if (flag) return;
        if (x < 0 || x >= n || y < 0 || y >= n) return;
        if (x == n - 1 && y == n - 1) {
            flag = true;
            return;
        }
        if (v[x][y]) return;
        v[x][y] = true;
        dfs(map, x + del[0][0] * map[x][y], y + del[0][1] * map[x][y], v);
        dfs(map, x + del[1][0] * map[x][y], y + del[1][1] * map[x][y], v);
        v[x][y] = false;
    }
}