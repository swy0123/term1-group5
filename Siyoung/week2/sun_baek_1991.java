package com.sy.secweek.sun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1991 트리 순회 실버1
 * @author swy05
 *
 */
public class sun_baek_1991 {

	static char[][] node = new char[26][2];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char cur, left, right;
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			cur = input[0].charAt(0);
			left = input[1].charAt(0);
			right = input[2].charAt(0);
			node[cur-'A'][0] = left;
			node[cur-'A'][1] = right;
		}
		
		pre('A');
		System.out.println();
		in('A');
		System.out.println();
		post('A');
		
		br.close();
	}
	
	//전위
	public static void pre(char cur) {
		if(cur == '.') return;
		System.out.print(cur);
		pre(node[cur-'A'][0]);
		pre(node[cur-'A'][1]);
	}
	
	//중위
	public static void in(char cur) {
		if(cur == '.') return;
		in(node[cur-'A'][0]);
		System.out.print(cur);
		in(node[cur-'A'][1]);
	}
	
	//후위
	public static void post(char cur) {
		if(cur == '.') return;
		post(node[cur-'A'][0]);
		post(node[cur-'A'][1]);
		System.out.print(cur);
	}
}
