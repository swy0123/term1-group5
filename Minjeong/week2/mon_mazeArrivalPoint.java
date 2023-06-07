import java.util.Scanner;

class Move {
    int dir;
    int cnt;

    public Move(int dir, int cnt) {
        this.dir = dir;
        this.cnt = cnt;
    }
}

// #2 테케 질문
public class Solution {
    static int[][] movement = { {-1, 0} , {0, 1}, {1, 0}, {0, -1} };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int jumperCnt = sc.nextInt();
            boolean[][] arr = new boolean[n + 1][n + 1];
            for (int i = 0; i < jumperCnt; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a][b] = true;
            }

            int moveCnt = sc.nextInt();
            Move[] moves = new Move[moveCnt];
            for (int i = 0; i < moveCnt; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                moves[i] = new Move(a, b);
            }

            int nx = x, ny = y;
            for (Move move : moves) {
                int dir = move.dir - 1;
                int cnt = move.cnt;
                nx += (movement[dir][0] * cnt);
                ny += (movement[dir][1] * cnt);
                System.out.println("nx: " + nx + ", ny: " + ny);
                if (nx < 1 || nx > n || ny < 1 || ny > n || arr[nx][ny]) {
                    nx = ny = 0;
                    break;
                }
            }

            System.out.println("#" + testCase + " " + nx + " " + ny);
        }
    }
}
