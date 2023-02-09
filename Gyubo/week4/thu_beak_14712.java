import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_beak_14712 {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] table = new boolean[n][m];
        dfs(table, 0, 0);
        System.out.println(count);
    }

    private static void dfs(boolean[][] table, int y, int x) {
        // 종료 조건
        if (table.length == y) {
            count++;
            return;
        }

        // 다음 x, y 값 구하기
        int nx = x + 1;
        int ny = y;
        if (nx == table[0].length) {
            nx = 0;
            ny = y + 1;
        }

        table[y][x] = true;
        // true 처리했을때 왼쪽, 왼쪽 위, 위 3곳도 true 라면 정사각형이 만들어짐
        if (y > 0 && x > 0 && table[y][x - 1] && table[y - 1][x - 1] && table[y - 1][x]) {
            table[y][x] = false;
            dfs(table, ny, nx);
        } else {
            dfs(table, ny, nx);
            table[y][x] = false;
            dfs(table, ny, nx);
        }
    }
}
