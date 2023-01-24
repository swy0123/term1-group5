import java.util.Scanner;


/*
 * 1859. 백만 장자 프로젝트
 */

public class SWEA_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int idx = 0;
			int maxidx = 0;
			int maxval = 0;
			long result = 0;

			int[] list = new int[N];
			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}

			while (idx != N) {
				// search max idx
				for (int i = idx; i < N; i++) {
					if (maxval < list[i]) {
						maxval = list[i];
						maxidx = i;
					}
				}

				// sum of value
				for (int i = idx; i < maxidx; i++) {
					result += maxval - list[i];
				}

				//
				idx = maxidx + 1;
				maxval = 0;
			}
			
			System.out.println("#" + test_case + " " + result );
		}

	}

}
