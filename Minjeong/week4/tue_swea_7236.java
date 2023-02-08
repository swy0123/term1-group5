import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = st.nextToken().charAt(0);
                }
            }

            int depth = 0;
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int gCnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dir[k][0];
                        int ny = j + dir[k][1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (arr[nx][ny] == 'G') gCnt++;
                    }
                    if (gCnt == 8) depth = Math.max(depth, 1);
                    else depth = Math.max(depth, 8 - gCnt);
                }
            }

            System.out.println("#" + testCase + " " + depth);
        }
    }
}