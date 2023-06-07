import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tue_baek_16919 {
    static int r, c, n;
    static int[][] bomb, del = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][][] res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];
        bomb = new int[r][c];
        res = new char[8][r][c];
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'O') bomb[i][j] = 4;
            }
        }

        solve(arr);
        int idx = (n - 1) % 4;
        if (n > 4) idx += 4;
        print(idx);
    }

    private static void solve(char[][] arr) {
        int t = 0;

        while (t < 8) {
            decrease();
            if (t % 2 == 1) installBomb(arr);
            explode(arr);

            for (int i = 0; i < r; i++) {
                res[t][i] = arr[i].clone();
            }
            t++;
        }
    }

    private static void explode(char[][] arr) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (bomb[i][j] != 1) continue;
                arr[i][j] = '.';
                bomb[i][j] = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + del[d][0];
                    int ny = j + del[d][1];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || bomb[nx][ny] == 1) continue;
                    arr[nx][ny] = '.';
                    bomb[nx][ny] = 0;
                }
            }
        }
    }

    private static void installBomb(char[][] arr) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == '.') {
                    arr[i][j] = 'O';
                    bomb[i][j] = 4;
                }
            }
        }
    }

    private static void decrease() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (bomb[i][j] > 1) bomb[i][j]--;
            }
        }
    }

    private static void print(int idx) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(res[idx][i][j]);
            }
            System.out.println();
        }
    }
}
