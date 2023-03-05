import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소비용 구하기
public class sun_beak_1916 {

    static class Vertex implements Comparable<Vertex> {

        int e;
        int cost;

        public Vertex(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "e=" + e +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, List<Vertex>> graph = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken()))
                    .add(new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        q.add(new Vertex(start, 0));

        while (!q.isEmpty()) {
            Vertex cur = q.poll();

            if (visited[cur.e]) {
                continue;
            }
            visited[cur.e] = true;

            List<Vertex> nexts = graph.get(cur.e);
            for (Vertex next : nexts) {
                if (dist[next.e] > next.cost + dist[cur.e]) {
                    dist[next.e] = next.cost + dist[cur.e];
                    q.add(new Vertex(next.e, dist[next.e]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}
