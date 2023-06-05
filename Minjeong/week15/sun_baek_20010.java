import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 악덕 영주 혜유
public class sun_baek_20010 {
    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        long c;

        public Edge(int s, int e, long c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.c, o.c);
        }
    }
    static int[] parents;
    static long maxCost;
    static int maxV;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        int cnt = 1, cost = 0;
        List<Edge> res = new ArrayList<>();

        while (cnt < n) {
            Edge edge = edges.poll();
            if (!union(edge.s, edge.e)) continue;
            res.add(edge);
            cost += edge.c;
            cnt++;
            if (cnt == n) break;
        }

        findMaxCost(res, 0, new boolean[n], 0);
        findMaxCost(res, maxV, new boolean[n], 0);

        System.out.println(cost);
        System.out.println(maxCost);
    }

    private static void findMaxCost(List<Edge> res, int v, boolean[] visit, long sum) {
        if (maxCost < sum) {
            maxCost = sum;
            maxV = v;
        }

        visit[v] = true;
        for (Edge edge : res) {
           if (edge.s == v && !visit[edge.e]) {
               findMaxCost(res, edge.e, visit, sum + edge.c);
           }
           else if (edge.e == v && !visit[edge.s]) {
                findMaxCost(res, edge.s, visit, sum + edge.c);
           }
        }
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
