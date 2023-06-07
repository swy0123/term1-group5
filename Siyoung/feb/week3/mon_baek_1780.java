package algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 1780 종이의 개수
 */
public class mon_baek_1780 {
	static int[][] map;
	
	static int minus, zero, plus;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		minus = 0;
		zero = 0;
		plus = 0;
		 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0, 0, n);
		
//		for (int[] i : map) {
//			System.out.println(Arrays.toString(i));
//		}
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
	
	private static void divide(int i, int j, int size) {
		if(check(i, j, size)) {
			if(map[i][j] == -1) minus++;
			else if(map[i][j] == 0) zero++;
			else plus++;
			return;
		}
		{
			divide(i, j, size/3);		
			divide(i, j+size/3, size/3);		
			divide(i, j+size*2/3, size/3);		
			divide(i+size/3, j, size/3);		
			divide(i+size/3, j+size/3, size/3);		
			divide(i+size/3, j+size*2/3, size/3);		
			divide(i+size*2/3, j, size/3);		
			divide(i+size*2/3, j+size/3, size/3);		
			divide(i+size*2/3, j+size*2/3, size/3);	
		}
		
	}
	
	private static boolean check(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[r][c] != map[i][j]) return false;
			}
		}
		return true;
	}

}
