import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fri_baek_15660 {
    static int[][] paper, del = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    static boolean[][] v;
    static int n, m, maxSum, maxVal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                maxVal = Math.max(maxVal, paper[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                v[i][j] = true;
                dfs(i, j, 1, paper[i][j], false);
                v[i][j] = false;
            }
        }

        System.out.println(maxSum);
    }

    private static void dfs(int x, int y, int depth, int sum, boolean flag) {
        int tmpCnt = depth;
        if (flag) tmpCnt += 4;
        if (maxSum > sum + (8 - tmpCnt) * maxVal) return;

        if (depth == 4 && flag) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        if (depth == 4 && !flag) {
            for (int i = x; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!v[i][j]) {
                        v[i][j] = true;
                        dfs(i, j, 1, sum + paper[i][j], !flag);
                        v[i][j] = false;
                    }
                }
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + del[d][0];
            int ny = y + del[d][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || v[nx][ny]) continue;
            if (depth == 2) {
                v[nx][ny] = true;
                dfs(x, y, depth + 1, sum + paper[nx][ny], flag);
                v[nx][ny] = false;
            }
            v[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + paper[nx][ny], flag);
            v[nx][ny] = false;
        }
    }
}