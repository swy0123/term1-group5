import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 숨바꼭질
public class thu_beak_1697 {

    private static final int maxRange = 100_000;
    private static final int minRange = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);
    }

    private static void bfs(int n, int k) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[maxRange + 1];
        q.add(new int[]{n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int value = p[0];
            int depth = p[1];

            if (value == k) {
                System.out.println(depth);
                System.exit(0);
            }

            // 2배 Case
            int newValue = 2 * value;
            if (newValue <= maxRange && newValue >= minRange && !visited[newValue]) {
                visited[newValue] = true;
                q.add(new int[]{newValue, depth + 1});
            }
            // 1증가 Case
            newValue = value + 1;
            if (newValue <= maxRange && newValue >= minRange && !visited[newValue]) {
                visited[newValue] = true;
                q.add(new int[]{newValue, depth + 1});
            }

            // 1감소 Case
            newValue = value - 1;
            if (newValue <= maxRange && newValue >= minRange && !visited[newValue]) {
                visited[newValue] = true;
                q.add(new int[]{newValue, depth + 1});
            }
        }
    }
}
