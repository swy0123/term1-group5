import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 제곱
public class mon_beak_10830 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] divide = divide(matrix, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(divide[i][j] % 1000 + " ");
            }
            System.out.println();
        }
    }

    private static int[][] divide(int[][] matrix, long b) {
        if (b == 1) {
            return matrix;
        }
        if (b % 2 == 0) {
            int[][] tmp = divide(matrix, b / 2);
            return squreMatrix(tmp, tmp);
        } else {
            int[][] tmp = divide(matrix, b / 2);
            return squreMatrix(squreMatrix(tmp, tmp), matrix);
        }
    }

    private static int[][] squreMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] tmpMatrix = new int[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                int tmp = 0;
                for (int k = 0; k < matrix1.length; k++) {
                    tmp += matrix1[i][k] * matrix2[k][j];
                }
                tmpMatrix[i][j] = tmp % 1000;
            }
        }
        return tmpMatrix;
    }
}