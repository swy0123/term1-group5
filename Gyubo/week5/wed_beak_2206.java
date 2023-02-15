import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
class Table {

    public int value;
    public boolean chance;

    public Table(int value, boolean chance) {
        super();
        this.value = value;
        this.chance = chance;
    }
}

class Point {

    public int y;
    public int x;
    public int depth;
    public boolean chance;

    public Point(int y, int x, int depth, boolean chance) {
        super();
        this.y = y;
        this.x = x;
        this.depth = depth;
        this.chance = chance;
    }
}

public class wed_beak_2206 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Table[][] table = new Table[n][m];
        for (int i = 0; i < n; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < m; j++) {
                table[i][j] = new Table(Character.getNumericValue(readLine.charAt(j)), false);
            }
        }

        bfs(table, new Point(0, 0, 0, true));
        System.out.println(-1);
    }

    private static void bfs(Table[][] table, Point point) {
        Deque<Point> q = new ArrayDeque<>();
        q.add(point);

        table[point.y][point.x].value = 2;
        table[point.y][point.x].chance = point.chance;

        int maxValue = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.chance && !table[p.y][p.x].chance) {
                continue;
            }

            maxValue = Math.max(p.depth, maxValue);
            if (p.y == table.length - 1 && p.x == table[0].length - 1) {
                System.out.println(maxValue + 1);
                System.exit(0);
            }
            for (int[] ints : move) {
                int ny = ints[0] + p.y;
                int nx = ints[1] + p.x;
                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }

                if (table[ny][nx].value == 0) {
                    table[ny][nx].value = 2;
                    table[ny][nx].chance = p.chance;
                    q.add(new Point(ny, nx, p.depth + 1, p.chance));
                } else if (table[ny][nx].value == 1 && p.chance) {
                    q.add(new Point(ny, nx, p.depth + 1, false));
                } else if (table[ny][nx].value == 2) {
                    if (!table[ny][nx].chance && p.chance) {
                        table[ny][nx].chance = p.chance;
                        q.add(new Point(ny, nx, p.depth + 1, p.chance));
                    }
                }
            }
        }
    }
}
