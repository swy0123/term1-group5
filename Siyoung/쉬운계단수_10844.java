package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 쉬운계단수_10844 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][] arr = new long[n+1][10];
		Arrays.fill(arr[1], 1);
		arr[1][0]=0;
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<10; j++) {
				if(j==0) arr[i][j] += arr[i-1][j+1];
				else if(j==9) arr[i][j] += arr[i-1][j-1];
				else {
					arr[i][j] += arr[i-1][j+1] + arr[i-1][j-1];
				}
				arr[i][j] = arr[i][j]%1000000000;
			}
		}
		long res = 0;
		for (long is : arr[n]) {
			res += is;
		}
		System.out.println(res%1000000000);
	}
}
