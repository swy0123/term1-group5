import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 캐슬디펜스
public class fri_beak_17135 {

    static class Enemy implements Comparable<Enemy> {

        public int y;
        public int x;
        public int dist;

        public Enemy(int y, int x, int dist) {
            super();
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Enemy o) {
            if (this.dist == o.dist) {
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }

    }

    private static final List<int[]> archerPositionList = new ArrayList<>();
    private static int totalEnemy = 0;
    private static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] orgTable = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    totalEnemy++;
                }
                orgTable[i][j] = input;
            }
        }

        int[][] table = new int[n][m];

        combination(m, 0, 0, new int[3]);
        for (int[] archers : archerPositionList) {
            makeTable(n, m, orgTable, table);
            playGame(d, table, archers, n);
            calculateResult(table);
        }
        System.out.println(maxValue);
    }

    private static void calculateResult(int[][] table) {
        int enemyCount = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1) {
                    enemyCount++;
                }
            }
        }
        maxValue = Math.max(totalEnemy - enemyCount, maxValue);
    }

    private static void playGame(int d, int[][] table, int[] archers, int n) {
        int y = n;
        while (y != 0) {
            // 각 아처들의 적들을 담는 리스트
            List<Enemy> allArcherTarget = new ArrayList<>();

            for (int x : archers) {
                // 아처별 적들과 거리를 담는 리스느
                List<Enemy> oneArcherList = new ArrayList<>();
                for (int i = 0; i < y; i++) {
                    for (int j = 0; j < table[0].length; j++) {
                        if (table[i][j] == 1) {
                            int dist = Math.abs(y - i) + Math.abs(x - j);
                            if (dist <= d) {
                                oneArcherList.add(new Enemy(i, j, dist));
                            }
                        }
                    }
                }
                if (!oneArcherList.isEmpty()) {
                    allArcherTarget.add(Collections.min(oneArcherList));
                }
            }
            for (Enemy enemy : allArcherTarget) {
                table[enemy.y][enemy.x] = 0;
            }
            y--;
        }
    }

    private static void makeTable(int n, int m, int[][] orgTable, int[][] table) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = orgTable[i][j];
            }
        }
    }

    private static void combination(int n, int index, int depth, int[] result) {
        if (depth == result.length) {
            archerPositionList.add(Arrays.copyOf(result, result.length));
            return;
        }

        for (int i = index; i < n; i++) {
            result[depth] = i;
            combination(n, i + 1, depth + 1, result);
        }
    }
}
