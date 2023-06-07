package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사2_15486 {
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] tarr = new int[n+1];
		int[] parr = new int[n+1];
		arr = new long[n+2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			tarr[i] = Integer.parseInt(st.nextToken());
			parr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<=n; i++) {
			int next = tarr[i]+i;
			int pay = parr[i];
			
			if(next<=n) {
				arr[next] = Math.max(arr[next], arr[i]+pay);
			}
			arr[i+1] = Math.max(arr[i], arr[i+1]);
		}
		
//		System.out.println(Arrays.toString(arr));
		System.out.println(arr[n+1]);
	}
}
