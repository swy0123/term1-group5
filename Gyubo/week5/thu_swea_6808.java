import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 규영이와 인영이의 가드게임
public class thu_swea_6808 {

    private static int gyuWinCount;
    private static int inWinCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc < testCase + 1; tc++) {
            gyuWinCount = 0;
            inWinCount = 0;
            st = new StringTokenizer(br.readLine());
            int[] cards = new int[19];
            int[] arr1 = new int[9];
            int[] arr2 = new int[9];

            for (int i = 0; i < 9; i++) {
                cards[Integer.parseInt(st.nextToken())] = 1;
            }

            int arr1Index = 0;
            int arr2Index = 0;
            for (int i = 1; i < 19; i++) {
                if (cards[i] == 1) {
                    arr1[arr1Index++] = i;
                } else {
                    arr2[arr2Index++] = i;
                }
            }

            permutation(new int[9], new boolean[9], arr1, arr2, 0);
            System.out.println("#" + tc + " " + gyuWinCount + " " + inWinCount);
        }
    }

    private static void permutation(int[] result, boolean[] visited, int[] arr1, int[] arr2, int depth) {
        if (depth == result.length) {
            // 이기는지 지는지 체크
            int score = 0;
            for (int i = 0; i < result.length; i++) {
                if (arr1[i] > result[i]) {
                    score += arr1[i] + result[i];
                } else {
                    score -= arr1[i] + result[i];
                }
            }
            if (score < 0) {
                inWinCount++;
            } else {
                gyuWinCount++;
            }
            return;
        }

        for (int i = 0; i < arr2.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[depth] = arr2[i];
            permutation(result, visited, arr1, arr2, depth + 1);
            visited[i] = false;
        }
    }
}
