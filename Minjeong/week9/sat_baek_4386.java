import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 별자리 만들기
public class sat_baek_4386 {
    static class Node {
        double x;
        double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        double c;

        public Edge(int x, int y, double c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.c, o.c);
        }
    }
    static int[] parents;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        List<Node> stars = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Float.parseFloat(st.nextToken());
            double b = Float.parseFloat(st.nextToken());
            stars.add(new Node(a, b));
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = stars.get(i).x - stars.get(j).x;
                double b = stars.get(i).y - stars.get(j).y;
                double dist = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                edges.offer(new Edge(i, j, dist));
            }
        }

        double res = 0;
        int cnt = 0;
        while (cnt < n - 1) {
            Edge cur = edges.poll();
            if (union(cur.x, cur.y)) {
                res += cur.c;
                cnt++;
            }
        }

        System.out.printf("%.2f", res);
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;
        parents[pb] = pa;
        return true;
    }
}
