package algorithm.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class baek_1025 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		String input;
		for(int i=0; i<n; i++) {
			input = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		
		int min = Math.min(n, m);
		
		
		
		for(int i=1; i<=min; i++) {
			int cur = 0;
			
			//n 인덱스 시작 위치
			for(int j=0; j<n; j++) {
				for(int k=1; k<(n-j-1)/i; k++) {
					
				}
			}
			
		}
		

	}

}
