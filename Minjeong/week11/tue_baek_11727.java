import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2xn 타일링 2
public class tue_baek_11727 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] res = new int[n + 1];
        res[1] = 1;
        if (n >= 2) res[2] = 3;
        for (int i = 3; i <= n; i++) {
            res[i] = (res[i - 1] + res[i - 2] * 2) % 10007;
        }

        System.out.println(res[n]);
    }
}
