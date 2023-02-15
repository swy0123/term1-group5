import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

// 단지번호 붙이기
public class tue_beak_2667 {

    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final List<Integer> lst = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] table = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                table[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        int crowd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1) {
                    crowd++;
                    bfs(new int[]{i, j}, table);
                }
            }
        }
        System.out.println(crowd);
        Collections.sort(lst);
        for (Integer i : lst) {
            System.out.println(i);
        }

    }

    private static void bfs(int[] coord, int[][] table) {
        int count = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(coord);

        while (!q.isEmpty()) {
            int[] currentCoord = q.poll();
            int cy = currentCoord[0];
            int cx = currentCoord[1];
            if (table[cy][cx] == 0) {
                continue;
            }
            table[cy][cx] = 0;
            count++;

            for (int i = 0; i < move.length; i++) {
                int ny = cy + move[i][0];
                int nx = cx + move[i][1];

                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }
                q.add(new int[]{ny, nx});
            }
        }
        lst.add(count);
    }
}