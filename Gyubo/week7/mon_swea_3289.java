import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로소 집합
public class mon_swea_3289 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] parents = new int[n + 1];

            // 초기화
            for (int i = 1; i < n + 1; i++) {
                parents[i] = i;
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if (command == 0) {
                    union(parents, num1, num2);
                }
                if (command == 1) {
                    System.out.print(check(parents, num1, num2));
                }
            }
            System.out.println();
        }
    }

    private static int check(int[] parents, int num1, int num2) {
        int p1 = findParent(parents, num1);
        int p2 = findParent(parents, num2);

        if (p1 == p2) {
            return 1;
        }
        return 0;
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