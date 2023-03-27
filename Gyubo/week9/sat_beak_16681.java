import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 등산
public class sat_beak_16681 {

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

    private static final long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] map = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, List<Vertex>> graph = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(node1).add(new Vertex(node2, dist));
            graph.get(node2).add(new Vertex(node1, dist));
        }

        long[] startDist = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            startDist[i] = INF;
        }
        startDist[1] = 0;

        long[] endDist = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            endDist[i] = INF;
        }
        endDist[N] = 0;

        dijkstra(N, map, graph, startDist, 1);
        dijkstra(N, map, graph, endDist, N);

        for (int i = 2; i < N; i++) {
            if (startDist[i] == INF) {
                continue;
            }
            startDist[i] = map[i] * E - startDist[i] * D;
        }
        for (int i = 2; i < N; i++) {
            if (endDist[i] == INF) {
                continue;
            }
            endDist[i] = endDist[i] * D;
        }

        long answer = Long.MIN_VALUE;
        for (int i = 2; i < N; i++) {
            if (startDist[i] != INF && endDist[i] != INF) {
                answer = Math.max(answer, startDist[i] - endDist[i]);
            }
        }
        if (answer == Long.MIN_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(answer);
        }
    }

    private static void dijkstra(int N, int[] map, Map<Integer, List<Vertex>> graph, long[] dist, int startPoint) {
        boolean[] visited = new boolean[N + 1];

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        q.add(new Vertex(startPoint, 0));

        while (!q.isEmpty()) {
            Vertex current = q.poll();

            if (visited[current.e]) {
                continue;
            }
            visited[current.e] = true;

            List<Vertex> nexts = graph.get(current.e);
            for (Vertex next : nexts) {
                // 증가하는 방향
                if (map[current.e] < map[next.e]) {
                    if (dist[next.e] > dist[current.e] + next.dist) {
                        dist[next.e] = dist[current.e] + next.dist;
                        q.add(new Vertex(next.e, dist[next.e]));
                    }
                }
            }
        }
    }
}