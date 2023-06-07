package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기3_15988 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n+3];
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			
			for(int j=4; j<=n; j++) {
				arr[j] = (arr[j-1]+arr[j-2]+arr[j-3])%1000000009;
			}
			sb.append(arr[n]+"\n");
		}
		System.out.println(sb);
	}
}
