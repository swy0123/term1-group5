import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int[][] del = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static char[][] map;
    static boolean[][] v;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) mark(i, j);
            }

            v = new boolean[n][n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j] && map[i][j] == '0') {
                        clickZero(i, j);
                        res++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j] && map[i][j] >= '1' && map[i][j] <= '8') res++;
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }

    private static void clickZero(int x, int y) {
        Queue<Pair> q = new ArrayDeque<>();
        v[x][y] = true;
        q.offer(new Pair(x, y));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + del[i][0];
                int ny = cur.y + del[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny]) continue;
                v[nx][ny] = true;
                if (map[nx][ny] == '0') q.offer(new Pair(nx, ny));
            }
        }
    }

    private static void mark(int x, int y) {
        if (map[x][y] != '.') return;

        int sCnt = countStar(x, y);
        map[x][y] = String.valueOf(sCnt).charAt(0);
    }

    private static int countStar(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + del[i][0];
            int ny = y + del[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (map[nx][ny] == '*') cnt++;
        }
        return cnt;
    }
}