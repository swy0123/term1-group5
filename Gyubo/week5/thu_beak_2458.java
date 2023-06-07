import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 키 순서
public class thu_beak_2458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                graph[i][j] = 2;
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2] = 1;
            graph[node2][node1] = -1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][j] == 2) {
                        if (graph[i][k] == 1 && graph[k][j] == 1) {
                            graph[i][j] = 1;
                            graph[j][i] = -1;
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            boolean flag = false;
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] == 2) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }

        System.out.println(count);
    }
}
