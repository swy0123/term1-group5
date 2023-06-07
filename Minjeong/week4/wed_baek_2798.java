import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, res;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recursive(0, 0, 0, new boolean[n]));
    }

    private static int recursive(int pos, int depth, int sum, boolean[] v) {
        if (sum > m) return 0;
        if (depth == 3) return sum;

        for (int i = pos; i < n; i++) {
            if (!v[i]) {
                v[i] = true;
                res = Math.max(res, recursive(i + 1, depth + 1, sum + nums[i], v));
                v[i] = false;
            }
        }
        return res;
    }

}
