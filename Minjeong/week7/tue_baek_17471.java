import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] population;
    static Set<Integer>[] list;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        list = new HashSet[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            list[i] = new HashSet<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        powerSet(1, new boolean[n + 1], 0);
        if (result != Integer.MAX_VALUE) System.out.println(result);
        else System.out.println(-1);
    }

    private static void powerSet(int idx, boolean[] v, int cnt) {
        if (idx == n + 1) {
            if (cnt == 0 || cnt == n) return;
            boolean[] res = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (v[i]) res[i] = true;
            }
            result = Math.min(result, solve(res));
            return;
        }

        powerSet(idx + 1, v, cnt);
        v[idx] = true;
        powerSet(idx + 1, v, cnt + 1);
        v[idx] = false;
    }

    private static int solve(boolean[] res) {
        int[] parents = new int[n + 1];
        List<Integer>[] seongeogu = new ArrayList[2];
        seongeogu[0] = new ArrayList<>();
        seongeogu[1] = new ArrayList<>();

        int sum1 = 0, sum2 = 0;
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
            if (!res[i]) {
                seongeogu[0].add(i);
                sum1 += population[i];
            } else {
                seongeogu[1].add(i);
                sum2 += population[i];
            }
        }

        for (List<Integer> regions : seongeogu) {
            for (Integer region1 : regions) {
                for (Integer region2 : regions) {
                    if (list[region1].contains(region2)) {
                        union(region1, region2, parents);
                    }
                }
            }
        }

        Set<Integer> s = new HashSet<>();
        for (int i = 1; i <= n; i++) s.add(find(i, parents));

        if (s.size() == 2) return Math.abs(sum1 - sum2);
        else return Integer.MAX_VALUE;
    }

    private static void union(int a, int b, int[] parents) {
        int pa = find(a, parents);
        int pb = find(b, parents);
        if (pa != pb) parents[pb] = pa;
    }

    private static int find(int a, int[] parents) {
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a], parents);
    }
}