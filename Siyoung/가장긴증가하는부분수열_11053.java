package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] map = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int res = 0;
		int[] arr = new int[n+1];
		arr[1] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=i; j>=0; j--) {
				int max = arr[i];
				if(map[i]>map[j]) {
					max=Math.max(max, arr[j]+1);
				}
				arr[i] = max;
				res=Math.max(res, arr[i]);
			}
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(res);

	}
}
