import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boj_2661 좋은수열 골드4
 * 
 * @author SSAFY
 *
 */
public class boj_2661 {
	static int[] list;
	static int N;
	static int[] arr;
	static int[] ansarr;
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		recur(0);
		
		for (int i = 0; i < ansarr.length; i++) {
			System.out.print(ansarr[i]);
		}
	}

	private static void recur(int depth) {
		// TODO Auto-generated method stub

		if (depth == N) {
			if (flag == false) {
				flag = true;
				ansarr = Arrays.copyOf(arr, arr.length);
			}
			return;
		}
		
		if(flag == true) {
			return;
		}
		

		for (int i = 1; i <= 3; i++) {

			if (depth == 0) {
				arr[depth] = i;
				recur(depth + 1);
			}

			if (depth - 1 >= 0 && arr[depth - 1] != i && check(depth, i)) {
				arr[depth] = i;
				recur(depth + 1);
			}
		}
	}

	private static boolean check(int depth, int i) {
		arr[depth] = i;
		int temp = 1;
		while (depth - temp - temp + 1 >= 0) {
			boolean flag = true;
			for (int j = 0; j < temp; j++) {
				flag &= (arr[depth - j] == arr[depth - temp - j]);
			}
			if (flag == true) {
				return false;
			}
			temp++;
		}

		return true;

	}

}
