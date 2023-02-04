import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class sat_beak_15686 {

    private static final List<int[]> chickens = new ArrayList<>();
    private static final List<int[]> houses = new ArrayList<>();
    private static final List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int currentValue = Integer.parseInt(st.nextToken());
                if (currentValue == 1) {
                    houses.add(new int[]{i, j});
                } else if (currentValue == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        int[] selectedChickens = new int[m];
        dfs(selectedChickens, 0, m, 0);
        System.out.println(Collections.min(results));
    }

    private static void dfs(int[] chickenIndex, int currentDepth, int targetDepth, int index) {
        if (currentDepth == targetDepth) {
            int totalDist = 0;
            for (int[] house : houses) {
                int houseToChickDist = Integer.MAX_VALUE;
                for (int chick : chickenIndex) {
                    int[] chickenHouseLocation = chickens.get(chick);
                    houseToChickDist = Math.min(
                            Math.abs(house[0] - chickenHouseLocation[0]) + Math.abs(house[1] - chickenHouseLocation[1]),
                            houseToChickDist);
                }
                totalDist += houseToChickDist;
            }
            results.add(totalDist);
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            chickenIndex[currentDepth] = i;
            dfs(chickenIndex, currentDepth + 1, targetDepth, i + 1);
        }
    }
}
