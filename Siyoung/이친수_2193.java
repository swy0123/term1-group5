package se;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 이친수_2193 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n+4];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 2;
		for(int i=4; i<=n; i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		
		System.out.println(arr[n]);
	}

}
