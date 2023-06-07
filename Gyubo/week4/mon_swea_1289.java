import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mon_swea_1289 {

    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < testCase + 1; tc++) {
            count = 0;
            char[] input = br.readLine().toCharArray();
            recursive(input, '0', 0);

            System.out.println("#" + tc + " " + count);
        }
    }

    private static void recursive(char[] arr, char prevValue, int index) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] != prevValue) {
            count++;
            prevValue = arr[index];
        }
        recursive(arr, prevValue, index + 1);
    }
}