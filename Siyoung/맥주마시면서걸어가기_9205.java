package se;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기_9205 {
	
	static int t, n, inf = 999999;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			n = Integer.parseInt(br.readLine());
			n += 2;
			int[][] pos = new int[n][2];
			st = new StringTokenizer(br.readLine());
			pos[0][0] = Integer.parseInt(st.nextToken());
			pos[0][1] = Integer.parseInt(st.nextToken());
			for(int l=1; l<=n-2; l++) {
				st = new StringTokenizer(br.readLine());
				pos[l][0] = Integer.parseInt(st.nextToken());
				pos[l][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			pos[n-1][0] = Integer.parseInt(st.nextToken());
			pos[n-1][1] = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(Math.abs(pos[i][0]-pos[j][0])+Math.abs(pos[i][1]-pos[j][1])>1000) {
						map[i][j] = inf;
					}
				}
			}
			
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					if(i==k) continue;
					for(int j=0; j<n; j++) {
						if(i==j || j==k) continue;
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
			
			if(map[0][n-1]==0) System.out.println("happy");
			else System.out.println("sad");
		}
		
	}
	
}