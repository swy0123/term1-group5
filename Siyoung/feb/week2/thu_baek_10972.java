package algorithm.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 10972 다음 순열
 */
public class thu_baek_10972 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int curi = 0;
		for(int i=n-1; i>0; i--) {
			if(arr[i] > arr[i-1]) {
				curi = i;
				break;
			}
		}
//		System.out.println(arr[curi]);
		if(curi == 0) {
			System.out.println(-1);
		}
		else {
			int tmp = 0;
			for(int i=n-1; i>curi; i--) {
				if(arr[i] > arr[curi-1] && arr[i] < arr[curi]) {
					tmp = arr[i];
					arr[i] = arr[curi];
					arr[curi] = tmp;
				}
			}
			int[] subarr = new int[n-curi];
			for(int i=1; i<subarr.length; i++) {
				subarr[i] = arr[i+curi];
			}
			subarr[0] = arr[curi-1];
			Arrays.sort(subarr);
			
			for(int i=0; i<curi-1; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(arr[curi]+" ");
			for(int i=0; i<subarr.length; i++) {
				if(i==subarr.length-1) sb.append(subarr[i]);
				else sb.append(subarr[i]+" ");
			}
			System.out.println(sb);
		}
		
	}

}
