import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 최종 순위
public class thu_baek_3665 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] degree, arr;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            degree = new int[n + 1];
            arr = new int[n + 1];
            Set<Integer>[] set = new HashSet[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                set[i] = new HashSet<>();
            }

            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    set[arr[i]].add(arr[j]);
                    degree[arr[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (set[b].contains(a)) {
                    degree[a]--;
                    set[b].remove(a);
                    set[a].add(b);
                    degree[b]++;
                }
                else if (set[a].contains(b)) {
                    degree[b]--;
                    set[a].remove(b);
                    set[b].add(a);
                    degree[a]++;
                }
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) q.offer(i);
            }

            int cnt = 0;
            boolean flag = true;
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                int cur = q.poll();
                sb.append(cur).append(" ");
                cnt++;
                int tmpCnt = 0;
                for (int next : set[cur]) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        tmpCnt++;
                        q.offer(next);
                    }
                }
                if (tmpCnt > 1) {
                    flag = false;
                    break;
                }
            }
            if (cnt == n) System.out.println(sb);
            else {
                if (flag) System.out.println("IMPOSSIBLE");
                else System.out.println("?");
            }
        }
    }
}