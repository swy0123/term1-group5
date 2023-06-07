package IM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * boj_14888 연산자 끼워넣기 실버1
 * 
 * @author SSAFY
 *
 */

public class boj_14888 {
	static List<List<Integer>> list = new ArrayList<List<Integer>>();
	static List<Integer> tlist = new ArrayList<Integer>();
	static int[] operaters;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		operaters = new int[4];

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			operaters[i] = sc.nextInt();
		}

		func(arr, operaters, 0);

//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(Arrays.toString(list.get(i).toArray()));
//		}
		
		for (int i = 0; i < list.size(); i++) {
			int temp = arr[0];
			
			for (int j = 1; j < N; j++) {
				// arr , temp 계산중인값, i 연산자 리스트 행  j 연산자 리스트 열
				temp = calc(arr, temp, i, j);
			}
			
			max = Math.max(max, temp);
			min = Math.min(min, temp);
		}
		
		System.out.println(max);
		System.out.println(min);
	}

	private static int calc(int[] arr, int temp, int i, int j) {
		// TODO Auto-generated method stub
		switch (list.get(i).get(j-1)) {
		case 0:
			// +
			return temp + arr[j];
		case 1:
			// -
			return temp - arr[j];
		case 2:
			// *
			return temp * arr[j];
		case 3:
			// /
			return temp / arr[j];
		}
		return 0;
	}

	private static void func(int[] arr, int[] operaters, int depth) {
		// TODO Auto-generated method stub
		if (check()) {
			List<Integer> copylist = new ArrayList<Integer>();
			copylist.addAll(tlist);
			list.add(copylist);//
			return;
		}

		for (int i = 0; i < operaters.length; i++) {
			if (operaters[i] != 0) {
				operaters[i]--;
				tlist.add(i);
				func(arr, operaters, depth + 1);
				operaters[i]++;
				tlist.remove(depth);
			}
		}
	}

	private static boolean check() {
		for (int i = 0; i < 4; i++) {
			if (operaters[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
