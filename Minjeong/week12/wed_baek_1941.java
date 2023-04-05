import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 소문난 칠공주
public class wed_baek_1941 {
    static char[][] arr = new char[5][5];
    static int[][] del = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int res;
    static Set<String> s = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            arr[i] =  br.readLine().toCharArray();
        }

        solve(0, new boolean[5][5]);
        System.out.println(res);
    }

    private static void solve(int depth, boolean[][] v) {
        if (depth == 7) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (v[i][j]) {
                        sb.append(i).append(j);
                        if (arr[i][j] == 'S') cnt++;
                    }
                }
            }

            if (cnt >= 4 && !s.contains(sb.toString())) {
                s.add(sb.toString());
                res++;
            }
            return;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (depth != 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + del[k][0];
                        int ny = j + del[k][1];
                        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                        if (v[nx][ny]) cnt++;
                    }
                    if (cnt == 0) continue;
                }
                if (!v[i][j]) {
                    v[i][j] = true;
                    solve(depth + 1, v);
                    v[i][j] = false;
                }
            }
        }
    }
}