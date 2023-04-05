import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 장훈이의 높은 선반
public class wed_swea_1486 {
    static int n, b, res;
    static int[] height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            height = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            res = Integer.MAX_VALUE;
            solve(0, 0, 0, new boolean[n]);

            System.out.println("#" + testCase + " " + (res - b));
        }
    }

    private static void solve(int sum, int depth, int cnt, boolean[] v) {
        if (sum >= res) return;
        if (depth == n) {
            if (cnt > 0 && sum >= b) res = Math.min(res, sum);
            return;
        }

        solve(sum, depth + 1, cnt, v);
        v[depth] = true;
        solve(sum + height[depth], depth + 1, cnt + 1, v);
        v[depth] = false;
    }
}
