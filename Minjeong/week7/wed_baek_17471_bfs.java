import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] population;
    static List<Integer>[] list;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        list = new ArrayList[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
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

    // 공집합을 제외한 진부분집합 구하기
    private static void powerSet(int idx, boolean[] v, int cnt) {
        if (cnt > n / 2) return;
        if (idx == n + 1) {
            if (cnt == 0 || cnt == n) return;
            boolean[] res = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (v[i]) res[i] = true;
            }
            // 만들어진 두 선거구에 대한 인구차 최솟값
            result = Math.min(result, solve(res));
            return;
        }

        powerSet(idx + 1, v, cnt);
        v[idx] = true;
        powerSet(idx + 1, v, cnt + 1);
        v[idx] = false;
    }

    // 두 개의 선거구로 나뉠 수 있는지 파악하고 인구 수의 차 리턴
    private static int solve(boolean[] res) {
        List<Integer>[] seongeogu = new ArrayList[2];
        seongeogu[0] = new ArrayList<>();
        seongeogu[1] = new ArrayList<>();

        int sum1 = 0, sum2 = 0;
        // make-set && 두 선거구에 대한 인구수를 구함
        for (int i = 1; i <= n; i++) {
            if (!res[i]) {
                seongeogu[0].add(i);
                sum1 += population[i];
            } else {
                seongeogu[1].add(i);
                sum2 += population[i];
            }
        }

        // 각각의 선거구마다, 선거구 내의 지역들이 모두 연결되어 있는지 확인(bfs)
        for (List<Integer> regions : seongeogu) {
            if (!checkAllConnected(regions)) return Integer.MAX_VALUE;
        }

        return Math.abs(sum1 - sum2);
    }

    private static boolean checkAllConnected(List<Integer> regions) {
        boolean[] v = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int start = regions.get(0);
        q.offer(start);
        v[start] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list[cur]) {
                if (!v[next] && regions.contains(next)) {
                    v[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt == regions.size();
    }
}