import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] info = new int[2][6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[1001][1001];
        for (int i = 0; i < 1001; i++)
            for (int j = 0; j < 1001; j++) arr[i][j] = -1;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            info[s][y - 1] += 1;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (info[i][j] != 0) {
                    cnt += info[i][j] / k;
                    if (info[i][j] % k != 0) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}