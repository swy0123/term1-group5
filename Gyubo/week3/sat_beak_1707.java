import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class sat_beak_1707 {

    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            flag = false;

            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 1; i <= v; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                map.get(num1).add(num2);
                map.get(num2).add(num1);
            }

            int[] visited = new int[v + 1];
            visited[0] = 1;

            for (int i = 1; i <= v; i++) {
                if (visited[i] == 0){
                    dfs(i, 0, visited, map);
                }
            }

            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    private static void dfs(int currentValue, int prevValue, int[] visited, Map<Integer, List<Integer>> map) {
        if (flag) {
            return;
        }

        List<Integer> nexts = map.get(currentValue);
        visited[currentValue] = visited[prevValue] * -1;

        for (Integer next : nexts) {
            if (visited[next] == visited[currentValue]) {
                flag = true;
                return;
            }
            if (visited[next] != 0) {
                continue;
            }
            dfs(next, currentValue, visited, map);
        }
    }

}
