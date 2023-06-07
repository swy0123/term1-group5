import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 네트워크 연결하기
public class sun_beak_1922 {

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
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(num1).add(new Vertex(num2, cost));
            graph.get(num2).add(new Vertex(num1, cost));
        }

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        q.addAll(graph.get(1));
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int sum = 0;
        int cnt = 0;
        while (cnt < n - 1 && !q.isEmpty()) {
            Vertex p = q.poll();

            if (visited[p.e]) {
                continue;
            }

            visited[p.e] = true;
            sum += p.cost;
            cnt++;
            q.addAll(graph.get(p.e));
        }
        System.out.println(sum);
    }
}
