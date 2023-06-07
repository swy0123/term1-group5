import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// DFS와 BFS
public class thu_beak_1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            maxValue = Math.max(Math.max(node1, node2), maxValue);
            // 초기화 작업
            map.putIfAbsent(node1, new ArrayList<>());
            map.putIfAbsent(node2, new ArrayList<>());
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }

        // 정렬
        for (List<Integer> value : map.values()) {
            Collections.sort(value);
        }

        if (!map.containsKey(startNode)) {
            System.out.println(startNode);
            System.out.println(startNode);
            return;
        }
        dfs(map, startNode, new boolean[maxValue + 1]);
        System.out.println();
        bfs(map, startNode, new boolean[maxValue + 1]);
    }

    private static void dfs(Map<Integer, List<Integer>> map, int node, boolean[] visited) {
        List<Integer> nearNodes = map.get(node);
        visited[node] = true;
        System.out.print(node + " ");

        for (Integer nearNode : nearNodes) {
            if (visited[nearNode]) {
                continue;
            }
            dfs(map, nearNode, visited);
        }
    }

    private static void bfs(Map<Integer, List<Integer>> map, int startNode, boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            Integer currentNode = q.poll();
            System.out.print(currentNode + " ");
            List<Integer> nearNodes = map.get(currentNode);
            for (Integer nearNode : nearNodes) {
                if (visited[nearNode]) {
                    continue;
                }
                visited[nearNode] = true;
                q.add(nearNode);
            }
        }
    }

}
