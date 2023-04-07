package se;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 소수의곱_tmp {
	static int n, k;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int check[] = new int[k];
		ArrayList<Integer> arr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			check[i] = Integer.parseInt(st.nextToken());
			arr.add(check[i]);
		}
		Arrays.sort(check);
		Collections.sort(arr);
		
		int max = (int) Math.pow(arr.get(0), n/k);
		for(int i=0; i<k; i++) {
			int idx = arr.indexOf(check[i]);
			while(idx<arr.size()) {
				int tmp = check[i]*arr.get(idx);
				if(tmp<=max) {
					arr.add(tmp);
				}
				else break;
				idx++;
			}
		}
		
		
	}
		

//	4 20
//	2 3 5 7
//
//	2, 3 5 7 4 6 10 14 8 12 20 28 16 24 32      ... <= 2^n/k ... sort
//	2 3, 4 5 6 7 8 10 12 14 16 20 28 24 32   9 12 15 18 21 24 27   ... < 2^n/k ... 중복제거 ... sort
//	2 3 4 5, 6 7 8 9 10 12 14 15 16 18 20 21 24 27 28 32   25 ... < 2^n/k ... 중복제거 ... sort
//	2 3 4 5, 6 7 8 9 10 12 14 15 16 18 20 21 24 25 27 28 32  ... < 2^n/k ... 중복제거 ... sort
//	2 3 4 5 6 7, 8 9 10 12 14 15 16 18 20 21 24 25 27 28 32  ... < 2^n/k ... 중복제거 ... sort
	
}
