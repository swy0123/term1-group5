import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집합의 표현
public class sun_beak_1717 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (com == 0) {
                union(num1, num2, parent);
            } else {
                if (findParent(num1, parent) == findParent(num2, parent)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int num1, int num2, int[] parent) {
        int p1 = findParent(num1, parent);
        int p2 = findParent(num2, parent);

        parent[p2] = p1;
    }

    private static int findParent(int num, int[] parent) {
        if (parent[num] == num) {
            return num;
        } else {
            return parent[num] = findParent(parent[num], parent);
        }
    }
}
