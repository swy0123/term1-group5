import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sun_baek_17144 {
    static int[][] map, del = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    static int r, c, t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        int upX = -1;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) upX = i;
            }
        }
        upX--;

        while (t-- > 0) {
            spread();
            move(upX);
        }

        System.out.println(calc());
    }

    private static void spread() {
        int[][] tmp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) tmp[i][j] = -1;
                if (map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + del[k][0];
                        int ny = j + del[k][1];
                        if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == -1) continue;
                        tmp[nx][ny] += amount;
                        cnt++;
                    }
                    tmp[i][j] += map[i][j] - amount * cnt;
                }
            }
        }
        map = tmp;
    }

    private static void move(int upX) {
        moveUp(upX);
        moveDown(upX + 1);
    }

    private static void moveUp(int upX) {
        map[upX][0] = 0;
        int tmp = map[0][0];
        for (int i = 1; i < c; i++) {
            map[0][i - 1] = map[0][i];
        }
        for (int i = 1; i <= upX; i++) {
            map[i - 1][c - 1] = map[i][c - 1];
        }
        for (int i = c - 2; i >= 0; i--) {
            map[upX][i + 1] = map[upX][i];
        }
        for (int i = upX - 1; i >= 0; i--) {
            map[i + 1][0] = map[i][0];
        }

        map[upX][0] = -1;
        map[1][0] = tmp;
    }

    private static void moveDown(int downX) {
        map[downX][0] = 0;
        int tmp = map[downX][c - 1];
        for (int i = c - 2; i >= 0; i--) {
            map[downX][i + 1] = map[downX][i];
        }
        for (int i = downX + 1; i < r; i++) {
            map[i - 1][0] = map[i][0];
        }
        for (int i = 1; i < c; i++) {
            map[r - 1][i - 1] = map[r - 1][i];
        }
        for (int i = r - 2; i >= downX; i--) {
            map[i + 1][c - 1] = map[i][c - 1];
        }

        map[downX][0] = -1;
        map[downX + 1][c - 1] = tmp;
    }

    private static int calc() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != -1) sum += map[i][j];
            }
        }
        return sum;
    }
}