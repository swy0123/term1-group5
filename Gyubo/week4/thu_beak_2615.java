import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_beak_2615 {

    private static final int[][] move = {{0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) throws IOException {
        int[][] table = new int[19][19];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (table[i][j] == 0) {
                    continue;
                }
                // 탐색시작
                for (int k = 0; k < move.length; k++) {
                    int result = -1;
                    result += checkLine(i, j, table[i][j], table, 0, move[k][0], move[k][1]);
                    result += checkLine(i, j, table[i][j], table, 0, -move[k][0], -move[k][1]);

                    if (result == 5) {
                        System.out.println(table[i][j]);
                        System.out.print(++i + " " + ++j);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static int checkLine(int y, int x, int value, int[][] table, int count, int dy, int dx) {
        if (y < 0 || y >= table.length || x < 0 || x >= table[0].length) {
            return count;
        }

        if (table[y][x] != value) {
            return count;
        }

        count++;
        return checkLine(y + dy, x + dx, value, table, count, dy, dx);
    }
}