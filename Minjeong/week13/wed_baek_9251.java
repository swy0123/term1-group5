import java.io.BufferedReader;
import java.io.InputStreamReader;

// LCS
public class wed_baek_9251 {
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int aLen = a.length();
        int bLen = b.length();
        dp = new int[aLen + 1][bLen + 1];

        for (int i = 0; i < aLen; i++) {
            for (int j = 0; j < bLen; j++) {
                if (a.charAt(i) == b.charAt(j)) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        System.out.println(dp[aLen][bLen]);
    }
}
