import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mon_beak_2798 {

    private static int m;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combination(arr, new int[3], 0, 0);
        System.out.println(answer);
    }

    private static void combination(int[] arr, int[] results, int depth, int index) {
        if (depth == results.length) {
            int sum = Arrays.stream(results).sum();
            if (sum <= m) {
                answer = Math.max(answer, sum);
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            results[depth] = arr[i];
            combination(arr, results, depth + 1, i + 1);
        }
    }
}
