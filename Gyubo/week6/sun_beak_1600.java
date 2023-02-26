import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class sun_beak_1600 {

    static class Monkey {

        public int y;
        public int x;
        public int depth;
        public int chance;

        public Monkey(int y, int x, int depth, int chance) {
            this.y = y;
            this.x = x;
            this.depth = depth;
            this.chance = chance;
        }
    }

    private static final int[][] horseMove = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    private static final int[][] monkeyMove = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] table = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(k, w, h, table);
        System.out.println(-1);
    }

    private static void bfs(int k, int w, int h, int[][] table) {
        Deque<Monkey> q = new ArrayDeque<>();
        q.add(new Monkey(0, 0, 0, k));
        boolean[][][] visited = new boolean[k + 1][h][w];

        while (!q.isEmpty()) {
            Monkey monkey = q.pop();

            if (monkey.y == h - 1 && monkey.x == w - 1) {
                System.out.println(monkey.depth);
                System.exit(0);
            }

            // 원숭이 점프
            for (int[] ints : monkeyMove) {
                int ny = monkey.y + ints[0];
                int nx = monkey.x + ints[1];

                if (canMove(table, ny, nx)) {
                    continue;
                }
                if (!visited[monkey.chance][ny][nx]) {
                    q.add(new Monkey(ny, nx, monkey.depth + 1, monkey.chance));
                    visited[monkey.chance][ny][nx] = true;
                }
            }

            // 말 점프를 할 수 있는 경우
            if (monkey.chance != 0) {
                // 말 점프
                for (int[] ints : horseMove) {
                    int ny = monkey.y + ints[0];
                    int nx = monkey.x + ints[1];

                    if (canMove(table, ny, nx)) {
                        continue;
                    }

                    if (!visited[monkey.chance - 1][ny][nx]) {
                        visited[monkey.chance - 1][ny][nx] = true;
                        q.add(new Monkey(ny, nx, monkey.depth + 1, monkey.chance - 1));
                    }
                }
            }
        }
    }

    private static boolean canMove(int[][] table, int ny, int nx) {
        if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
            return true;
        }
        return table[ny][nx] == 1;
    }
}
