import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mon_swea_1952 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            int[] tickets = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                tickets[i] = Integer.parseInt(st.nextToken());
            }
            int[] year = new int[12];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                year[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[12];
            dp[0] = Math.min(year[0] * tickets[0], tickets[1]);
            // 달마다 반복
            for (int i = 1; i < 12; i++) {
                // 1일권으로 계산하는 경우
                int oneDayCost = year[i] * tickets[0];
                oneDayCost += dp[i - 1];
                // 1달권으로 계산하는 경우
                int oneMonthCost = tickets[1];
                oneMonthCost += dp[i - 1];
                // 3개월권으로 계산하는 경우
                int threeMonthCost = tickets[2];
                if (i > 2) {
                    threeMonthCost += dp[i - 3];
                }
                dp[i] = Math.min(Math.min(oneDayCost, oneMonthCost), threeMonthCost);
            }
            // 1년권으로 계산 하는경우
            dp[11] = Math.min(dp[11], tickets[3]);
            System.out.println("#" + tc + " " + dp[11]);
        }
    }
}
