import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class sat_codetree_예술성 {
    static class Node {
        int number;
        int count;

        public Node(int number) {
            this.number = number;
        }
    }
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int[][] arr, del = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += calc();
            if (i < 3) rotate();
        }
        System.out.println(sum);
    }

    private static int calc() {
        boolean[][] v = new boolean[n][n];
        char[][] tmp = new char[n][n];
        Map<Character, Node> m = new HashMap<>();

        // 1. 그룹 맵 만들면서 그룹의 숫자와 갯수를 저장한 map 구성
        char label = 'a';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j]) {
                    Node node = new Node(arr[i][j]);
                    node.count = bfs(i, j, label, tmp, v);
                    m.put(label++, node);
                }
            }
        }

        // 2. 그룹 맵을 사용해서 bfs를 돌리면서 맞닿은 변의 수 계산 후 조화로움 합을 구함
        int sum = 0;
        v = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j]) sum += bfs2(i, j, tmp, v, m);
            }
        }
        return sum;
    }

    private static int bfs(int i, int j, char label, char[][] tmp, boolean[][] v) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(i, j));
        v[i][j] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            tmp[cur.x][cur.y] = label;
            cnt++;
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + del[d][0];
                int ny = cur.y + del[d][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny] || arr[nx][ny] != arr[i][j]) continue;
                v[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }

        return cnt;
    }

    private static int bfs2(int x, int y, char[][] tmp, boolean[][] v, Map<Character, Node> groupInfo) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        v[x][y] = true;
        Map<Character, Integer> connected = new HashMap<>();

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + del[d][0];
                int ny = cur.y + del[d][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny]) continue;
                if (tmp[x][y] == tmp[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
                else {
                    if (!connected.containsKey(tmp[nx][ny])) connected.put(tmp[nx][ny], 1);
                    else connected.replace(tmp[nx][ny], connected.get(tmp[nx][ny]) + 1);
                }
            }
        }

        int sum = 0;
        for (char c : connected.keySet()) {
            Node first = groupInfo.get(tmp[x][y]);
            Node second = groupInfo.get(c);
            sum += getScore(first.count, second.count, first.number, second.number, connected.get(c));
        }
        return sum;
    }

    private static int getScore(int aCnt, int bCnt, int aNum, int bNum, int cnt) {
        return (aCnt + bCnt) * aNum * bNum * cnt;
    }

    private static void rotate() {
        rotateCross();
        rotate90(0, n / 2, 0, n / 2);
        rotate90(0, n / 2, n / 2 + 1, n);
        rotate90(n / 2 + 1, n, 0, n / 2);
        rotate90(n / 2 + 1, n, n / 2 + 1, n);
    }

    private static void rotate90(int xStart, int xEnd, int yStart, int yEnd) {
        int rotateCnt = (xEnd - xStart) / 2;
        int[][] tmp = new int[rotateCnt][];
        while (rotateCnt-- > 0) {
            tmp[rotateCnt] = new int[xEnd - xStart];
            for (int i = 0; i < (xEnd - xStart); i++) tmp[rotateCnt][i] = arr[xStart][yStart + i];

            for (int i = xStart, j = yEnd - 1; i < xEnd - 1; i++, j--) arr[xStart][j] = arr[i][yStart];

            for (int i = xStart, j = yStart; j < yEnd - 1; i++, j++) arr[i][yStart] = arr[xEnd - 1][j];

            for (int i = xEnd - 1, j = yStart; i >= xStart + 1; i--, j++) arr[xEnd - 1][j] = arr[i][yEnd - 1];

            for (int i = xEnd - 1, j = xEnd - xStart - 1; j > 0; i--, j--) arr[i][yEnd - 1] = tmp[rotateCnt][j];

            xStart++;
            xEnd--;
            yStart++;
            yEnd--;
        }
    }

    private static void rotateCross() {
        int[] tmp = new int[n / 2];
        for (int i = 0; i < n / 2; i++) tmp[i] = arr[i][n / 2];

        for (int i = 0; i < n / 2; i++) arr[i][n / 2] = arr[n / 2][n - i - 1];

        for (int i = n - 1; i >= n / 2 + 1; i--) arr[n / 2][i] = arr[i][n / 2];

        for (int i = 0; i < n / 2; i++) arr[n - i - 1][n / 2] = arr[n / 2][i];

        for (int i = 0; i < n / 2; i++) arr[n / 2][i] = tmp[i];
    }
}
