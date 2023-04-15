import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드
public class sat_baek_11404 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] res = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
            res[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            res[a][b] = Math.min(res[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (k == i || res[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 1; j <= n; j++) {
                    if (res[k][j] != Integer.MAX_VALUE) {
                        res[i][j] = Math.min(res[i][j], res[i][k] + res[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (res[i][j] == Integer.MAX_VALUE) sb.append(0).append(" ");
                else sb.append(res[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
