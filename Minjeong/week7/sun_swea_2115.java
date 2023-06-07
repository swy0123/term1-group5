import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sun_swea_2115 {
    static int n, m, c, res;
    static int[][] map, tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            tmp = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - m; j++) {
                    tmp[i][j] = maxSum(i, j, 0, 0, 0);
                }
            }

            res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int first = tmp[i][j];
                    for (int k = i; k < n; k++) {
                        for (int l = 0; l <= n - m; l++) {
                            if (i == k && l < j + m) continue;
                            int second = tmp[k][l];
                            res = Math.max(res, first + second);
                        }
                    }
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }



    private static int maxSum(int x, int y, int idx, int sum, int income) {
        if (idx == m) return income;

        int a = maxSum(x, y, idx + 1, sum, income);
        int b = 0;
        if ((y + idx < n) && (sum + map[x][y + idx] <= c)) {
            b = maxSum(x, y, idx + 1, sum + map[x][y + idx], map[x][y + idx] * map[x][y + idx] + income);
        }
        return Math.max(a, b);
    }
}