import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


// 게임 개발
public class thu_baek_1516 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] degree = new int[n + 1];
        int[] time = new int[n + 1];
        int[] res = new int[n + 1];

        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) break;
                list[a].add(i);
                degree[i] += 1;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.offer(i);
                res[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list[cur]) {
                degree[next] -= 1;
                res[next] = Math.max(res[next], res[cur]);
                if (degree[next] == 0) {
                    res[next] += time[next];
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(res[i]);
        }
    }
}
