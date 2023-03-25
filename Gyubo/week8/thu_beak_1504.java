import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 특정한 최단 경로
public class thu_beak_1504 {

    static class Vertex implements Comparable<Vertex> {

        int e;
        int cost;

        public Vertex(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Vertex{" + "e=" + e + ", cost=" + cost + '}';
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Map<Integer, List<Vertex>> graph = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(n1).add(new Vertex(n2, cost));
            graph.get(n2).add(new Vertex(n1, cost));
        }
        st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        // 시작점 dijk -> d1 과 d2중 가까운 점 고르기
        // 도착점 dijk -> d1 과 d2중 가까운 점 고르기
        // d1 -> d2 dijk

        int[] startDist = new int[n + 1];
        dijkstra(graph, n, 1, startDist);
        int[] endDist = new int[n + 1];
        dijkstra(graph, n, n, endDist);
        int[] tmpDist = new int[n + 1];
        dijkstra(graph, n, d1, tmpDist);

        int value1 = check1(d1, d2, startDist, endDist, tmpDist);
        int value2 = check2(d1, d2, startDist, endDist, tmpDist);

        int answer = Math.min(value1,value2);
        if(answer== Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }

    private static int check1(int d1, int d2, int[] startDist, int[] endDist, int[] tmpDist) {
        int answer = 0;
        int value = 0;

        value = checkRoute(startDist[d1]);
        if (value == -1) {
            return Integer.MAX_VALUE;
        }
        answer += value;
        value = checkRoute(tmpDist[d2]);
        if (value == -1) {
            return Integer.MAX_VALUE;
        }
        answer += value;
        value = checkRoute(endDist[d2]);
        if (value == -1) {
            return Integer.MAX_VALUE;
        }
        answer += value;
        return answer;
    }

    private static int check2(int d1, int d2, int[] startDist, int[] endDist, int[] tmpDist) {
        int answer = 0;
        int value = 0;

        value = checkRoute(startDist[d2]);
        if (value == -1) {
            return Integer.MAX_VALUE;
        }
        answer += value;
        value = checkRoute(tmpDist[d2]);
        if (value == -1) {
            return Integer.MAX_VALUE;
        }
        answer += value;
        value = checkRoute(endDist[d1]);
        if (value == -1) {
            return Integer.MAX_VALUE;
        }
        answer += value;
        return answer;
    }


    private static int checkRoute(int value) {
        if (value != Integer.MAX_VALUE) {
            return value;
        } else {
            return -1;
        }
    }

    private static void dijkstra(Map<Integer, List<Vertex>> graph, int n, int startNode, int[] dist) {
        for (int i = 1; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        q.add(new Vertex(startNode, 0));
        dist[startNode] = 0;

        while (!q.isEmpty()) {
            Vertex current = q.poll();

            if (visited[current.e]) {
                continue;
            }
            visited[current.e] = true;

            List<Vertex> nexts = graph.get(current.e);
            for (Vertex next : nexts) {
                if (dist[next.e] > next.cost + dist[current.e]) {
                    dist[next.e] = next.cost + dist[current.e];
                    q.add(new Vertex(next.e, dist[next.e]));
                }
            }
        }
    }
}