import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] cost;
    static int[] plan;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost = new int[4];
            for (int i = 0; i < 4; i++) cost[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            plan = new int[12];
            for (int i = 0; i < 12; i++) plan[i] = Integer.parseInt(st.nextToken());

            minCost = cost[3];
            find(0, 0);
            System.out.println("#" + testCase + " " + minCost);
        }
    }

    private static void find(int month, int curCost) {
        if (canFinish()) {
            minCost = Math.min(minCost, curCost);
            return;
        }
        if (curCost > minCost || month >= 12) return;

        for (int k = month; k < 12; k++) {
            if (plan[k] == 0) continue;

            // 하루
            int tmp2 = plan[k];
            plan[k] = 0;
            find(k + 1, curCost + cost[0] * tmp2);

            // 한 달
            find(k + 1, curCost + cost[1]);
            plan[k] = tmp2;

            // 세 달
            int[] tmp = new int[3];
            int finalMonth = -1;
            for (int i = k, j = 0; i < k + 3; i++, j++) {
                if (i >= 12) break;
                tmp[j] = plan[i];
                plan[i] = 0;
                finalMonth = i;
            }
            find(finalMonth + 1, curCost + cost[2]);
            for (int i = k, j = 0; i < k + 3; i++, j++) {
                if (i >= 12) break;
                plan[i] = tmp[j];
            }
        }
    }

    private static boolean canFinish() {
        for (int i = 0; i < 12; i++) {
            if (plan[i] != 0) return false;
        }
        return true;
    }
}