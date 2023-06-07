import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static boolean[] knowTruth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        knowTruth = new boolean[n + 1];
        for (int i = 0; i < k; i++) {
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>());
            for (int j = 0; j < l; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
                if (j > 0) union(list.get(i).get(j - 1), list.get(i).get(j));
            }
        }

        int cnt = 0;
        for (List<Integer> party : list) {
            boolean flag = true;
            for (int num : party) {
                if (knowTruth[find(num)]) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        System.out.println(cnt);
    }

    private static int find(int a) {
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        if (knowTruth[pb]) parents[pa] = pb;
        else parents[pb] = pa;
    }
}