import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int MAX_VAL = 1000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int testCase = 1; testCase <= T; testCase++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int[] nums = {p, q};
			int val, tmp, x = 0, y = 0;
			
			for (int num : nums) {
				val = 1;
				out: for (int i = 1, k = 2; i <= MAX_VAL; i++) {
					tmp = val;
					int k2 = i;
					for (int j = 1; j <= MAX_VAL; j++) {
						if (j != 1) tmp += k2++;
						if (tmp == num) {
							x += i;
							y += j;
							break out;
						}
					}
					val += k++;
				}
			}
			
			val = 0;
			for (int i = 1; i <= MAX_VAL; i++) {
				val += i;
				if (i == x) break;
			}
			
			for (int j = 1; j <= MAX_VAL; j++) {
				if (j == y) {
					System.out.println("#" + testCase + " " + val);
					break;
				}
				val += x++;
			}
		}
	}
}