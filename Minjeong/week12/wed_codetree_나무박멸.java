import java.util.*;
import java.io.*;

public class wed_codetree_나무박멸 {
    static int n, m, k, c, res;
    static int[][] map, spray;
    static int[][] del = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] del2 = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        spray = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(res);
    }

    private static void solve() {
        while(m-- > 0) {
            // 1. 나무 성장
            grow();

            // 2. 나무 번식
            spread();

            // 3. 제초제 뿌리기 & 박멸한 나무 수 계산
            putSpray();

            // 4. 제초제 기한 감소
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (spray[i][j] > 0) spray[i][j]--;
                }
            }
        }
    }

    private static void grow() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + del[d][0];
                        int ny = j + del[d][1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] <= 0 || spray[nx][ny] > 0) continue;
                        cnt++;
                    }
                    map[i][j] += cnt;
                }
            }
        }
    }

    private static void spread() {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == -1) tmp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + del[d][0];
                        int ny = j + del[d][1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n
                                || spray[nx][ny] != 0 || map[nx][ny] != 0) continue;
                        cnt++;
                    }
                    if (cnt == 0) continue;
                    int extraCnt = map[i][j] / cnt;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + del[d][0];
                        int ny = j + del[d][1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n
                                || spray[nx][ny] != 0 || map[nx][ny] != 0) continue;
                        tmp[nx][ny] += extraCnt;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) tmp[i][j] = map[i][j];
            }
        }
        map = tmp;
    }

    private static void putSpray() {
        int[][] tmp = new int[n][n];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    tmp[i][j] = map[i][j];
                    for (int d = 0; d < 4; d++) {
                        int nx = i;
                        int ny = j;
                        for (int t = 0; t < k; t++) {
                            nx += del2[d][0];
                            ny += del2[d][1];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n
                                    || spray[nx][ny] != 0 || map[nx][ny] <= 0) break;
                            tmp[i][j] += map[nx][ny];
                        }
                    }
                }
            }
        }

        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maxCnt < tmp[i][j]) {
                    x = i;
                    y = j;
                    maxCnt = tmp[i][j];
                }
            }
        }

        if (map[x][y] == -1) return; // 박멸할 나무 수가 0개 이상이 아니라면 그냥 리턴(가장 헤맸음..ㅠ)
        spray[x][y] = c + 1;
        res += map[x][y];
        map[x][y] = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;
            for (int t = 0; t < k; t++) {
                nx += del2[d][0];
                ny += del2[d][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                if (map[nx][ny] <= 0) {
                    spray[nx][ny] = c + 1;
                    break;
                }
                spray[nx][ny] = c + 1;
                res += map[nx][ny];
                map[nx][ny] = 0;
            }
        }
    }
}