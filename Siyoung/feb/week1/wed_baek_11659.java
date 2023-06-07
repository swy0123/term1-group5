package algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 백준 11659 구간 합 구하기 4
 */
public class wed_baek_11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start, end;
		int[] arr = new int[n];
		int[] sum = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sum[0] = 0;
		for(int i=1; i<n+1; i++){
			sum[i] = sum[i-1]+arr[i-1];
		}
//		for (int i : sum) {
//			System.out.print(i+" ");
//		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			if(start!= end) System.out.println(sum[end]-sum[start-1]);
			else System.out.println(arr[start-1]);
		}
		
	}

}

//public class test {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int n = 10000;
//		
//		System.out.println("10000 3");
//		for(int i=1; i<=n; i++) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		System.out.println("1 3");
//		System.out.println("1 10000");
//		System.out.println("10 30");
//	}
//
//}
//--------------------------------------------
//6
//50005000
//420

