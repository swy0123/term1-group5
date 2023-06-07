import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빵집
public class tue_beak_3109 {

    private static final int[][] move = {{-1, 1}, {0, 1}, {1, 1}};
    private static int answer = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] table = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                table[i][j] = row.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            flag = false;
            dfs(table, i, 0);
        }

        System.out.println(answer);
    }

    private static void dfs(char[][] table, int y, int x) {
        if (x == table[0].length - 1) {
            table[y][x] = 'x';
            answer++;
            flag = true;
            return;
        }

        for (int i = 0; i < move.length; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];

            if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                continue;
            }
            if (table[ny][nx] == 'x') {
                continue;
            }
            table[ny][nx] = 'x';
            dfs(table, ny, nx);
            if (flag) {
                return;
            }
            // table[ny][nx] = '.'
        }
    }

    private static void print(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
