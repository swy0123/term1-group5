import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 게리맨더링
public class tue_beak_17471 {

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] population = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                tmpList.add(Integer.parseInt(st.nextToken()));
            }
            graph.put(i, tmpList);
        }

        boolean[] visited = new boolean[n + 1];
        powerSet(graph, 1, visited, population);
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    private static void powerSet(Map<Integer, List<Integer>> graph, int index, boolean[] visited, int[] population) {
        if (index == visited.length) {
            boolean[] bfsVisited = new boolean[visited.length];
            int count = 0;
            for (int i = 1; i < bfsVisited.length; i++) {
                if (!bfsVisited[i]) {
                    count++;
                    bfs(i, graph, visited, bfsVisited);
                }
            }

            if (count != 2) {
                return;
            }

            updateResult(visited, population);
            return;
        }

        visited[index] = true;
        powerSet(graph, index + 1, visited, population);

        visited[index] = false;
        powerSet(graph, index + 1, visited, population);
    }

    private static void updateResult(boolean[] visited, int[] population) {
        int trueSum = 0;
        int falseSum = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                trueSum += population[i];
            } else {
                falseSum += population[i];
            }
        }
        result = Math.min(Math.abs(trueSum - falseSum), result);
    }

    private static void bfs(int region, Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] bfsVisited) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean group = visited[region];
        q.add(region);
        bfsVisited[region] = true;

        while (!q.isEmpty()) {
            Integer p = q.poll();
            List<Integer> nexts = graph.get(p);

            for (Integer next : nexts) {
                if (bfsVisited[next]) {
                    continue;
                }
                if (visited[next] == group) {
                    q.add(next);
                    bfsVisited[next] = true;
                }
            }
        }
    }
}
