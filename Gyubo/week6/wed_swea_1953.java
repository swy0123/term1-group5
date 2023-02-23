import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 탈주범 검거
public class wed_swea_1953 {

    static class Point {

        public int y;
        public int x;
        public int depth;

        public Point(int y, int x, int depth) {
            super();
            this.y = y;
            this.x = x;
            this.depth = depth;
        }

    }

    private static Map<Integer, int[][]> map;
    private static int answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        map.put(1, new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}});
        map.put(2, new int[][]{{-1, 0}, {1, 0}});
        map.put(3, new int[][]{{0, 1}, {0, -1}});
        map.put(4, new int[][]{{-1, 0}, {0, 1}});
        map.put(5, new int[][]{{0, 1}, {1, 0}});
        map.put(6, new int[][]{{1, 0}, {0, -1}});
        map.put(7, new int[][]{{-1, 0}, {0, -1}});

        for (int tc = 1; tc < testCase + 1; tc++) {
            answer = 1;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[][] table = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(r, c, l, table, new boolean[n][m]);
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void bfs(int r, int c, int l, int[][] table, boolean[][] visited) {
        Deque<Point> q = new ArrayDeque<>();
        q.add(new Point(r, c, 0));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Point p = q.pollFirst();
            if (p.depth == l - 1) {
                continue;
            }

            int currentCommand = table[p.y][p.x];

            int[][] move = map.get(currentCommand);

            for (int i = 0; i < move.length; i++) {
                int ny = p.y + move[i][0];
                int nx = p.x + move[i][1];
                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (table[ny][nx] == 0) {
                    continue;
                }
                if (!checkRoad(table, p.y, p.x, ny, nx)) {
                    continue;
                }
                answer++;
                visited[ny][nx] = true;
                q.add(new Point(ny, nx, p.depth + 1));
            }
        }
    }

    private static boolean checkRoad(int[][] table, int y, int x, int ny, int nx) {
        int currentCommand = table[ny][nx];
        int[][] move = map.get(currentCommand);
        for (int i = 0; i < move.length; i++) {
            int nny = ny + move[i][0];
            int nnx = nx + move[i][1];

            if (nny == y && nnx == x) {
                return true;
            }
        }

        return false;

    }
}
