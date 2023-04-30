import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 군사 이동
public class thu_baek_11085 {
    static class Node implements Comparable<Node> {
        int e;
        int c;

        public Node(int e, int c) {
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.c, this.c);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[p];
        for (int i = 0; i < p; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int t3 = Integer.parseInt(st.nextToken());
            graph[t1].add(new Node(t2, t3));
            graph[t2].add(new Node(t1, t3));
        }

        boolean[] visited = new boolean[p];
        int min = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited[c] = true;
        pq.addAll(graph[c]);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.e]) continue;
            visited[cur.e] = true;
            min = Math.min(min, cur.c);
            if (cur.e == v) break;
            pq.addAll(graph[cur.e]);
        }

        System.out.println(min);
    }
}
