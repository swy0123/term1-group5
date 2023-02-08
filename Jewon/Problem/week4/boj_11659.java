import java.util.Scanner;

/**
 * 
 * boj_11659 구간 합 구하기 4 실버3
 * @author SSAFY
 *
 */
public class boj_11659 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				arr[i] = sc.nextInt();
			} else {
				arr[i] = arr[i-1] + sc.nextInt();
			}
		}
		
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt() - 1;
			int end = sc.nextInt() - 1;
			
			if(start == 0) {
				System.out.println(arr[end]);
			}else {
				System.out.println(arr[end] - arr[start-1]);
			}
		}

	}

}
