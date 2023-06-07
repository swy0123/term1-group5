import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class mon_beak_1967 {

    private static final Map<Integer, List<int[]>> graph = new HashMap<>();
    private static int maxValue = Integer.MIN_VALUE;
    private static int node1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sc;

        int nodeSize = Integer.parseInt(br.readLine());

        if (nodeSize == 1) {
            System.out.println(0);
            return;
        }
        for (int node = 1; node <= nodeSize; node++) {
            graph.put(node, new ArrayList<int[]>());
        }

        for (int node = 1; node < nodeSize; node++) {
            sc = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(sc.nextToken());
            int node2 = Integer.parseInt(sc.nextToken());
            int weight = Integer.parseInt(sc.nextToken());

            graph.get(node1).add(new int[]{node2, weight});
            graph.get(node2).add(new int[]{node1, weight});
        }

        dfs(1, new boolean[nodeSize + 1], 0, 1);
        maxValue = Integer.MIN_VALUE;
        dfs(node1, new boolean[nodeSize + 1], 0, node1);
        System.out.println(maxValue);
    }

    private static void dfs(int node, boolean[] visited, int weight, int startNode) {
        visited[node] = true;
        List<int[]> nextNodes = graph.get(node);

        if (startNode != node) {
            if (nextNodes.size() == 1) {
                // 끝단노드
                if (weight > maxValue) {
                    maxValue = weight;
                    node1 = node;
                }
                return;
            }
        }

        for (int[] nextNodeInfo : nextNodes) {
            int nextNode = nextNodeInfo[0];
            int nextNodeWeight = nextNodeInfo[1];

            if (visited[nextNode]) {
                continue;
            }
            dfs(nextNode, visited, weight + nextNodeWeight, startNode);
        }
    }
}