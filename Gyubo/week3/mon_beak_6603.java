import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mon_beak_6603 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            String firstInput = st.nextToken();
            if (firstInput.equals("0")) {
                return;
            }

            int n = Integer.parseInt(firstInput);
            int[] arr = new int[n];
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 인풋

            combinations(arr, visited, 6, 0);
            System.out.println();
        }
    }

    private static void combinations(int[] arr, boolean[] visited, int depth, int index) {
        if (depth == 0) {
            // 탐색을 다한 경우
            print(arr, visited);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            visited[i] = true;
            combinations(arr, visited, depth - 1, i + 1);
            visited[i] = false;
        }
    }

    private static void print(int[] arr, boolean[] visited) {
        for (int i = 0; i < arr.length; i++){
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}