import java.util.Scanner;

public class thu_beak_9663 {

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] visited = new int[n];

        dfs(0, n, visited);
        System.out.println(answer);

    }

    private static void dfs(int depth, int n, int[] visited) {
        // 정상 종료조건
        if (depth == n) {
            answer++;
            return;
        }

        // dfs 동작
        for (int i = 0; i < n; i++) {
            if (!checkPosition(i, depth, visited)) {
                continue;
            }
            visited[depth] = i;
            dfs(depth + 1, n, visited);
        }
    }

    private static boolean checkPosition(int x, int y, int[] visited) {
        for (int i = 0; i < y; i++) {
            if (visited[i] == x) {
                return false;
            }
            if (Math.abs(x - visited[i]) == Math.abs(y - i)) {
                return false;
            }
        }
        return true;
    }
}
