import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_2023 boj_2023 골드5
 * @author SSAFY
 *
 */

public class boj_2023 {
	static int[] sosu1 = { 2, 3, 5, 7 };
	static int[] sosu2 = { 1, 3, 7, 9 };

	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		recur(0, 0);

	}

	private static void recur(int depth, int value) {
		// TODO Auto-generated method stub
		if (depth == N) {
			if (isSosu(value)) {
				System.out.println(value);
			}
			return;
		}
		
		if (!isSosu(value)) {
			return;
		}

		if (depth == 0) {
			for (int i = 0; i < sosu1.length; i++) {
				recur(depth + 1, sosu1[i]);
			}
		} else {
			for (int i = 0; i < sosu2.length; i++) {
				recur(depth + 1, value * 10 + sosu2[i]);
			}
		}

	}

	private static boolean isSosu(int value) {
		// TODO Auto-generated method stub
		for (int i = 2; i < value / 2; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}

}
