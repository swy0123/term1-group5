import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 미로 탈출
public class sun_beak_14923 {

    static class Point {

        public int y;
        public int x;
        public int depth;
        public int chance;

        public Point(int y, int x, int depth, int chance) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.chance = chance;
        }
    }


    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int hy = Integer.parseInt(st.nextToken());
        int hx = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int[][] table = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(n, m, hx, hy, ex, ey, table);
        System.out.println(-1);
    }

    private static void bfs(int n, int m, int hx, int hy, int ex, int ey, int[][] table) {
        Deque<Point> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[2][n + 1][m + 1];
        visited[0][hy][hx] = true;
        q.add(new Point(hy, hx, 0, 1));

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.y == ey && p.x == ex) {
                System.out.println(p.depth);
                System.exit(0);
            }

            for (int[] ints : move) {
                int ny = p.y + ints[0];
                int nx = p.x + ints[1];

                if (ny < 1 || nx < 1 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }

                // 벽을 만난 경우
                if (table[ny][nx] == 1) {
                    // 찬스가 없다면
                    if (p.chance == 0) {
                        continue;
                    }
                    // 찬스가 있다면
                    if (!visited[p.chance - 1][ny][nx]) {
                        q.add(new Point(ny, nx, p.depth + 1, p.chance - 1));
                    }
                }

                // 벽을 만나지 않은 경우
                if (table[ny][nx] == 0) {
                    if (!visited[p.chance][ny][nx]) {
                        visited[p.chance][ny][nx] = true;
                        q.add(new Point(ny, nx, p.depth + 1, p.chance));
                    }
                }
            }
        }
    }


    private static void print(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
