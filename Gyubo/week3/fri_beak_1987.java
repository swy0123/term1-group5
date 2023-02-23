import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알파벳
public class fri_beak_1987 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] alphabetVisited = new boolean[26];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] table = new char[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                table[i][j] = input.charAt(j);
            }
        }

        dfs(0, 0, alphabetVisited, table, 1);
        System.out.println(max);
    }

    private static void dfs(int y, int x, boolean[] visited, char[][] table, int depth) {
        max = Math.max(depth, max);

        char currentValue = table[y][x];
        visited[currentValue - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];

            if (ny < 0 || ny >= table.length || nx < 0 || nx >= table[0].length) {
                continue;
            }
            char nextValue = table[ny][nx];
            if (visited[nextValue - 'A']) {
                continue;
            }
            dfs(ny, nx, visited, table, depth + 1);
        }
        visited[currentValue - 'A'] = false;
    }
}
