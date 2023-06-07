package algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 블랙잭
 */
public class wed_baek_2798 {

	static int m;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		com(arr, 0, 3, new boolean[n]);
		
		System.out.println(min);
	}
	
	private static void com(int[] arr, int idx, int cnt, boolean[] v) {
		if(cnt == 0) {
			int sum = 0;
			for(int i=0; i<v.length; i++) {
				if(v[i]) {
					sum+=arr[i];
				}
			}
			if(sum>m) return;
			if(Math.abs(min-m) > Math.abs(sum-m)) min = sum;
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				com(arr, i+1, cnt-1, v);
				v[i] = false;
			}
		}
		
	}

}
