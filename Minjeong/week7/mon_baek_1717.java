import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 0) union(a, b);
            else sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        parents[pb] = pa;
    }
}