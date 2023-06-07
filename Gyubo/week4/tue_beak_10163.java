import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tue_beak_10163 {

    private static final int[][] table = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] results = new int[n + 1];
        for (int paper = 1; paper <= n; paper++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int yLength = Integer.parseInt(st.nextToken());
            int xLength = Integer.parseInt(st.nextToken());

            for (int i = y; i < y + yLength; i++) {
                for (int j = x; j < x + xLength; j++) {
                    table[i][j] = paper;
                }
            }
        }

        for (int[] ints : table) {
            for (int anInt : ints) {
                results[anInt]++;
            }
        }

        for (int i = 1; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
