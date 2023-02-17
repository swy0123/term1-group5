import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] nums;
	static int win, lose;
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			nums = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			selected = new boolean[19];
			
			for (int i = 0; i < 9; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				selected[nums[i]] = true;
			}
			
			win = 0;
			lose = 0;
			comb(1, 0, new int[9], new boolean[19]);
			
			System.out.println("#" + testCase + " " + win + " " + lose);
		}
	}
	
	private static void comb(int pos, int depth, int[] res, boolean[] v) {
		if (depth == 9) {
			int score = calculate(res);
			if (score < 0) lose++;
			else if (score > 0) win++;
			return;
		}
		
		for (int i = 1; i <= 18; i++) {
			if (!selected[i] && !v[i]) {
				res[depth] = i;
				v[i] = true;
				comb(i + 1, depth + 1, res, v);
				v[i] = false;
			}
		}
	}

	private static int calculate(int[] res) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < 9; i++) {
			if (nums[i] > res[i]) a += (nums[i] + res[i]);
			else if (nums[i] < res[i]) b += (nums[i] + res[i]);
		}
		return a - b;
	}
}