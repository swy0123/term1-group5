package com.sy.secweek.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//import java.util.Scanner;

/**
 * [백준] 배열돌리기1
 * @author swy05
 *	질문 - printf보다 print가 빠른가요
 */
public class thu_baek_16926 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m, r;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
	 
		int[][] map = new int [n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = Math.min(n, m);
		cnt /= 2;
		int tmp;
		
		for(int k=0; k<r; k++) {
			for(int idx=0; idx<cnt; idx++) {
				if(r-(r%(2*(n-2*idx-1)+2*(m-2*idx-1)))>k) continue;
				tmp = map[idx][idx];
				for(int i=idx; i<m-idx-1; i++) {
					map[idx][i] = map[idx][i+1];
				}
				for(int i=idx; i<n-idx-1; i++) {
					map[i][m-idx-1] = map[i+1][m-idx-1];
				}
				for(int i=m-idx-1; i>idx; i--) {
					map[n-idx-1][i] = map[n-idx-1][i-1];
				}
				for(int i=n-idx-1; i>idx+1; i--) {
					map[i][idx] = map[i-1][idx];
				}
				map[idx+1][idx] = tmp;
			}
		}
		

		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
