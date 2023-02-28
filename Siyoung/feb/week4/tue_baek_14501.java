package algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 14501 퇴사
 */
public class tue_baek_14501 {
	
	static int[][] arr;
	static int n, res;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		res = 0;
		v = new boolean[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		for (int[] is : arr) {
//			System.out.println(Arrays.toString(is));
//		}
		
		count(0, 0);
		System.out.println(res);
	}
	
	private static void count(int day, int cost) {
		if(day >= n) {
//			System.out.println(Arrays.toString(v));
			res = Math.max(res, cost);
			return;
		}
		
		
		if(arr[day][0]+day>n && !v[day]) {
			count(day+1, cost);
			return;
		}
		
		if(!v[day]) {
			v[day] = true;
			count(day+1, cost);
			count(day+arr[day][0], cost+arr[day][1]);
			v[day] = false;
		}
		
	}

}
