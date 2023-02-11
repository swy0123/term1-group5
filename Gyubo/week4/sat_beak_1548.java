import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sat_beak_1548 {

    private static int[][] table;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        table = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                for (int dy = -9; dy < 10; dy++) {
                    for (int dx = -9; dx < 10; dx++) {
                        checkSquare(y, x, dy, dx, table[y][x]);
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static void checkSquare(int y, int x, int dy, int dx, int value) {
        double sqrt = Math.sqrt(value);
        if (sqrt == (int) sqrt) {
            if (result < value) {
                result = value;
            }
        }

        if (dy == 0 && dx == 0) {
            return;
        }

        int ny = y + dy;
        int nx = x + dx;
        if (ny >= table.length || ny < 0 || nx >= table[0].length || nx < 0) {
            return;
        }

        int nValue = table[ny][nx] + value * 10;
        checkSquare(ny, nx, dy, dx, nValue);
    }
}
