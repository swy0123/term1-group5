import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달
public class mon_beak_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = -1;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int tmp = n - 3 * i;
            if (tmp < 0) {
                break;
            }
            if (tmp % 5 == 0) {
                count = tmp / 5 + i;
                break;
            }
        }

        System.out.println(count);
    }
}
