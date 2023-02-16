import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

// 아기 상어
public class thu_beak_16236 {

    static class Point implements Comparable<Point> {

        public int y;
        public int x;
        public int depth;

        public Point(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }

        @Override
        public int compareTo(Point p) {
            if (this.y == p.y) {
                return this.x - p.x;
            }
            return this.y - p.y;
        }
    }

    static class Shark {

        public int level;
        public int feedCount;
        public int y;
        public int x;
        public int time;

        public Shark(int y, int x) {
            super();
            this.y = y;
            this.x = x;
            this.level = 2;
            this.feedCount = 0;
            this.time = 0;
        }

        public void update(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time += time;
            feedCount++;
            if (this.level == this.feedCount) {
                this.level++;
                this.feedCount = 0;
            }
        }
    }

    private static final int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static boolean bfsFlag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] table = new int[n][n];

        Shark shark = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 9) {
                    shark = new Shark(i, j);
                } else {
                    table[i][j] = input;
                }
            }
        }

        while (bfsFlag) {
            bfs(table, shark, new boolean[table.length][table[0].length]);
        }
        System.out.println(shark.time);
    }

    private static void bfs(int[][] table, Shark shark, boolean[][] visited) {
        Deque<Point> q = new ArrayDeque<>();
        q.add(new Point(shark.y, shark.x, 0));
        visited[shark.y][shark.x] = true;
        int endDepth = Integer.MAX_VALUE;
        List<Point> canMovePoints = new ArrayList<>();

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.depth >= endDepth) {
                continue;
            }

            for (int[] vector : move) {
                int ny = p.y + vector[0];
                int nx = p.x + vector[1];

                // 범위를 벗어나면 out
                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }
                // 상어 몸보다 큰 물고기면 out
                if (table[ny][nx] > shark.level) {
                    continue;
                }
                // 이미 탐색한 곳이면 out
                if (visited[ny][nx]) {
                    continue;
                }
                visited[ny][nx] = true;
                // 상어가 먹을수 있는 먹이가 나온다면 go
                if (table[ny][nx] < shark.level && table[ny][nx] != 0) {
                    canMovePoints.add(new Point(ny, nx, p.depth + 1));
                    endDepth = p.depth + 1;
                }
                // 그렇지 않다면
                q.add(new Point(ny, nx, p.depth + 1));
            }
        }
        if (canMovePoints.isEmpty()) {
            bfsFlag = false;
            return;
        }
        Point targetPoint = Collections.min(canMovePoints);
        table[targetPoint.y][targetPoint.x] = 0;
        table[shark.y][shark.x] = 0;
        shark.update(targetPoint.y, targetPoint.x, targetPoint.depth);
    }
}
