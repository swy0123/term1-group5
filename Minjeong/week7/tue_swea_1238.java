import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n, start;
            n = Integer.parseInt(st.nextToken()) / 2;
            start = Integer.parseInt(st.nextToken());
            boolean[][] graph = new boolean[101][101];
            boolean[] v = new boolean[101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = true;
            }

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(start);
            v[start] = true;
            int res = start;
            while (!q.isEmpty()) {
                int size = q.size();
                int maxVal = 0;
                int cnt = 0;
                while (size-- > 0) {
                    int cur = q.poll();
                    for (int next = 0; next < 101; next++) {
                        if (graph[cur][next] && !v[next]) {
                            v[next] = true;
                            q.offer(next);
                            maxVal = Math.max(maxVal, next);
                            cnt++;
                        }
                    }
                }
                if (cnt == 0) break;
                res = maxVal;
            }
            System.out.println("#" + t + " " + res);
        }
    }
}