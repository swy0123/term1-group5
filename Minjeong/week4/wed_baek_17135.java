import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, d, res;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 궁수(2로 표시)를 배치(조합)
        // 2. 배치된 상태에서 d 거리 이내의 적 공격하며 게임 진행
        // 3. 최대값 기록하며 몇 명의 적을 제거하는지 시뮬
        solve(0, 0, new boolean[m]);
        System.out.println(res);
    }

    private static void solve(int pos, int depth, boolean[] v) {
        // 3명 다 배치했으면 시뮬 시작
        if (depth == 3) {
            int cnt = 0;
            int[][] tmp = new int[n + 1][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tmp[i][j] = arr[i][j];
                    if (arr[i][j] == 1) cnt++;
                }
            }
            simulStart(cnt);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = tmp[i][j];
                }
            }
            return;
        }

        for (int i = pos; i < m; i++) {
            if (!v[i]) {
                v[i] = true;
                arr[n][i] = 2;
                solve(i + 1, depth + 1, v);
                arr[n][i] = 0;
                v[i] = false;
            }
        }
    }

    // 배치된 궁수들로 게임 시작
    private static void simulStart(int enemys) {
        int kill = 0;
        // 적이 0명이 되기 전까지는 계속 게임 진행
        while (enemys > 0) {
            // d 거리 내에서 각각의 궁수들이 가장 가까이에 위치한 적을 공격
            for (int i = 0; i < m; i++) {
                if (arr[n][i] == 2) attackEnemy(i);
            }

            // 공격당한 적 제거
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == -1) {
                        kill++;
                        enemys--;
                        arr[i][j] = 0;
                    }
                }
            }

            // 적들이 한칸씩 앞으로 이동
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        if (i + 1 == n) enemys--;
                        else arr[i + 1][j] = 1;
                        arr[i][j] = 0;
                    }
                }
            }
        }

        // 죽인 적의 수를 최댓값과 비교
        res = Math.max(res, kill);
    }

    private static void attackEnemy(int pos) {
        int dist = Integer.MAX_VALUE;
        int x = -1, y = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 || arr[i][j] == -1) {
                    int tmp = Math.abs(n - i) + Math.abs(pos - j);
                    if (dist >= tmp && tmp <= d) {
                        if (dist == tmp && y <= j) continue;
                        dist = tmp;
                        x = i;
                        y = j;
                    }
                }
            }
        }
        if (x != -1) arr[x][y] = -1;
    }
}