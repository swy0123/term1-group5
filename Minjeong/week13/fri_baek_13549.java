import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class fri_baek_13549 {
    static class Node {
        int pos;
        int time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(n, 0));
        boolean[] v = new boolean[MAX + 1];
        v[n] = true;
        int time = MAX + 1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.pos == k) time = Math.min(time, cur.time);

            int next = cur.pos * 2;
            if (next <= MAX && !v[next]) {
                v[next] = true;
                q.offer(new Node(next, cur.time));
            }
            next = cur.pos - 1;
            if (next >= 0 && !v[next]) {
                v[next] = true;
                q.offer(new Node(next, cur.time + 1));
            }
            next = cur.pos + 1;
            if (next <= MAX && !v[next]) {
                v[next] = true;
                q.offer(new Node(next, cur.time + 1));
            }
        }

        System.out.println(time);
    }
}