package com.ssafy.feb.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tue_baek_10163 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[1001][1001];
		
		int n = Integer.parseInt(br.readLine());
		int[] check = new int[n+1];
		int y, x, w, h;
		
		for(int k=1; k<=n; k++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for(int a=x; a<x+h; a++) {
				for(int b=y; b<y+w; b++) {
					map[a][b] = k;
				}
			}
		}
		
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				if(map[i][j] == 0) continue;
				check[map[i][j]]++;
			}
		}
		
//		for (int[] i : map) {
//			for (int j : i) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		
		for (int i=1; i<n+1; i++) {
			System.out.println(check[i]);
		}
		

	}

}
