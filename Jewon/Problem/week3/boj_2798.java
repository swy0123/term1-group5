package IM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2798 {
	static boolean[] visit;
	static int[] arr;
	static List<Integer> ans = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		visit = new boolean[N];
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		dfs(0,0);
		
		int ansv = 0;
		for(int i =0; i< ans.size(); i++) {
			if( M - ans.get(i) >= 0 &&  M - ansv >  M - ans.get(i)) {
				ansv = ans.get(i);
			}
		}
		
		System.out.println(ansv);
	}

	private static void dfs(int depth, int start) {
		// TODO Auto-generated method stub
		if(depth == 3) {
			int sum = 0;
			for (int i = 0; i < visit.length; i++) {
				if(visit[i] == true) {
					sum += arr[i];
				}
			}
			ans.add(sum);
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				dfs(depth+1, i);
				visit[i] = false;
			}
		}
	}

}
