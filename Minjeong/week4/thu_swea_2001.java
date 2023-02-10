import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
            	st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            
            int res = 0;
            for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					int tmp = 0;
					for (int k = 0; k < m; k++) {
						for (int k2 = 0; k2 < m; k2++) {
							tmp += arr[i + k][j + k2];
						}
					}
					res = Math.max(res, tmp);
				}
			}
            System.out.println("#" + testCase + " " + res);
		}
    }
}
