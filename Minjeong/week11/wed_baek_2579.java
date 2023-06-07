import java.io.BufferedReader;
import java.io.InputStreamReader;

public class wed_baek_2579 {
    static int[] arr, res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if (n <= 1) return arr[n];
        if (n == 2) return arr[1] + arr[2];
        if (res[n] != 0) return res[n];
        return res[n] = Math.max(solve(n - 2), solve(n - 3) + arr[n - 1]) + arr[n];
    }
}