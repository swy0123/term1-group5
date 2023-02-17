import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Rotate {

    public int r;
    public int c;
    public int s;

    public Rotate(int r, int c, int s) {
        super();
        this.r = r;
        this.c = c;
        this.s = s;
    }

    @Override
    public String toString() {
        return "Rotate [r=" + r + ", c=" + c + ", s=" + s + "]";
    }

}

// 배열돌리기 4
public class thu_beak_17406 {

    private static final int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][m];
        int[][] cloneTable = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Rotate[] rotates = new Rotate[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rotates[i] = new Rotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        permutation(rotates, new boolean[rotates.length], new Rotate[rotates.length], 0, table, cloneTable);
        System.out.println(minValue);
    }

    private static void permutation(Rotate[] rotates, boolean[] visited, Rotate[] result, int depth, int[][] table,
            int[][] cloneTable) {
        if (depth == result.length) {
            copy(cloneTable, table);
            // 배열돌리기 시작
            for (Rotate res : result) {
                rotateOnce(res, table);
            }
            calMinValue(table);
            copy(table, cloneTable);
            return;
        }

        for (int i = 0; i < rotates.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[depth] = rotates[i];
            permutation(rotates, visited, result, depth + 1, table, cloneTable);
            visited[i] = false;
        }
    }

    private static void calMinValue(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            int sum = Arrays.stream(table[i]).sum();
            minValue = Math.min(sum, minValue);
        }
    }

    private static void copy(int[][] table1, int[][] table2) {
        for (int i = 0; i < table1.length; i++) {
            for (int j = 0; j < table1[0].length; j++) {
                table1[i][j] = table2[i][j];
            }
        }
    }

    private static void rotateOnce(Rotate rotate, int[][] table) {
        for (int i = 0; i < rotate.s; i++) {
            int startY = rotate.r - rotate.s + i - 1;
            int startX = rotate.c - rotate.s + i - 1;
            int endY = rotate.r + rotate.s - i - 1;
            int endX = rotate.c + rotate.s - i - 1;
            int cy = startY;
            int cx = startX;
            int moveIndex = 0;

            int temp = table[startY][startX];
            while (moveIndex != 4) {
                int ny = cy + move[moveIndex][0];
                int nx = cx + move[moveIndex][1];

                if (ny < startY || nx < startX || ny > endY || nx > endX) {
                    moveIndex++;
                    continue;

                }

                table[cy][cx] = table[ny][nx];
                cy = ny;
                cx = nx;
            }
            table[startY][startX + 1] = temp;
        }
    }
}
