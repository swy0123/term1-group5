import java.util.*;
import java.io.*;

public class tue_codetree_나무타이쿤 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int[][] map, del = {{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};
    static int[] moves, cnts;
    static List<Node> growth = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        moves = new int[m];
        cnts = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            moves[i] = Integer.parseInt(st.nextToken()) - 1;
            cnts[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 2; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                growth.add(new Node(i, j));
            }
        }

        for (int i = 0; i < m; i++) {
            solve(i);
        }

        // 계산
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += map[i][j];
            }
        }
        System.out.println(cnt);
    }

    private static void solve(int year) {
        // 1. 영양제 이동
        moving(year);

        // 2. 영양제 투입
        // 2-1. 영양제 부분 리브로수 +1 성장
        for (Node node : growth) {
            map[node.x][node.y] += 1;
        }

        // 2-2. 영양제 부분 리브로수는 대각선 인접 리브로수 수만큼 높이 추가 증가
        extraHeight();

        // 특수 영양제 땅 제외 높이 2 이상 니브로수 높이 2씩 잘라내고 영양제 올리기
        boolean[][] v = new boolean[n][n];
        for (Node node : growth) {
            v[node.x][node.y] = true;
        }
        growth.clear();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    growth.add(new Node(i, j));
                }
            }
        }
    }

    private static void moving(int year) {
        int dir = moves[year];
        int cnt = cnts[year];

        for (Node node : growth) {
            int nx = node.x;
            int ny = node.y;
            int t = cnt;
            while (t-- > 0) {
                nx += del[dir][0];
                ny += del[dir][1];
                if (nx == n) nx = 0;
                if (ny == n) ny = 0;
                if (nx == -1) nx = n - 1;
                if (ny == -1) ny = n - 1;
            }
            node.x = nx;
            node.y = ny;
        }
    }

    private static void extraHeight() {
        for (Node node : growth) {
            int cnt = 0;
            for (int i = 1; i < 8; i += 2) {
                int nx = node.x + del[i][0];
                int ny = node.y + del[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] == 0) continue;
                cnt++;
            }
            map[node.x][node.y] += cnt;
        }
    }
}