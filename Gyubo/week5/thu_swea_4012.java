import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 요리사
public class thu_swea_4012 {

    private static final List<int[]> combinations = new ArrayList<>();
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc < testCase + 1; tc++) {
            answer = Integer.MAX_VALUE;
            combinations.clear();
            int n = Integer.parseInt(br.readLine());
            int[][] table = new int[n + 1][n + 1];
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n + 1; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(n, new int[n / 2], 0, 1);
            int endIndex = combinations.size() - 1;
            for (int i = 0; i < combinations.size() / 2; i++) {
                int[] comb1 = combinations.get(i);
                int[] comb2 = combinations.get(endIndex - i);

                int score1 = calcScore(table, comb1);
                int score2 = calcScore(table, comb2);

                answer = Math.min(Math.abs(score1 - score2), answer);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static int calcScore(int[][] table, int[] comb1) {
        int score = 0;
        for (int j = 0; j < comb1.length; j++) {
            for (int k = j + 1; k < comb1.length; k++) {
                int food1 = comb1[j];
                int food2 = comb1[k];

                score += table[food1][food2];
                score += table[food2][food1];
            }
        }
        return score;
    }

    private static void combination(int n, int[] result, int depth, int index) {
        if (result.length == depth) {
            combinations.add(result.clone());
            return;
        }

        for (int i = index; i <= n; i++) {
            result[depth] = i;
            combination(n, result, depth + 1, i + 1);
        }
    }
}
