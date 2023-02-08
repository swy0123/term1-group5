import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
        int[][] nums = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				nums[i][j] += nums[i][j - 1];
			}
		}
        
        for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				nums[j][i] += nums[j - 1][i];
			}
		}
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
//        	System.out.println(nums[c][d] + " " + nums[c][b - 1] + " " + nums[a - 1][d] + " " + nums[a - 1][b - 1]);
        	int res = nums[c][d] - nums[c][b - 1] - nums[a - 1][d] + nums[a - 1][b - 1];
        	sb.append(res).append("\n");
		}
        System.out.println(sb.toString());
    }
}