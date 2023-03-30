package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] warr = new int[n];
		int[] varr = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			warr[i] = Integer.parseInt(st.nextToken());
			varr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr = new int[k+1];
		for(int i=0; i<n; i++) {
			int[] tmp =  arr.clone();
//			System.out.println(Arrays.toString(arr));
			for(int j=0; j<=k; j++) {
				if(j+warr[i]<=k) {
					arr[j+warr[i]] = Math.max(tmp[j+warr[i]], tmp[j]+varr[i]);
				}
				if(j>0) arr[j] = Math.max(arr[j], arr[j-1]);
			}
		}
		
		System.out.println(arr[k]);
		
	}
}
