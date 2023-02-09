package algorithm.week1.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 백준 2961 도영이가 만든 맛있는 음식
 */
public class thu_baek_2961 {

	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		set(arr, 1, 0, 0);
		
		System.out.println(min);

	}
	
	private static void set(int[][] arr, int s, int b, int idx) {
		if(idx == arr.length) {
			if(b==0) return;
			min = Math.min(min, Math.abs(s-b));
			return;
		}
		
		set(arr, s*arr[idx][0], b+arr[idx][1], idx+1);
		set(arr, s, b, idx+1);
		
		
	}
	
	

}
