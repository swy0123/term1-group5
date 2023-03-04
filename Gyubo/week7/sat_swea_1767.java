import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sat_swea_1767 {

    static class Core {

        int y;
        int x;

        public Core(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static final int[][] vector = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int value;
    private static int coreNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < testCase + 1; tc++) {
            int n = Integer.parseInt(br.readLine());
            value = Integer.MAX_VALUE;
            coreNum = 0;

            List<Core> coreList = new ArrayList<>();
            int[][] table = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    table[i][j] = input;
                    if (input == 1) {
                        coreList.add(new Core(i, j));
                    }
                }
            }
            solve(table, coreList, 0, 0);
            System.out.println("#" + tc + " " + value);
        }
    }

    private static void solve(int[][] table, List<Core> coreList, int index, int count) {
        if (index == coreList.size()) {
            if (coreNum < count) {
                coreNum = count;
                value = getSum(table);
            }
            if (coreNum == count) {
                int sum = getSum(table);
                value = Math.min(value, sum);
            }
            return;
        }

        Core core = coreList.get(index);
        // 코어가 사방으로 탐색을 진행하고 전원이 연결된다면 제귀적으로 다음 코어 사방탐색 시작
        // 코어가 이미 연결되어 있는 경우 다음 코어 호출
        if (core.y == 0 || core.y == table.length - 1 || core.x == 0 || core.x == table.length - 1) {
            solve(table, coreList, index + 1, count + 1);
            return;
        }

        boolean flag = false;
        for (int i = 0; i < vector.length; i++) {
            // 전원이 연결되거나 -> 정상 종료 -> 다음 코어 호출
            // 다른 코어에서 연결된 선이 있거나 , 다른 코어가 있거나 -> 비정상 종료 -> 다른 방향으로 탐색
            // 모든 종료 전에는 백트래킹을 이용해 원상복구가 필요하다.

            int cy = core.y;
            int cx = core.x;

            while (true) {
                int ny = cy + vector[i][0];
                int nx = cx + vector[i][1];

                // 다른 전선이나 코어가 있다면
                if (table[ny][nx] == 2 || table[ny][nx] == 1) {
                    break;
                }

                // 전원이 연결되었다면
                if (ny == 0 || nx == 0 || ny == table.length - 1 || nx == table.length - 1) {
                    // 전선을 연결하고 종료
                    table[ny][nx] = 2;
                    cy = ny;
                    cx = nx;
                    solve(table, coreList, index + 1, count + 1);
                    flag = true;
                    break;
                }

                table[ny][nx] = 2;
                cy = ny;
                cx = nx;
            }
            // 백트래킹
            // 현재 위치부터 core.x y 전가지 0으로 수정
            while (true) {
                if (cy == core.y && cx == core.x) {
                    break;
                }
                table[cy][cx] = 0;
                cy = cy - vector[i][0];
                cx = cx - vector[i][1];
            }
        }
        solve(table, coreList, index + 1, count);
    }

    private static int getSum(int[][] table) {
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == 2) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void print(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
