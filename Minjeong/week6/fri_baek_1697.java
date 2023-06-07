import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(find(n, k, new boolean[100001]));
    }

    private static int find(int x, int k, boolean[] v) {
        int time = 0;
        Queue<Integer> q = new ArrayDeque<>();
        v[x] = true;
        q.offer(x);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == k) return time;
                if (cur + 1 <= 100000 && !v[cur + 1]) {
                    v[cur + 1] = true;
                    q.offer(cur + 1);
                }
                if (cur - 1 >= 0 && !v[cur - 1]) {
                    v[cur - 1] = true;
                    q.offer(cur - 1);
                }
                if (cur * 2 <= 100000 && !v[cur * 2]) {
                    v[cur * 2] = true;
                    q.offer(cur * 2);
                }
            }
            time++;
        }
        return -1;
    }
}