import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 수지의 수지맞는 여행
public class wed_swea_7699 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc < testCase + 1; tc++) {
            answer = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] table = new char[n][m];
            for (int i = 0; i < n; i++) {
                String readLine = br.readLine();
                for (int j = 0; j < m; j++) {
                    table[i][j] = readLine.charAt(j);
                }
            }

            HashSet<Character> set = new HashSet<Character>();
            set.add(table[0][0]);
            dfs(table, 0, 0, set);
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void dfs(char[][] table, int y, int x, Set<Character> set) {
        if (y == table.length - 1 && x == table[0].length - 1) {
            answer = Math.max(set.size(), answer);
            return;
        }

        for (int i = 0; i < move.length; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];

            if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                continue;
            }
            if (set.contains(table[ny][nx])) {
                answer = Math.max(set.size(), answer);
                continue;
            }

            set.add(table[ny][nx]);
            dfs(table, ny, nx, set);
            set.remove(table[ny][nx]);
        }
    }
}
