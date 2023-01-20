package com.ssafy.k_practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Pair {
	public int x;
	public int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			
			int n = sc.nextInt();
			int res = 0;
			char[][] arr = new char[n][n];
			Queue<Pair> q = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.next().charAt(0);
					if (arr[i][j] == 'A' || arr[i][j] == 'B' || arr[i][j] == 'C')
						q.add(new Pair(i, j));
				}
			}
			
			while (!q.isEmpty()) {
				Pair p = q.poll();
				char item = arr[p.x][p.y];
				if (item == 'A') res += movedDistance(1, arr, p.x, p.y, n);
				else if (item == 'B') res += movedDistance(2, arr, p.x, p.y, n);
				else if (item == 'C') res += movedDistance(4, arr, p.x, p.y, n);
			}

			System.out.println("#" + testCase + " " + res);
		}
	}
	
	private static int movedDistance(int code, char[][] arr, int x, int y, int n) {
		int res = 0;
		for (int i = 0; i < code; i ++) {
			int nx = x;
			int ny = y;
			for (int j = 0; j < n; j++) {
				nx += dx[i];
				ny += dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
				if (arr[nx][ny] != 'S') break;
				res++;
			}
		}
		return res;
	}
	
}
