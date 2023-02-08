import java.util.Scanner;

/**
 * boj_2477 2477번 실버2
 * 
 * @author SSAFY
 *
 */
public class boj_2477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int[] list = new int[4];
		int[][] arr = new int[6][2];
		int bigrect = 1;
		int smallrect = 1;

		for (int i = 0; i < arr.length; i++) {
			list[(arr[i][0] = sc.nextInt()) - 1]++;
			arr[i][1] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			if (list[arr[i][0] - 1] == 1) {
				bigrect *= arr[i][1];
			}

			if (arr[i][0] == arr[(i + 2) % 6][0]) {
				smallrect *= arr[(i + 1) % 6][1];
			}
		}
		
		System.out.println((bigrect - smallrect) * K);

	}

}
