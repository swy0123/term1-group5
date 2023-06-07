import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 공항
public class mon_beak_10775 {

    private static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int airplane = Integer.parseInt(br.readLine());
            solve(parents, airplane);
            count++;
        }
        System.out.println(count);
    }

    private static void solve(int[] parents, int airplane) {
        if (findParent(parents, airplane) == -1) {
            System.out.println(count);
            System.exit(0);
        }
    }

    private static int findParent(int[] parents, int airplane) {
        if (parents[airplane] == airplane) {
            parents[airplane]--;
            return parents[airplane];
        } else {
            parents[airplane] = findParent(parents, parents[airplane]);
        }
        return parents[airplane];
    }

}