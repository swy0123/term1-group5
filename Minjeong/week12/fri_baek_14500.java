import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fri_baek_14500 {
    static int[][] paper, del = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    static boolean[][] v;
    static int n, m, maxSum;

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
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxSum = Math.max(maxSum, getSum(i, j));
                dfs(i, j, 0, paper[i][j]);
            }
        }

        System.out.println(maxSum);
    }

    private static int getSum(int x, int y) {
        int max = 0;

        if (x + 1 < n && x + 2 < n && y + 1 < m) {
            max = Math.max(max, paper[x][y] + paper[x + 1][y] + paper[x + 2][y] + paper[x + 1][y + 1]);
            max = Math.max(max, paper[x][y + 1] + paper[x + 1][y + 1] + paper[x + 2][y + 1] + paper[x + 1][y]);
        }
        if (y + 1 < m && y + 2 < m && x + 1 < n) {
            max = Math.max(max, paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x + 1][y + 1]);
            max = Math.max(max, paper[x + 1][y] + paper[x + 1][y + 1] + paper[x + 1][y + 2] + paper[x][y + 1]);
        }

        return max;
    }

    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 3) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        v[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + del[i][0];
            int ny = y + del[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (v[nx][ny]) continue;
            dfs(nx, ny, depth + 1, sum + paper[nx][ny]);
        }

        v[x][y] = false;
    }
}