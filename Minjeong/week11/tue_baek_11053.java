import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class tue_baek_11053 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] res = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        res[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) res[i] = res[i - 1] + 1;
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && res[j] > maxLen) {
                    maxLen = res[j];
                }
            }
            res[i] = Math.max(res[i], maxLen + 1);
            max = Math.max(max, res[i]);
        }


        System.out.println(max);
    }
}