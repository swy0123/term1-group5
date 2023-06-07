import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

// 다리만들기
public class wed_beak_2146 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] table = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1) {
                    List<int[]> tmpList = new ArrayList<>();
                    bfs(table, i, j, tmpList);
                    list.add(tmpList);
                    for (int[] coord : tmpList) {
                        table[coord[0]][coord[1]] = 0;
                    }
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int[] coord1 : list.get(i)) {
                    for (int[] coord2 : list.get(j)) {
                        // 두 좌표간 거리차 구하기
                        int diffY = Math.abs(coord1[0] - coord2[0]);
                        int diffX = Math.abs(coord1[1] - coord2[1]);
                        int diff = diffX + diffY + 1;
                        minDiff = Math.min(diff, minDiff);
                    }
                }
            }
        }
        System.out.println(minDiff);
    }

    // 탐색한것은 2로
    private static void bfs(int[][] table, int y, int x, List<int[]> list) {
        Deque<int[]> q = new ArrayDeque<>();
        table[y][x] = 2;
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int cy = p[0];
            int cx = p[1];

            for (int[] m : move) {
                int ny = cy + m[0];
                int nx = cx + m[1];

                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }
                if (table[ny][nx] == 1) {
                    q.add(new int[]{ny, nx});
                    table[ny][nx] = 2;
                }
                if (table[ny][nx] == 0) {
                    table[ny][nx] = -1;
                    list.add(new int[]{ny, nx});
                }
            }
        }
    }
}
