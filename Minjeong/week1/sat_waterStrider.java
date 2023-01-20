import java.util.Scanner;

class WaterStrider {
    int x;
    int y;
    int direction;
    int num;

    public WaterStrider(int x, int y, int direction, int num) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.num = num;
    }
}

public class Solution {
    static int[][] movement = { {1, 0}, {0, 1} };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int n, cnt, res = 0;
            n = sc.nextInt();
            cnt = sc.nextInt();
            WaterStrider[] waterStriders = new WaterStrider[cnt];
            boolean[][] arr = new boolean[n][n];

            for (int i = 0; i < cnt; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int direction = sc.nextInt();
                waterStriders[i] = new WaterStrider(x, y, direction, i + 1);
            }

            out: for (WaterStrider waterStrider: waterStriders) {
                int x = waterStrider.x;
                int y = waterStrider.y;
                int dir = waterStrider.direction - 1;
                int jump = 3;
                for (int i = 0; i < 3; i++, jump--) {
                    x += (movement[dir][0] * jump);
                    y += (movement[dir][1] * jump);
                    if (x < 0 || x >= n || y < 0 || y >= n) continue;
                    if (arr[x][y]) {
                        res = waterStrider.num;
                        break out;
                    }
                    arr[x][y] = true;
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}
