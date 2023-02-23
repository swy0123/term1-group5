import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 무선 충전
// 거리공식이 있는 문제의 경우
// 맵을 만들지 말고 공식을 이용해 탐색한다.
public class wed_swea_5644 {

    static class Table {

        public List<Integer> beacons;

        public Table() {
            super();
            this.beacons = new ArrayList<>();
        }

        @Override
        public String toString() {
            return beacons + " ";
        }

    }

    static class User {

        public int y;
        public int x;

        public User(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }

    }

    private static final int[][] move = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int[] powerArray = new int[8];
    private static int score;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < testCase + 1; tc++) {
            score = 0;
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            Table[][] table = new Table[11][11];
            for (int i = 1; i < 11; i++) {
                for (int j = 1; j < 11; j++) {
                    table[i][j] = new Table();
                }
            }
            int[][] movecm = new int[2][m];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    movecm[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int beacon = 0; beacon < a; beacon++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int area = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());

                makeTable(table, beacon, x, y, area, power);
            }

            User user1 = new User(1, 1);
            User user2 = new User(10, 10);
            updateScore(table, 1, 1, 10, 10);

            for (int i = 0; i < m; i++) {
                // 유저 1의 포지션
                int cm1 = movecm[0][i];
                int ny1 = user1.y + move[cm1][0];
                int nx1 = user1.x + move[cm1][1];

                // 유저 2의 포지션
                int cm2 = movecm[1][i];
                int ny2 = user2.y + move[cm2][0];
                int nx2 = user2.x + move[cm2][1];

                updateScore(table, ny1, nx1, ny2, nx2);
                user1.y = ny1;
                user1.x = nx1;
                user2.y = ny2;
                user2.x = nx2;
            }
            System.out.println("#" + tc + " " + score);
        }
    }

    private static void updateScore(Table[][] table, int ny1, int nx1, int ny2, int nx2) {
        int tmp = 0;
        for (Integer beacon1 : table[ny1][nx1].beacons) {
            tmp = Math.max(tmp, powerArray[beacon1]);
        }
        for (Integer beacon2 : table[ny2][nx2].beacons) {
            tmp = Math.max(tmp, powerArray[beacon2]);
        }
        for (Integer beacon1 : table[ny1][nx1].beacons) {
            for (Integer beacon2 : table[ny2][nx2].beacons) {
                if (beacon1 == beacon2) {
                    tmp = Math.max(tmp, powerArray[beacon1]);
                    continue;
                }
                tmp = Math.max(tmp, powerArray[beacon1] + powerArray[beacon2]);
            }
        }
        score += tmp;
    }

    private static void makeTable(Table[][] table, int beacon, int x, int y, int area, int power) {
        powerArray[beacon] = power;
        for (int dy = area; dy >= 0; dy--) {
            int ny = y - dy;
            int startX = x - area + dy;
            int endX = x + area - dy;
            for (int nx = startX; nx <= endX; nx++) {
                if (ny < 1 || nx < 1 || ny >= 11 || nx >= 11) {
                    continue;
                }
                table[ny][nx].beacons.add(beacon);
            }
        }
        for (int dy = area; dy > 0; dy--) {
            int ny = y + dy;
            int startX = x - area + dy;
            int endX = x + area - dy;
            for (int nx = startX; nx <= endX; nx++) {
                if (ny < 1 || nx < 1 || ny >= 11 || nx >= 11) {
                    continue;
                }
                table[ny][nx].beacons.add(beacon);
            }
        }
    }
}
