import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 나만 안되는 연애
public class mon_beak_14621 {

    static class Vertex implements Comparable<Vertex> {

        private int node;
        private int dist;

        public Vertex(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "node=" + node +
                    ", dist=" + dist +
                    '}';
        }

        @Override
        public int compareTo(Vertex o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[] univ = new char[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < univ.length; i++) {
            univ[i] = st.nextToken().charAt(0);
        }

        Map<Integer, List<Vertex>> graph = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(node1).add(new Vertex(node2, dist));
            graph.get(node2).add(new Vertex(node1, dist));
        }

        // 시작 노드를 1로 설정
        PriorityQueue<Vertex> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        q.add(new Vertex(1, 0));

        int answer = 0;
        int count = 0;
        while (!q.isEmpty()) {
            Vertex current = q.poll();

            if (visited[current.node]){
                continue;
            }
            visited[current.node] = true;
            count++;

            answer += current.dist;
            List<Vertex> nexts = graph.get(current.node);
            for (Vertex next : nexts) {
                if (univ[next.node] != univ[current.node]){
                    q.add(next);
                }
            }
        }

        if (count == n) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
