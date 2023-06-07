package week3;

import java.util.Scanner;

/**
 * 
 * boj_3985 롤 케이크 브론즈1
 * 
 * @author elder
 *
 */
public class boj_3985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int[] arrL = new int[L+1];

		int N = sc.nextInt();
		int[][] arr = new int[N][2];

		int maxIdx = -1;
		int realMaxIdx = -1;
		int max = 0;
		int realMax = 0;
		for (int i = 0; i < arr.length; i++) {
			int cnt = 0;
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();

			if (max < arr[i][1] - arr[i][0] + 1) {
				max = arr[i][1] - arr[i][0] + 1;
				maxIdx = i + 1;
			}

			for (int j = arr[i][0]; j <= arr[i][1]; j++) {
				if (arrL[j] == 0) {
					arrL[j] = i + 1;
					cnt++;
				}
			}
			if (realMax < cnt) {
				realMax = cnt;
				realMaxIdx = i+1;
			}

		}
		
		System.out.println(maxIdx);
		System.out.println(realMaxIdx);
	}

}
