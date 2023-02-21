package com.sy.secweek.sat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
/**
 * 백준 11729 하노이 탑 이동 순서 성공
 * @author swy05
 *
 */
public class sat_baek_11729 {
	static ArrayList<String> str = new ArrayList();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		hanoi(n, 1, 3);
		System.out.println(str.size());
		for (String i : str) {
			bw.write(i+"\n");
		}
		
		br.close();
		bw.close();
	}
	
	//재귀
	//현재 위치 -> 목표위치
	//나머지는 빈 곳으로 이동
	//맨 아래 판 이동
	//나머지는 다시 맨 아래판 위로 이동
	public static void hanoi(int n, int start, int target) {
		if(n==1) {
			str.add(start+" "+target);
		}
		else {
			hanoi(n-1, start, 6-start-target);
			str.add(start+" "+target);
			hanoi(n-1, 6-start-target, target);
		}
	}

}
