import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기 상어
public class tue_baek_16236 {
    static class Node {
        int x;
        int y;


        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Shark extends Node {
        int size = 2;
        int cnt = 0;

        public Shark(int x, int y) {
            super(x, y);
        }
    }
    static int n;
    static int[][] arr, del = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        Shark shark = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new Shark(i, j);
                    arr[i][j] = 0;
                }
            }
        }

        System.out.println(solve(shark));
    }

    private static int solve(Shark shark) {
        int time = 0;
        while (true) {
            int res = bfs(shark);
            if (res == -1) return time;
            time += res;
        }
    }

    private static int bfs(Shark shark) {
        boolean[][] v = new boolean[n][n];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(shark.x, shark.y));
        v[shark.x][shark.y] = true;
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int x = -1, y = -1;
            time++;
            while (size-- > 0) {
                Node cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + del[d][0];
                    int ny = cur.y + del[d][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || v[nx][ny]) continue;
                    v[nx][ny] = true;
                    if (arr[nx][ny] != 0 && shark.size > arr[nx][ny]) {
                        if (x == -1) {
                            x = nx;
                            y = ny;
                        }
                        else if (x > nx) {
                            x = nx;
                            y = ny;
                        }
                        else if (x == nx && y > ny) {
                            x = nx;
                            y = ny;
                        }
                    }
                    else if (arr[nx][ny] == 0 || shark.size == arr[nx][ny]) q.offer(new Node(nx, ny));
                }
            }

            if (x != -1) {
                arr[x][y] = 0;
                shark.x = x;
                shark.y = y;
                shark.cnt += 1;
                if (shark.cnt == shark.size) {
                    shark.size += 1;
                    shark.cnt = 0;
                }
                return time;
            }
        }
        return -1;
    }
}
