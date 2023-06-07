import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단 경로 구하기2
public class mon_beak_11779 {


    static class Vertex implements Comparable<Vertex> {

        private int e;
        private long dist;

        public Vertex(int e, long dist) {
            this.e = e;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "e=" + e +
                    ", dist=" + dist +
                    '}';
        }

        @Override
        public int compareTo(Vertex o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;

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
                    .add(new Vertex(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        int[] parents = new int[n + 1];

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        long[] dist = new long[n + 1];
        for (int i = 1; i < dist.length; i++) {
            dist[i] = Long.MAX_VALUE / 2;
        }
        dist[startPoint] = 0;
        q.add(new Vertex(startPoint, 0));

        while (!q.isEmpty()) {
            Vertex current = q.poll();

            if (visited[current.e]) {
                continue;
            }
            visited[current.e] = true;

            List<Vertex> nexts = graph.get(current.e);
            for (Vertex next : nexts) {
                if (dist[next.e] > dist[current.e] + next.dist) {
                    dist[next.e] = dist[current.e] + next.dist;
                    parents[next.e] = current.e;
                    q.add(new Vertex(next.e, dist[next.e]));
                }
            }
        }

        findParent(endPoint, parents);
        System.out.println(dist[endPoint]);
        System.out.println(count);
        System.out.println(sb.toString());

    }

    private static void findParent(int vertex, int[] parents) {
        count++;
        if (parents[vertex] == 0) {
            sb.append(vertex);
            sb.append(" ");
        } else {
            findParent(parents[vertex], parents);
            sb.append(vertex);
            sb.append(" ");
        }
    }
}
