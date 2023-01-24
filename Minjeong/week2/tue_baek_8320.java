import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i; i * j <= n; j++) {
                res++;
            }
        }
        System.out.println(res);
    }
}
