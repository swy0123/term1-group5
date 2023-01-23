import java.util.Scanner;

class Participant {
    int x;
    int y;
    int cnt;

    public Participant(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Solution {
    static int[][] movement = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            String[][] arr = new String[x][y];
            Participant[] participants = new Participant[n];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    arr[i][j] = sc.next();
                }
            }

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int c = sc.nextInt();
                participants[i] = new Participant(a, b, c);
            }

            int trapCnt = sc.nextInt();
            for (int i = 0; i < trapCnt; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                arr[a][b] = null;
            }

            int money = 0;
            for (Participant participant : participants) {
                money -= 1000;
                int nx = participant.x;
                int ny = participant.y;
                int jumpCnt = participant.cnt;
                while (jumpCnt-- > 0) {
                    int dir = arr[nx][ny].charAt(0) - '0';
                    int jumpDist = arr[nx][ny].charAt(1) - '0';
                    nx += (movement[dir - 1][0] * jumpDist);
                    ny += (movement[dir - 1][1] * jumpDist);
                    if (nx < 0 || nx >= x || ny < 0 || ny >= y || arr[nx][ny] == null) break;
                    if (jumpCnt == 0) money += (Integer.parseInt(arr[nx][ny]) * 100);
                }
            }

            System.out.println("#" + testCase + " " + money);
        }
    }
}
