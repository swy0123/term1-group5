package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 연속합_1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] map = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr = new int[n];
		arr[0] = map[0];
		int res = arr[0];
		for(int i=1; i<n; i++) {
			arr[i] = Math.max(arr[i-1]+map[i], map[i]);
			res = Math.max(res, arr[i]);
		}
		System.out.println(res);
		
	}
}
