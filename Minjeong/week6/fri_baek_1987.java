import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] del = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int[][] island;
    static boolean[] alphabet;
    static int r, c, res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        island = new int[r][c];

        for (int i = 0; i < r; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                island[i][j] = tmp[j];
            }
        }

        alphabet = new boolean[26];
        alphabet[island[0][0] - 'A'] = true;

        res = 0;
        find(0, 0, 1);
        System.out.println(res);
    }

    private static void find(int x, int y, int cnt) {
        for (int i = 0; i < 4; i++) {
            int nx = x + del[i][0];
            int ny = y + del[i][1];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c || alphabet[island[nx][ny] - 'A']) {
                res = Math.max(res, cnt);
                continue;
            }
            alphabet[island[nx][ny] - 'A'] = true;
            find(nx, ny, cnt + 1);
            alphabet[island[nx][ny] - 'A'] = false;
        }
    }
}