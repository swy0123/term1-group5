package week4;


import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/*
 * swea 7465. 창용 마을 무리의 개수
 */
public class mon_swea_7465
{
	static int[] arr;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T=Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			
			arr = new int[n+1];
			boolean[] v = new boolean[n+1];
			for(int i=1; i<=n; i++) {
				arr[i] = i;
			}
			
			int tmp, cnt = 0;
			
			for(int k=0; k<m; k++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				union(i, j);
			}
		
			for(int i=1; i<=n; i++) {
				tmp = find(i);
				if(!v[tmp]) {
					v[tmp] = true;
					cnt++;
				}
			}
			System.out.println("#"+test_case+" "+cnt);
			
		}
	}
	
	private static int find(int num) {
		if(arr[num]==num) return num;
		else {
			arr[num] = find(arr[num]);
			return arr[num];
		}
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			arr[a] = b;
		}
	}
}