import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 등산로 조성
public class wed_swea_1949 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < testCase + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] table = new int[n][n];
            int highest = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    highest = Math.max(highest, input);
                    table[i][j] = input;
                }
            }
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (table[i][j] == highest) {
                        boolean[][] visited = new boolean[n][n];
                        visited[i][j] = true;
                        maxValue = Math.max(dfs(table, visited, i, j, k, 1, true), maxValue);
                    }
                }
            }
            System.out.println("#" + tc + " " + maxValue);
        }
    }

    private static int dfs(int[][] table, boolean[][] visited, int y, int x, int k, int depth, boolean chance) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < move.length; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];

            if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            if (table[ny][nx] >= table[y][x]) {
                if (chance) {
                    for (int j = 1; j <= k; j++) {
                        if (table[ny][nx] - j < table[y][x]) {
                            chance = false;
                            visited[ny][nx] = true;
                            table[ny][nx] -= j;
                            maxValue = Math.max(dfs(table, visited, ny, nx, k, depth + 1, chance), maxValue);
                            chance = true;
                            visited[ny][nx] = false;
                            table[ny][nx] += j;
                        }
                    }

                } else {
                    continue;
                }
            } else {
                visited[ny][nx] = true;
                maxValue = Math.max(dfs(table, visited, ny, nx, k, depth + 1, chance), maxValue);
                visited[ny][nx] = false;
            }
        }

        return Math.max(depth, maxValue);
    }
}
