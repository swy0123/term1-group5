import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 감시
public class fri_beak_15683 {

    // 상 우 하 좌
    static class CCTV {

        public int y;
        public int x;
        public boolean[] searchableDir;
        public int variation;

        public CCTV(int cctv, int y, int x) {
            this.y = y;
            this.x = x;
            if (cctv == 1) {
                this.searchableDir = new boolean[]{true, false, false, false};
                this.variation = 4;
            } else if (cctv == 2) {
                this.searchableDir = new boolean[]{true, false, true, false};
                this.variation = 2;
            } else if (cctv == 3) {
                this.searchableDir = new boolean[]{true, true, false, false};
                this.variation = 4;
            } else if (cctv == 4) {
                this.searchableDir = new boolean[]{true, true, true, false};
                this.variation = 4;
            } else if (cctv == 5) {
                this.searchableDir = new boolean[]{true, true, true, true};
                this.variation = 1;
            }
        }

        public void rotate() {
            boolean tmp = searchableDir[0];
            for (int i = 1; i < 4; i++) {
                searchableDir[i - 1] = searchableDir[i];
            }
            searchableDir[3] = tmp;
        }
    }

    private static int minBlindSpotCount = Integer.MAX_VALUE;
    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][m];

        ArrayList<CCTV> cctvList = new ArrayList<CCTV>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                table[i][j] = input;
                if (input != 0 && input != 6) {
                    cctvList.add(new CCTV(input, i, j));
                }
            }
        }
        dfs(cctvList, table, 0);
        System.out.println(minBlindSpotCount);
    }

    private static void dfs(ArrayList<CCTV> cctvList, int[][] table, int index) {
        if (index == cctvList.size()) {
            calculateBlindSpot(table);
            return;
        }

        CCTV currentCctv = cctvList.get(index);

        for (int i = 0; i < currentCctv.variation; i++) {
            int[][] cloneTable = new int[table.length][table[0].length];
            copyTable(table, cloneTable);
            for (int d = 0; d < 4; d++) {
                if (!currentCctv.searchableDir[d]) {
                    continue;
                }
                int y = currentCctv.y;
                int x = currentCctv.x;
                while (true) {
                    y = y + move[d][0];
                    x = x + move[d][1];
                    if (y < 0 || x < 0 || y >= table.length || x >= table[0].length) {
                        break;
                    }
                    if (table[y][x] == 6) {
                        break;
                    }
                    table[y][x] = 9;
                }
            }
            dfs(cctvList, table, index + 1);
            // 백트래킹
            copyTable(cloneTable, table);
            currentCctv.rotate();
        }
    }

    private static void copyTable(int[][] table, int[][] cloneTable) {
        for (int a = 0; a < table.length; a++) {
            for (int b = 0; b < table[0].length; b++) {
                cloneTable[a][b] = table[a][b];
            }
        }
    }

    private static void calculateBlindSpot(int[][] table) {
        int blindSpotCount = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 0) {
                    blindSpotCount++;
                }
            }
        }
        minBlindSpotCount = Math.min(minBlindSpotCount, blindSpotCount);
    }
}
