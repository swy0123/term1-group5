import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, r;
    private static int[][] arr1, arr2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr1 = new int[n][m];
        arr2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int innerRotateCnt = Math.min(n, m) / 2;
        while (r-- > 0) rotate(innerRotateCnt);
        printArr();
    }

    private static void rotate(int t) {
        for (int i = 0; i < t; i++) {
            int rdx = n - i - 1, rdy = m - i - 1;

            // 상
            for (int j = i + 1; j <= rdy; j++) {
                arr2[i][j - 1] = arr1[i][j];
            }

            // 하
            for (int j = i; j <= rdy - 1; j++) {
                arr2[rdx][j + 1] = arr1[rdx][j];
            }

            // 좌
            for (int j = i; j <= rdx - 1; j++) {
                arr2[j + 1][i] = arr1[j][i];
            }

           // 우
            for (int j = i + 1; j <= rdx; j++) {
                arr2[j - 1][rdy] = arr1[j][rdy];
            }
        }

        int[][] tmp = arr1;
        arr1 = arr2;
        arr2 = tmp;
    }

    private static void printArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
