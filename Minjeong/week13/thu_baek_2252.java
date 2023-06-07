import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 줄 세우기
public class thu_baek_2252 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 키 비교 횟수

        int[] degree = new int[n + 1];
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            degree[b] += 1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int next : list[cur]) {
                degree[next] -= 1;
                if (degree[next] == 0) q.offer(next);
            }
        }
    }
}
