import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 맥주 마시면서 걸어가기
public class mon_baek_9205 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static Node[] arr;
    static int[][] dist, dp;
    static final int MAX = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        dist = new int[102][102];
        dp = new int[102][102];

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new Node[n + 2];
            st = new StringTokenizer(br.readLine());
            arr[0] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            arr[n + 1] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < n + 2; i++) {
                Arrays.fill(dist[i], MAX);
                Arrays.fill(dp[i], MAX);
                for (int j = 0; j < n + 2; j++) {
                    dist[i][j] = Math.abs(arr[i].x - arr[j].x) + Math.abs(arr[i].y - arr[j].y);
                    if (dist[i][j] <= 1000) dp[i][j] = dist[i][j];
                }
            }

            for (int k = 0; k < n + 1; k++) {
                for (int i = 0; i < n + 1; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                    }
                }
            }

            if (dp[0][n + 1] != MAX) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}