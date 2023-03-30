package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 포도주시식_2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] map = new int[n+2];
		for(int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		int[] arr = new int[n+2];
		arr[1] = map[1];
		arr[2] = map[2]+map[1];
		for(int i=3; i<=n; i++) {
			arr[i] = Math.max(arr[i-1], Math.max(map[i]+map[i-1]+arr[i-3], map[i]+arr[i-2]));
		}
		for (int i : arr) {
			max = Math.max(max, i);
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(max);
	}
}
