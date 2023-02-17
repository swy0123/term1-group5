import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int[][] ingre;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			ingre = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					ingre[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE;
			comb(0, 0, n, new int[n / 2]);
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	private static void comb(int pos, int depth, int n, int[] res) {
		if (depth == n / 2) {
			Set<Integer> s = new HashSet<>();
			for (int i = 0; i < n / 2; i++) s.add(res[i]);
			result = Math.min(result, calculate(s));
			return;
		}
		
		for (int i = pos; i < n; i++) {
			res[depth] = i;
			comb(i + 1, depth + 1, n, res);
		}
	}

	private static int calculate(Set<Integer> s) {
		int a = 0;
		int b = 0;
		int n = s.size() * 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
			if (i == j) continue;
			if (s.contains(i) && s.contains(j)) a += ingre[i][j];
			else if (!s.contains(i) && !s.contains(j)) b += ingre[i][j];
			}
		}
		return Math.abs(a - b);
	}
}