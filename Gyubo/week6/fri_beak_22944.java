import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 죽음의 비
// **우산을 잡으면 모든 곳을 다시 탐색할 수 있다.** -> 새로운 방문배열을 Q에 넣어서 진행
public class fri_beak_22944 {

    static class User {

        public int y;
        public int x;
        public int depth;
        public int life;
        public int durability;
        public int umbrella;

        public User(int y, int x, int depth, int life, int durability, int umbrella) {
            super();
            this.y = y;
            this.x = x;
            this.depth = depth;
            this.life = life;
            this.durability = durability;
            this.umbrella = umbrella;
        }

    }

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] start = null;
        int[] end = null;
        char[][] table = new char[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                char value = input.charAt(j);
                if (value == 'U') {
                    table[i][j] = (char) ('1' + count++);
                    continue;
                }
                table[i][j] = value;
                if (value == 'S') {
                    start = new int[]{i, j};
                }
                if (value == 'E') {
                    end = new int[]{i, j};
                }
            }
        }

        bfs(start, end, table, h, d);
        System.out.println(-1);
    }

    private static void bfs(int[] start, int[] end, char[][] table, int h, int d) {
        Deque<User> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[table.length][table[0].length][11];
        q.add(new User(start[0], start[1], 0, h, 0, 0));
        visited[start[0]][start[1]][0] = true;

        while (!q.isEmpty()) {
            User p = q.poll();
            if (p.life == 0) {
                continue;
            }

            for (int i = 0; i < move.length; i++) {
                int ny = p.y + move[i][0];
                int nx = p.x + move[i][1];

                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }
                if (visited[ny][nx][p.umbrella]) {
                    continue;
                }
                if (table[ny][nx] == 'E') {
                    System.out.println(p.depth + 1);
                    System.exit(0);
                }
                // 우산인경우
                if (Character.isDigit(table[ny][nx])) {
                    int umbrella = Character.getNumericValue(table[ny][nx]);
                    q.add(new User(ny, nx, p.depth + 1, p.life, d - 1, umbrella));
                    visited[ny][nx][umbrella] = true;
                    visited[ny][nx][p.umbrella] = true;
                }
                // .인경우
                if (p.durability != 0) {
                    q.add(new User(ny, nx, p.depth + 1, p.life, p.durability - 1, p.umbrella));
                    visited[ny][nx][p.umbrella] = true;
                } else {
                    q.add(new User(ny, nx, p.depth + 1, p.life - 1, 0, p.umbrella));
                    visited[ny][nx][p.umbrella] = true;
                }
            }
        }
    }
}
