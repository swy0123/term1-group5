import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 별자리 만들기
public class wed_beak_4386 {

    static class Vertex implements Comparable<Vertex> {

        int e;
        double cost;

        public Vertex(int e, double cost) {
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
            double v = this.cost - o.cost;
            if (v > 0) {
                return 1;
            } else if (v == 0) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        double[][] input = new double[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            input[i][0] = y;
            input[i][1] = x;
        }

        Map<Integer, List<Vertex>> graph = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < input.length; i++) {
            List<Vertex> list = graph.get(i);
            double y1 = input[i][0];
            double x1 = input[i][1];

            for (int j = 0; j < input.length; j++) {
                if (i == j) {
                    continue;
                }
                double y2 = input[j][0];
                double x2 = input[j][1];
                list.add(new Vertex(j, Math.sqrt(Math.pow(y1 - y2, 2) + Math.pow(x1 - x2, 2))));
            }
        }

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        q.addAll(graph.get(0));

        double sum = 0;
        int count = 0;
        while(!q.isEmpty() && count < n -1){
            Vertex p = q.poll();

            if (visited[p.e]){
                continue;
            }

            visited[p.e] = true;
            sum += p.cost;
            q.addAll(graph.get(p.e));
        }

        System.out.printf("%.2f", sum);
    }
}
