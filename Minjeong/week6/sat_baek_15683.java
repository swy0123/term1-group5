import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, res;
    static int[][] del = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
    static char[][] map;
    static List<Pair> cctv;
    static int[][][] watch = {
            {},
            { {0}, {1}, {2}, {3} },
            { {0, 1}, {2, 3} },
            { {1, 2}, {1, 3}, {0, 3}, {0, 2} },
            { {0, 1, 2}, {1, 2, 3}, {0, 1, 3}, {0, 2, 3} },
            { {0, 1, 2, 3} }
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        cctv = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] >= '1' && map[i][j] <= '5') cctv.add(new Pair(i, j));
                if (map[i][j] == '0') res++;
            }
        }

        solve(0, res);
        System.out.println(res);
    }

    private static void solve(int idx, int cnt) {
        if (idx == cctv.size()) {
            res = Math.min(res, cnt);
            return;
        }

        Pair cur = cctv.get(idx);
        // cctv 번호에 해당하는 감시 방향(최소 1개 최대 4개) 탐색
        int[][] directions = watch[map[cur.x][cur.y] - '0'];
        for (int[] direction : directions) {
            // 감시 시작
            List<Pair> check = new ArrayList<>();
            int tmp = cnt;
            for (int j : direction) {
                int nx = cur.x + del[j][0];
                int ny = cur.y + del[j][1];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != '6') {
                    if (map[nx][ny] == '0') {
                        map[nx][ny] = '#';
                        tmp--;
                        check.add(new Pair(nx, ny));
                    }
                    nx += del[j][0];
                    ny += del[j][1];
                }
            }
            solve(idx + 1, tmp);
            // 되돌리기
            for (Pair p : check) map[p.x][p.y] = '0';
        }
    }
}