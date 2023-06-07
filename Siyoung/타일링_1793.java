package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 타일링_1793 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger[] arr = new BigInteger[251];
		arr[0] = BigInteger.valueOf(1);
		arr[1] = BigInteger.valueOf(1);
		arr[2] = BigInteger.valueOf(3);
		arr[3] = BigInteger.valueOf(5);
		
		
		for(int i=3; i<=250; i++) {
			arr[i] = arr[i-1].add(arr[i-2].multiply(BigInteger.TWO));
		}
//		System.out.println(Arrays.toString(arr));
		
		while(true) {
			String n = br.readLine();
			if(n==null) break;
			if(n=="") break;
			System.out.println(arr[Integer.parseInt(n)]);
		}
	}
	
	private static StringBuilder sum(StringBuilder s1, StringBuilder s2) {
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		while(!s1.isEmpty() || !s2.isEmpty() || sum>0) {
			if(!s1.isEmpty()) {
				sum += s1.charAt(s1.length()-1)-'0';
			}
		}
		
		return s2;
		
		
	}
}