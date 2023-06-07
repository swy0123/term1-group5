import java.util.Scanner;

public class Solution {
    static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
    static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {

            int n = sc.nextInt();
            int maxHeight = 0;
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.next().charAt(0);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 'G') continue;
                    if (parkExist(arr, i, j)) maxHeight = Math.max(maxHeight, 2);
                    else {
                        int height = 1;
                        for (int k = 0; k < 4; k++) {
                            int nx = i, ny = j;
                            for (int l = 0; l < n; l++) {
                                nx += dx[k]; ny += dy[k];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                                if (arr[nx][ny] == 'B') height++;
                            }
                        }
                        maxHeight = Math.max(maxHeight, height);
                    }
                }
            }

            System.out.println("#" + testCase + " " + maxHeight);
        }
    }

    private static boolean parkExist(char[][] arr, int x, int y) {
        int n = arr.length;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (arr[nx][ny] == 'G') {
                return true;
            }
        }
        return false;
    }
}
