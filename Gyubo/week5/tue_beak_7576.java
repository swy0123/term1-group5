import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class tue_beak_7576 {

    private static final List<int[]> list = new ArrayList<>();
    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                table[i][j] = input;
                if (input == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        int result = bfs(list, table);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (table[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs(List<int[]> list, int[][] table) {

        Deque<int[]> q = new ArrayDeque<int[]>();
        for (int[] coord : list) {
            q.add(new int[]{coord[0], coord[1], 0});
        }

        int maxDepth = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int[] currentInfo = q.poll();
            int cy = currentInfo[0];
            int cx = currentInfo[1];
            int cDepth = currentInfo[2];

            if (table[cy][cx] == 2) {
                continue;
            }
            table[cy][cx] = 2;
            maxDepth = Math.max(maxDepth, cDepth);

            for (int i = 0; i < move.length; i++) {
                int ny = cy + move[i][0];
                int nx = cx + move[i][1];

                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }

                if (table[ny][nx] == -1) {
                    continue;
                }

                q.add(new int[]{ny, nx, cDepth + 1});
            }
        }
        return maxDepth;
    }
}
