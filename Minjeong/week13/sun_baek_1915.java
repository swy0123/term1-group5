import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 큰 정사각형
public class sun_baek_1915 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] res = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if ((s.charAt(j) - '0') == 1) {
                    res[i][j] = 1;
                    max = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (res[i][j] == 1) {
                    res[i][j] = Math.min(Math.min(res[i][j - 1], res[i - 1][j]), res[i - 1][j - 1]) + 1;
                }
                max = Math.max(res[i][j], max);
            }
        }

        System.out.println(max * max);
    }
}
