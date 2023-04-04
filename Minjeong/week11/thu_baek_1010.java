import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
public class thu_baek_1010 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.c, o.c);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map, del = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int t = 1; ; t++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) return;
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][][] v = new boolean[n][n][4];
            v[0][0][1] = v[0][0][3] = true;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, map[0][0]));
            Node cur = null;
            while (!pq.isEmpty()) {
                cur = pq.poll();
                if (cur.x == n - 1 && cur.y == n - 1) break;

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + del[i][0];
                    int ny = cur.y + del[i][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny][i]) continue;
                    v[nx][ny][i] = true;
                    pq.offer(new Node(nx, ny, cur.c + map[nx][ny]));
                }
            }

            System.out.println("Problem " + t + ": " + cur.c);
        }
    }
}
