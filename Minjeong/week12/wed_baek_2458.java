import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 키 순서
public class wed_baek_2458 {
    static int n, m, res;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n +1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) { // 경유(학생 k)
            for (int i = 1; i <= n; i++) { // 출발(학생 i)
                if (i == k || arr[i][k] == 0) continue;
                for (int j = 1; j <= n; j++) { // 도착(학생 j)
                    if (arr[i][j] == 1) continue;
                    arr[i][j] = arr[k][j];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][0] += arr[i][j];
                arr[0][j] += arr[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i][0] + arr[0][i] == n - 1) res++;
        }
        System.out.println(res);
    }
}