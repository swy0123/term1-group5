import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class wed_baek_1793 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = 0;
            try {
                n = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                return;
            }
            BigInteger[] res = new BigInteger[n + 1];
            for (int i = 3; i <= n; i++) {
                res[i] = BigInteger.ZERO;
            }
            res[0] = BigInteger.ONE;
            if (n >= 1) res[1] = BigInteger.ONE;
            if (n >= 2) res[2] = new BigInteger("3");
            for (int i = 3; i <= n; i++) {
                res[i] = res[i].add(res[i - 1]);
                BigInteger tmp = new BigInteger(res[i - 2].toString());
                res[i] = res[i].add(res[i - 2].multiply(BigInteger.valueOf(2)));
            }
            System.out.println(res[n].toString());
        }
    }
}