import java.io.BufferedReader;
import java.io.InputStreamReader;

// 줄세우기
public class wed_baek_2631 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            res[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) res[i] = res[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) res[i] = Math.max(res[i], res[j] + 1);
            }
            max = Math.max(max, res[i]);
        }
        System.out.println(n - max);
    }
    // 3 5 6
    // 3 7 5 2 6 1 4
}
