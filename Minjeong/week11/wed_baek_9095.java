import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1, 2, 3 더하기
public class wed_baek_9095 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] res = new int[n + 1];

            res[1] = 1;
            if (n >= 2) res[2] = 2;
            if (n >= 3) res[3] = 4;
            for (int i = 4; i <= n; i++) {
                res[i] = res[i - 1] + res[i - 2] + res[i - 3];
            }
            System.out.println(res[n]);
        }
    }
}