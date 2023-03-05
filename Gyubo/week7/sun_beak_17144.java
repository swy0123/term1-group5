import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 미세먼지 안녕!
public class sun_beak_17144 {

    static class AC {

        int y;
        int x;

        public AC(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static final int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int[][] vector2 = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] table = new int[r][c];

        AC[] ACs = new AC[2];
        int count = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int input = Integer.parseInt(st.nextToken());
                table[i][j] = input;
                if (input == -1) {
                    ACs[count++] = new AC(i, j);
                }
            }
        }

        // 탐색하면서 미세먼지 찾기
        // 새로운 테이블에 복사
        for (int a = 0; a < t; a++) {
            int[][] tmpTable = new int[r][c];
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    //공기청정기 인 경우
                    if (table[i][j] == -1) {
                        tmpTable[i][j] = table[i][j];
                    } else if (table[i][j] != 0) {
                        diffuse(table, tmpTable, i, j);
                    }
                }
            }
            table = tmpTable;
            startUpperAC(ACs[0], table);
            startLowerAC(ACs[1], table);
        }

        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                sum += table[i][j];
            }
        }
        sum += 2;

        System.out.println(sum);
    }

    private static void startUpperAC(AC ac, int[][] table) {
        int startY = 0;
        int startX = 0;
        int endY = ac.y;
        int endX = table[0].length - 1;
        int cy = 0;
        int cx = 0;

        int tmpValue = table[startY][startX];
        int dir = 0;
        while (dir < 4) {
            int ny = cy + vector[dir][0];
            int nx = cx + vector[dir][1];

            if (ny < 0 || nx < 0 || ny > endY || nx > endX) {
                dir++;
                continue;
            }
            table[cy][cx] = table[ny][nx];
            cy = ny;
            cx = nx;
        }
        table[1][startX] = tmpValue;
        table[ac.y][ac.x] = -1;
        table[ac.y][ac.x + 1] = 0;
    }

    private static void startLowerAC(AC ac, int[][] table) {
        int startY = ac.y;
        int startX = ac.x;
        int endY = table.length - 1;
        int endX = table[0].length - 1;
        int cy = ac.y;
        int cx = table[0].length - 1;

        int tmpValue = table[startY][endX];
        int dir = 0;
        while (dir < 4) {
            int ny = cy + vector2[dir][0];
            int nx = cx + vector2[dir][1];

            if (ny < startY || nx < startX || ny > endY || nx > endX) {
                dir++;
                continue;
            }
            table[cy][cx] = table[ny][nx];
            cy = ny;
            cx = nx;
        }
        table[startY + 1][endX] = tmpValue;
        table[ac.y][ac.x] = -1;
        table[ac.y][ac.x + 1] = 0;
    }

    private static void diffuse(int[][] table, int[][] tmpTable, int y, int x) {
        int count = 0;
        int diffuseAmount = table[y][x] / 5;

        for (int d = 0; d < vector.length; d++) {
            int ny = y + vector[d][0];
            int nx = x + vector[d][1];

            if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                continue;
            }
            if (table[ny][nx] == -1) {
                continue;
            }
            tmpTable[ny][nx] += diffuseAmount;
            count++;
        }

        tmpTable[y][x] += table[y][x] - diffuseAmount * count;
    }
}
