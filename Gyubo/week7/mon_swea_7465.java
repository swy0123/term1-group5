import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 창용마을 무리의 개수
public class mon_swea_7465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < testCase + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] parents = new int[n + 1];
            for (int i = 1; i < parents.length; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                union(parents, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < parents.length; i++) {
                set.add(findParent(parents, i));
            }
            System.out.println("#" + tc + " " + set.size());
        }
    }

    private static void union(int[] parents, int num1, int num2) {
        int p1 = findParent(parents, num1);
        int p2 = findParent(parents, num2);

        parents[p2] = p1;
    }

    private static int findParent(int[] parents, int num) {
        if (parents[num] == num) {
            return num;
        } else {
            return parents[num] = findParent(parents, parents[num]);
        }
    }
}
