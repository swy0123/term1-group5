import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Block {
    int x;
    int y;
    int num;

    public Block(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

public class Solution {
    static int[][] del = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    static int n, w, h, minV;
    static int[][] space;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            space = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    space[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            minV = Integer.MAX_VALUE;
            dropComb(0, new int[n]);

            System.out.println("#" + testCase + " " + minV);
        }
    }

    // 1. 구슬 떨어뜨릴 위치 정하기(중복순열)
    private static void dropComb(int depth, int[] res) {
        if (minV == 0) return;
        if (depth == n) {
            int[][] tmp = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    tmp[i][j] = space[i][j];
                }
            }
            simulStart(res, tmp);
            return;
        }

        for (int i = 0; i < w; i++) {
            if (minV == 0) return;
            res[depth] = i;
            dropComb(depth + 1, res);
            res[depth] = 0;
        }
    }

    private static void simulStart(int[] res, int[][] space) {
        // i번째 구슬 떨어뜨리기
        int cnt;
        for (int i = 0; i < n; i++) {
            cnt = dropMarble(space, res[i]);
            if (cnt == 0) {
                minV = 0;
                return;
            }
        }

        minV = Math.min(minV, countBlocks(space));
    }

    private static int dropMarble(int[][] space, int col) {
        // col열에 구슬 떨어뜨리기
        int startX = -1;
        for (int row = 0; row < h; row++) {
            if (space[row][col] != 0) {
                startX = row;
                break;
            }
        }

        // 맞은 벽돌이 없다면 남은 벽돌 수 리턴
        if (startX == -1) return countBlocks(space);

        // 시작 벽돌로부터 연쇄적으로 벽돌 깨기
        bfs(new Block(startX, col, space[startX][col]), space);

        // 벽돌 밀기
        move(space);

        return countBlocks(space);
    }

    private static void bfs(Block block, int[][] space) {
        Queue<Block> q = new ArrayDeque<>();

        q.offer(block);
        space[block.x][block.y] = 0;

        while (!q.isEmpty()) {
            Block cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x;
                int ny = cur.y;
                // blockNum 범위만큼 q에 Block 넣기
                for (int j = 0; j < cur.num - 1; j++) {
                    nx += del[i][0];
                    ny += del[i][1];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) break;
                    if (space[nx][ny] != 0) {
                        q.offer(new Block(nx, ny, space[nx][ny]));
                        space[nx][ny] = 0;
                    }
                }
            }
        }
    }

    private static void move(int[][] space) {
        Stack<Integer> stack = new Stack<>();

        for (int j = 0; j < w; j++) {
            for (int i = 0; i < h; i++) {
                if (space[i][j] != 0) {
                    stack.push(space[i][j]);
                    space[i][j] = 0;
                }
            }

            int idx = h - 1;
            while(!stack.isEmpty()) {
                space[idx--][j] = stack.pop();
            }
        }
    }

    private static int countBlocks(int[][] space) {
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (space[i][j] != 0) cnt++;
            }
        }
        return cnt;
    }
}