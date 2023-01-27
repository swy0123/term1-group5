import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int testCase = 1; testCase <= T; testCase++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			int cityCnt = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] map = new int[cityCnt + 2];
			map[0] = 1;
			map[cityCnt + 1] = 1;
			for(int i = 1; i < cityCnt + 1; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0, res = 0;
			for (int i = 0; i < cityCnt + 2; i++) {
				if (map[i] == 1) {
					cnt = 0;
				}
				else {
					cnt++;
					if(cnt == d) {
						res++;
						cnt = 0;
					}
				}
			}
			System.out.println("#" + testCase + " " + res);
		}
	}
}
