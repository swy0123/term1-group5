package com.sy.jan.thirdweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 백준 15649 N과 M (1)
 * @author swy05
 *
 */
public class mon_baek_15649 {

	static int[] arr;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		arr = new int[n];
		for(int i=1; i<=n; i++) {
			arr[i-1] = i;
		}
		
		flag = new boolean[n];
		
		perm("", m);

	}
	
//	private static void comb(int depth, int start) {
//		if(depth == 0) {
//			for(int i=0; i<flag.length; i++) {
//				if(flag[i]) {
//					System.out.print(arr[i]+" ");
//				}
//			}
//			System.out.println();
//		}
//		
//		for(int i=start; i<flag.length; i++) {
//			if(start+depth>flag.length) break;
//			flag[i] = true;
//			comb(depth-1, start+1);
//			flag[i] = false;
//		}
//	}
	
	private static void perm(String str, int depth) {
		if(depth == 0) {
			System.out.println(str);
		}
		String tmp = new String(str);
		
		for(int i=0; i<flag.length; i++) {
			if(!flag[i]) {
				flag[i] = true;
				perm(str + Integer.toString(arr[i]) + " ", depth-1);
				flag[i] = false;
			}
		}
		
	}


}
