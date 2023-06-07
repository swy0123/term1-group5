import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// RGB 거리
public class tue_beak_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][3];
        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        dp[0][0] = r;
        dp[0][1] = g;
        dp[0][2] = b;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;
        }

        int answer = Arrays.stream(dp[n - 1]).min().getAsInt();
        System.out.println(answer);
    }
}
