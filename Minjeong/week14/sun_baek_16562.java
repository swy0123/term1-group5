import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class sun_baek_16562 {
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int p = find(parents[i]);
            if (!map.containsKey(p)) map.put(p, cost[i]);
            else {
                int curCost = map.get(p);
                map.put(p, Math.min(curCost, cost[i]));
            }
        }

        int sum = 0;
        for (int c : map.keySet()) {
            sum += map.get(c);
        }

        if (sum <= k) System.out.println(sum);
        else System.out.println("Oh no");
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        parents[pb] = parents[pa];
    }
}
