import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

// 오! 나의 여신님
public class wed_swea_7793 {

    static class Point {

        public int y;
        public int x;
        public int depth;
        public boolean isUser;

        public Point(int y, int x, int depth, boolean isUser) {
            this.y = y;
            this.x = x;
            this.depth = depth;
            this.isUser = isUser;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    ", depth=" + depth +
                    ", isUser='" + isUser + '\'' +
                    '}';
        }
    }


    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < testCase + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] table = new char[n][m];

            List<Point> devilLoc = new ArrayList<>();
            Point user = null;

            for (int i = 0; i < n; i++) {
                String readLine = br.readLine();
                for (int j = 0; j < m; j++) {
                    char input = readLine.charAt(j);
                    table[i][j] = input;
                    if (input == '*') {
                        devilLoc.add(new Point(i, j, 0, false));
                    }
                    if (input == 'S') {
                        user = new Point(i, j, 0, true);
                    }
                }
            }
            System.out.println("#" + tc + " " + bfs(table, devilLoc, user));
        }
    }

    private static String bfs(char[][] table, List<Point> devilLoc, Point user) {
        Deque<Point> q = new ArrayDeque<>();
        q.add(user);
        q.addAll(devilLoc);

        while (!q.isEmpty()) {
            Point p = q.pollFirst();

            // 유저일 경우
            if (p.isUser) {
                if (table[p.y][p.x] == '*') {
                    continue;
                }
                for (int i = 0; i < move.length; i++) {
                    int ny = p.y + move[i][0];
                    int nx = p.x + move[i][1];

                    if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                        continue;
                    }
                    if (table[ny][nx] == '*' || table[ny][nx] == 'S' || table[ny][nx] == 'X') {
                        continue;
                    }
                    if (table[ny][nx] == 'D') {
                        return p.depth + 1 + "";
                    }
                    table[ny][nx] = 'S';
                    q.add(new Point(ny, nx, p.depth + 1, true));
                }
            }
            // 악마일 경우
            else {
                for (int i = 0; i < move.length; i++) {
                    int ny = p.y + move[i][0];
                    int nx = p.x + move[i][1];

                    if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                        continue;
                    }
                    if (table[ny][nx] == '*' || table[ny][nx] == 'X' || table[ny][nx] == 'D') {
                        continue;
                    }
                    table[ny][nx] = '*';
                    q.add(new Point(ny, nx, 0, false));
                }
            }
        }
        return "GAME OVER";
    }
}