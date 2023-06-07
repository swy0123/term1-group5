package algorithm.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * 1247. [S/W 문제해결 응용] 3일차 - 최적 경로 D5
 */
public class tue_swea_1247 {
	
	static int res;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		int n;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			res = Integer.MAX_VALUE;
			int[][] map;
			n = sc.nextInt() + 2;
			sc.nextLine();
			map = new int[n][2];
			
			String[] str = sc.nextLine().split(" ");
			
//			for (String string : str) {
//				System.out.println(string);
//			}
			
			for(int i=0; i<n*2; i+=2) {
				map[i/2][0] = Integer.valueOf(str[i]);
				map[i/2][1] = Integer.valueOf(str[i+1]);
			}
			
//			for (int[] i : map) {
//				for (int num : i) {
//					System.out.print(num+" ");
//				}
//				System.out.println();
//			}
			
			find(map, new boolean[n], new int[2], 0, 0);
			System.out.println("#"+test_case+" "+res);
		}
	}
	
	private static void find(int[][] map, boolean[] flag, int[] arr, int len, int cnt) {
//		System.out.println(arr[0] + " " + arr[1]);
//		for (boolean i : flag) {
//			System.out.print(i +" ");
//		}
//		System.out.println(len);

		if(cnt == map.length-1) {
			res = Math.min(res, len + (Math.abs(arr[0]-map[1][0]) + Math.abs(arr[1]-map[1][1])));
//			System.out.println(res);
			return;
		}
		
		if(cnt == 0) {
			find(map, flag, map[0], 0, cnt+1);
			return;
		}
		
		
		for(int i=2; i<map.length; i++) {
			if(flag[i] == false) {
				flag[i] = true;
				find(map, flag, map[i], len + (Math.abs(arr[0]-map[i][0]) + Math.abs(arr[1]-map[i][1])), cnt+1);
				flag[i] = false;
			}
		}
	}
	

}
