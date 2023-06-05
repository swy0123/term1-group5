import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 택배
public class tue_baek_1719 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] cost = new int[n + 1][n + 1];
        int[][] res = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(cost[i], 1000000);
            cost[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[a][b] = c; cost[b][a] = c;
            res[a][b] = b; res[b][a] = a;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;
                for (int j = 1; j <= n; j++) {
                    if (k != j && cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                        res[i][j] = res[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) sb.append("- ");
                else sb.append(res[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}