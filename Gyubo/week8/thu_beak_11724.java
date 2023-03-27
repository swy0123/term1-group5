import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결요소의 개수
public class thu_beak_11724 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parents = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            union(parents, node1, node2);
        }

        for (int i = 1; i < n + 1; i++) {
            int index = findParent(parents, i);
            visited[index] = true;
        }

        int answer = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void union(int[] arr, int node1, int node2) {
        int p1 = findParent(arr, node1);
        int p2 = findParent(arr, node2);

        arr[p1] = p2;
    }

    private static int findParent(int[] arr, int node) {
        if (arr[node] == node) {
            return node;
        } else {
            return arr[node] = findParent(arr, arr[node]);
        }
    }
}
