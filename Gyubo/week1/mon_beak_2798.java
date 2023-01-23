import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mon_beak_2798 {

    private static final List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Integer[] arr = new Integer[n];
        Integer[] visited = new Integer[3];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        combinations(arr, visited, 3, 0, n);
        int minusValue = Integer.MAX_VALUE;
        int result = 0;

        for (List<Integer> lst : lists) {
            int sum = lst.stream().mapToInt(Integer::intValue).sum();

            if (sum > m) {
                continue;
            }

            int tmp = m - sum;
            if (minusValue > tmp) {
                minusValue = tmp;
                result = sum;
            }
        }
        System.out.println(result);

    }

    private static void combinations(Integer[] arr, Integer[] visited, int depth, int start, int n) {
        if (depth == 0) {
            lists.add(Arrays.asList(visited.clone()));
            return;
        }

        for (int i = start; i < n; i++) {
            visited[depth - 1] = arr[i];
            combinations(arr, visited, depth - 1, i + 1, n);
        }
    }


}
