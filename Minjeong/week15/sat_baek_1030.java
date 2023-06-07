import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sat_baek_1030 {
    static int s, n, k, r1, r2, c1, c2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(n, s);
        StringBuilder sb = new StringBuilder();
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                dfs(size, i, j, 0, 0, sb);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int size, int x, int y, int sx, int sy, StringBuilder sb) {
        if (size < n) {
            sb.append(0);
            return;
        }

        int small = size / n;

        // 검정색 영역일 때
        if (x >= sx + ((n - k) / 2) * small
                && x < sx + ((n - k) / 2 + k) * small
                && y >= sy + ((n - k) / 2) * small
        && y < sy + ((n - k) / 2 + k) * small) {
            sb.append(1);
            return;
        }

        // 아닐 때
        dfs(small, x, y, sx + ((x - sx) / small) * small, sy  + ((y - sy) / small) * small, sb);
    }
}
