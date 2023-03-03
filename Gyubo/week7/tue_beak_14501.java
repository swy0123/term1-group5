import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
public class tue_beak_14501 {

	private static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n + 1][2];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		solve(arr, 1, 0);
		System.out.println(maxValue);
	}

	private static void solve(int[][] arr, int index, int result) {

		// index 위치를 탐색하는 경우
		int nIndex = index + arr[index][0];
		int nValue = result + arr[index][1];
		if (nIndex < arr.length) {
			solve(arr, nIndex, nValue);
		} else if (nIndex == arr.length) {
			maxValue = Math.max(maxValue, nValue);
		} else {
			maxValue = Math.max(maxValue, result);
		}

		// index 위치를 탐색하지 않는 경우
		nIndex = index + 1;
		if (nIndex < arr.length) {
			solve(arr, nIndex, result);
		} else {
			maxValue = Math.max(maxValue, result);
		}

	}
}
