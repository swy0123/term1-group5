import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정사각형 방
public class wed_swea_1861 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int maxValue;
    private static boolean flag;
    private static boolean flag2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc < testCase + 1; tc++) {
            maxValue = Integer.MIN_VALUE;
            int n = Integer.parseInt(br.readLine());
            int[][] table = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean[][] visited = new boolean[n][n];
                    visited[i][j] = true;
                    flag = false;
                    flag2 = false;
                    dfs(table, i, j, visited, 1);
                    if (flag) {
                        answer = table[i][j];
                    }
                    if (flag2) {
                        answer = Math.min(table[i][j], answer);
                    }
                }
            }

            System.out.println("#" + tc + " " + answer + " " + maxValue);
        }
    }

    private static void dfs(int[][] table, int y, int x, boolean visited[][], int depth) {
        int currentValue = table[y][x];

        for (int i = 0; i < move.length; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];

            if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            if (table[ny][nx] != currentValue + 1) {
                continue;
            }
            visited[ny][nx] = true;
            dfs(table, ny, nx, visited, depth + 1);
            visited[ny][nx] = false;
        }
        if (maxValue < depth) {
            maxValue = depth;
            flag = true;
        } else if (maxValue == depth) {
            flag2 = true;
        }
    }
}
