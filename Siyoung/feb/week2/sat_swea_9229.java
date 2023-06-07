package feb.week2.sat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * swea 9229. 한빈이와 Spot Mart
 */
public class sat_swea_9229 {

	static int m;
	static int max;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			max = -1;
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(arr, new int[2], 0, 0);
			
			System.out.println("#"+test_case+" "+max);
		}
	}
	
	private static void comb(int[] arr, int[] res, int idx, int cnt) {
		if(cnt == res.length) {
			int sum = 0;
			for(int i=0; i<res.length; i++) {
				sum+=res[i];
			}
			if(sum <= m) {
				max = Math.max(max, sum);
			}
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			res[cnt] = arr[i];
			comb(arr, res, i+1, cnt+1);
		}
		
	}

}
