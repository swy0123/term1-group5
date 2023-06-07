import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백설공주와 일곱 난쟁이
public class mon_beak_3040 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        combination(arr, 0, 0, new int[7]);
    }

    private static void combination(int[] arr, int depth, int index, int[] result) {
        if (depth == result.length) {
            int sum = Arrays.stream(result).sum();
            if (sum == 100) {
                for (int i = 0; i < result.length; i++) {
                    System.out.println(result[i]);
                }
                System.exit(0);
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            result[depth] = arr[i];
            combination(arr, depth + 1, i + 1, result);
        }
    }
}
