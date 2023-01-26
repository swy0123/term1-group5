import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class thu_beak_16926 {

    private static final int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int rotateNum = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(input.nextToken());
            }
        }

        for (int j = 0; j < rotateNum; j++) {
            // 외부 테두리부터 안쪽 까지 회전
            for (int i = 0; i < Math.min(n, m) / 2; i++) {
                rotateOnce(n, m, table, i);
            }
        }

        for (int[] ints : table) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void rotateOnce(int n, int m, int[][] table, int i) {
        // for문 반복의 수
        int rotateElementCount = (n - 2 * i) * 2 + (m - 2 * i) * 2;
        int startX = i;
        int startY = i;
        int endX = m - i;
        int endY = n - i;

        int tmp = table[startY][startX];
        int curX = startX;
        int curY = startY;
        int moveFlag = 0;
        for (int j = 0; j < rotateElementCount; j++) {
            int nx = curX + move[moveFlag][0];
            int ny = curY + move[moveFlag][1];

            if (nx < startX || nx >= endX || ny < startY || ny >= endY) {
                moveFlag++;
                continue;
            }
            table[curY][curX] = table[ny][nx];
            curX = nx;
            curY = ny;
        }
        table[startY + 1][startX] = tmp;
    }
}

