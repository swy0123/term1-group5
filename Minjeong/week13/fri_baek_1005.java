import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// ACM Craft
public class fri_baek_1005 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] degree, time, res;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            degree = new int[n + 1];
            time = new int[n + 1];
            res = new int[n + 1];
            List<Integer>[] list = new ArrayList[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                degree[b]++;
            }

            int finalBuilding = Integer.parseInt(br.readLine());

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) q.offer(i);
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                res[cur] += time[cur];
                if (cur == finalBuilding) break;
                for (int next : list[cur]) {
                    degree[next]--;
                    res[next] = Math.max(res[next], res[cur]);
                    if (degree[next] == 0) q.offer(next);
                }
            }

            System.out.println(res[finalBuilding]);
        }
    }
}