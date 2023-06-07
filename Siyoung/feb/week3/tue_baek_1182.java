package algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 1182 부분수열의 합
 */
public class tue_baek_1182 {
	static int n, s, cnt = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		back(0, 0, 0);
		System.out.println(cnt);
	}
	
	private static void back(int idx, int sum, int check) {
		if(check > 0 && sum == s) {
			cnt++;
		}
		if(idx == n) return;
		
		for(int i=idx; i<n; i++) {
			back(i+1, sum+arr[i], check+1);
		}
		
	}

}
