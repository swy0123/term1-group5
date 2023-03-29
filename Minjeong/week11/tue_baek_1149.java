import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tue_baek_1149 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] houses = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int a = Integer.parseInt(st.nextToken());
                houses[i][j] = a;
            }
        }

        int[][] res = new int[n][3];
        res[0][0] = houses[0][0];
        res[0][1] = houses[0][1];
        res[0][2] = houses[0][2];

        for (int i = 1; i < n; i++) {
            res[i][0] = Math.min(res[i - 1][1], res[i - 1][2]) + houses[i][0];
            res[i][1] = Math.min(res[i - 1][0], res[i - 1][2]) + houses[i][1];
            res[i][2] = Math.min(res[i - 1][0], res[i - 1][1]) + houses[i][2];
        }

        System.out.println(Math.min(res[n - 1][0], Math.min(res[n - 1][1], res[n - 1][2])));
    }
}
