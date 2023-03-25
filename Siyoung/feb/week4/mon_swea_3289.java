package week4;


import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/*
 * swea 3289. 서로소 집합
 */
public class mon_swea_3289
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
			for(int i=1; i<=n; i++) {
				arr[i] = i;
			}
			
			sb.append("#"+test_case+" ");
			for(int k=0; k<m; k++) {
				st = new StringTokenizer(br.readLine());
				int o = Integer.parseInt(st.nextToken());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				if(o == 0) {
					union(i, j);
				}
				if(o == 1) {
					if(find(i)==find(j)) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println(sb);
		
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
