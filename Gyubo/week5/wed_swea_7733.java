import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 치즈도둑
public class wed_swea_7733 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc < testCase + 1; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] table = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int maxCount = Integer.MIN_VALUE;
            for (int k = 0; k <= 100; k++) {
                boolean[][] visited = new boolean[n][n];
                int count = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (table[i][j] > k && !visited[i][j]) {
                            count++;
                            bfs(table, visited, i, j, k);
                        }
                    }
                }
                maxCount = Math.max(maxCount, count);
            }

            System.out.println("#" + tc + " " + maxCount);
        }
    }

    private static void bfs(int[][] table, boolean[][] visited, int y, int x, int day) {
        Deque<int[]> q = new ArrayDeque<int[]>();

        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int cy = p[0];
            int cx = p[1];

            for (int i = 0; i < move.length; i++) {
                int ny = cy + move[i][0];
                int nx = cx + move[i][1];

                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (table[ny][nx] <= day) {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
    }
}
