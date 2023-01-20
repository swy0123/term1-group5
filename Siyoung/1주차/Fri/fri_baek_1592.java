package com.sy.firstweek;

import java.util.Scanner;

public class fri_baek_1592 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n, m, l;
		n = sc.nextInt();
		m = sc.nextInt();
		l = sc.nextInt();
		int idx=0;
		int sum=0;
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = m;
		}
		
		
		while(arr[idx]>0) {
			arr[idx]--;
			if(arr[idx]==0) break;
			if(arr[idx]%2==1) idx+=l;
			else idx-=l;
			sum++;
			if(idx<0) {
				idx+=arr.length;
			}
			else if(idx>=arr.length){
				idx-=arr.length;
			}
		}
		System.out.println(sum);
	}
	
}
