import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];

			int dir = 1;
			int start = 0;
			int cnt = 1;
			int x = 0;
			int y = -1;
			while (true) {

				for (int i = 0; i < arr.length - start; i++) {
					y += dir;
					arr[x][y] = cnt;
					cnt++;
				}

				start++;

				if (start >= N) {
					break;
				}

				for (int i = 0; i < arr.length - start; i++) {
					x += dir;
					arr[x][y] = cnt;
					cnt++;
				}

				dir *= -1;
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
