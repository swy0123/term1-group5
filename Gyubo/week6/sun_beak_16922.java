import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 로마 숫자 만들기
public class sun_beak_16922 {

    //    private static final Set<Integer> set = new HashSet<>();
    private static final int[] results = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        combinationWithDuplication(0, n, 0, new int[]{1, 5, 10, 50}, 0);
        long count = Arrays.stream(results).filter(value -> value == 1).count();
        System.out.println(count);
    }

    private static void combinationWithDuplication(int depth, int targetDepth, int result, int[] arr, int index) {
        if (depth == targetDepth) {
            results[result] = 1;
            return;
        }

        for (int i = index; i < 4; i++) {
            result += arr[i];
            combinationWithDuplication(depth + 1, targetDepth, result, arr, i);
            result -= arr[i];
        }
    }
}
