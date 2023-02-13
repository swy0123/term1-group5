package com.sy.jan.thirdweek;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * 백준 6603 로또
 * @author swy05
 */
public class mon_baek_6603 {
	static int[] arr;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			if(n==0) break;
			
			arr = new int[n];
			flag = new boolean[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(input[i+1]);
			}
			
			func(6, 0);
			System.out.println();
		}

	}
	
	private static void func(int cnt, int start) {
		//마지막까지 다 정해짐
		if(cnt == 0) {
			for(int i=0; i<flag.length; i++) {
				if(flag[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
		}
		
		for(int i=start; i<flag.length; i++) {
			if(cnt+i > flag.length) break;
			flag[i] = true;
			func(cnt-1, i+1);
			flag[i] = false;
		}
		
	}

}