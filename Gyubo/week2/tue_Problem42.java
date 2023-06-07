import java.util.Scanner;

public class tue_Problem42 {

    private static final int[][] move = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int tc = 1; tc < testCase + 1; tc++) {
            int n = sc.nextInt();
            int y = sc.nextInt();
            int x = sc.nextInt();
            int jumperNum = sc.nextInt();

            int[][] table = new int[n + 1][n + 1];

            for (int i = 0; i < jumperNum; i++) {
                int jumperY = sc.nextInt();
                int jumperX = sc.nextInt();

                table[jumperY][jumperX] = -1;
            }

            int moveNum = sc.nextInt();

            Loop:
            for (int i = 0; i < moveNum; i++) {
                int dir = sc.nextInt();
                int length = sc.nextInt();

                for (int j = 0; j < length; j++) {
                    int dx = move[dir][0];
                    int dy = move[dir][1];

                    x += dx;
                    y += dy;

                    if (x <= 0 || x > n || y <= 0 || y > n) {
                        x = 0;
                        y = 0;
                        break Loop;
                    }

                    if (table[y][x] == -1) {
                        x = 0;
                        y = 0;
                        break Loop;
                    }
                }

            }
            System.out.println("#" + tc + " " + y + " " + x);
        }
    }
}
