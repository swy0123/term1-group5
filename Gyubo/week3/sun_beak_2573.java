import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sun_beak_2573 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int iceSegment = checkIceSegment(table);
            if (iceSegment == 0) {
                System.out.println(0);
                return;
            } else if (iceSegment > 1) {
                System.out.println(year);
                return;
            }

            // 빙산 업데이트

            int[][] mask = new int[n][m];
            year++;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    int count = 0;
                    for (int i = 0; i < move.length; i++) {
                        int ny = move[i][0] + y;
                        int nx = move[i][1] + x;

                        // 테이블을 벗어나는지 확인
                        if (ny >= table.length || ny < 0 || nx >= table[0].length || nx < 0) {
                            continue;
                        }

                        if (table[ny][nx] == 0) {
                            count++;
                        }
                    }
                    mask[y][x] = count;
                }
            }

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    table[i][j] -= mask[i][j];
                    if (table[i][j] < 0) {
                        table[i][j] = 0;
                    }
                }
            }
        }
    }

    private static int checkIceSegment(int[][] table) {
        // 분리되었으면 false
        // 아니라면 true
        boolean[][] visited = new boolean[table.length][table[0].length];

        int count = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 0) {
                    continue;
                }
                if (visited[i][j]) {
                    continue;
                }
                count++;
                dfs(table, visited, i, j);
            }
        }
        return count;
    }

    private static void dfs(int[][] table, boolean[][] visited, int y, int x) {
        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;
        for (int i = 0; i < move.length; i++) {
            int ny = move[i][0] + y;
            int nx = move[i][1] + x;

            // 테이블을 벗어나는지 확인
            if (ny >= table.length || ny < 0 || nx >= table[0].length || nx < 0) {
                continue;
            }
            if (table[ny][nx] == 0) {
                continue;
            }
            dfs(table, visited, ny, nx);
        }
    }
}
