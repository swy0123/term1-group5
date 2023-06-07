package algorithm.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * swea 햄버거 다이어트
 */
public class wed_swea_5215 {

	static int res;
	static int n;
	static int limit;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T=Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// n:재료수 limit:칼로리 제한 
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			// 0:맛 1:칼로리
			int[][] arr = new int[n][2];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
//			for (int[] i : arr) {
//				for (int j : i) {
//					System.out.print(j+" ");
//				}
//				System.out.println();
//			}
			
			res = 0;
			hamburger(arr, 0, 0, 0);
			System.out.println("#" + test_case+" "+res);
		}
	}
	
	private static void hamburger(int[][] arr, int cnt, int score, int cal) {
		if(cal > limit) return;
		if(cnt == n) {
			if(cal <= limit) {
				if(score > res) res = score;
			}
			return;
		}
		if(cal <= limit) {
			if(score > res) res = score;
		}

		
		hamburger(arr, cnt+1, score+arr[cnt][0], cal+arr[cnt][1]);
		hamburger(arr, cnt+1, score, cal);
		
	}

}
