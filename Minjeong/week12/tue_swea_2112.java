import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 보호 필름
public class tue_swea_2112 {
    static int d, w, k, res;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int testCase = 1; testCase <= T; testCase++) {
            res = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[d][w];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve(0, 0);
            System.out.println("#" + testCase + " " + res);
        }
    }

    private static void solve(int cnt, int depth) {
        if (cnt >= res) return;
        if (depth == d) {
            if (check()) res = Math.min(res, cnt);
            return;
        }

        int[] tmp = map[depth].clone();
        solve(cnt, depth + 1);
        Arrays.fill(map[depth], 0);
        solve(cnt + 1, depth + 1);
        Arrays.fill(map[depth], 1);
        solve(cnt + 1, depth + 1);
        map[depth] = tmp;
    }

    private static boolean check() {
        l: for (int i = 0; i < w; i++) {
            for (int j = 0; j <= d - k; j++) {
                int cnt = 1;
                for (int c = 1; c < k; c++) {
                    if (map[j + c][i] == map[j][i]) cnt++;
                }
                if (cnt == k) continue l;
            }
            return false;
        }
        return true;
    }
}