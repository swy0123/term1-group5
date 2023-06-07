import java.util.Scanner;

class WaterStrider {
    int x;
    int y;
    int direction;

    public WaterStrider(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}

public class Solution {
    static int[][] movement = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int n, cnt;
            n = sc.nextInt();
            cnt = sc.nextInt();
            WaterStrider[] waterStriders = new WaterStrider[cnt];
            boolean[][] arr = new boolean[n][n];

            for (int i = 0; i < cnt; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int direction = sc.nextInt();
                waterStriders[i] = new WaterStrider(x, y, direction);
            }

            for (WaterStrider waterStrider: waterStriders) {
                int x = waterStrider.x;
                int y = waterStrider.y;
                int dir = waterStrider.direction - 1;
                int jump = 3;
                if (arr[x][y]) continue;
                for (int i = 0; i < 3; i++, jump--) {
                    x += (movement[dir][0] * jump);
                    y += (movement[dir][1] * jump);
                    if (x < 0 || x >= n || y < 0 || y >= n || arr[x][y]) {
                        cnt--;
                        break;
                    }
                    if (jump == 1) arr[x][y] = true;
                }
            }
            System.out.println("#" + testCase + " " + cnt);
        }
    }
}
