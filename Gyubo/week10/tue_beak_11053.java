import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 1
public class tue_beak_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int endIndex = 0;
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (dp[endIndex] < arr[i]) {
                dp[++endIndex] = arr[i];
            } else {
                // 이진 탐색을 활용하여 찾기
                int index = Arrays.binarySearch(dp, arr[i]);
                // 같은값이 없고, 대신 가장 가까운 큰 수 를 찾는다.
                if (index < 0) {
                    index = -index - 1;
                }
                dp[index] = arr[i];
            }
        }

        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                break;
            } else {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
