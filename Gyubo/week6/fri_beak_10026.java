import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 적록색맹
public class fri_beak_10026 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] table = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                table[i][j] = input.charAt(j);
            }
        }

        int normalCount = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                bfs(table, visited, i, j);
                normalCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 'R') {
                    table[i][j] = 'G';
                }
            }
        }

        int abnormalCount = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                bfs(table, visited, i, j);
                abnormalCount++;
            }
        }

        System.out.println(normalCount + " " + abnormalCount);
    }

    private static void bfs(char[][] table, boolean[][] visited, int y, int x) {
        visited[y][x] = true;
        Deque<int[]> q = new ArrayDeque<>();
        char currentChar = table[y][x];
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int[] d : move) {
                int ny = p[0] + d[0];
                int nx = p[1] + d[1];

                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (table[ny][nx] == currentChar) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
