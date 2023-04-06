package se;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_2458 {
	
	static int[][] map;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		map = new int[n][n];
		
		int from, to;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken())-1;
			to = Integer.parseInt(st.nextToken())-1;
			map[from][to] = 1;
			map[to][from] = 1;
		}
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				if(i==k) continue;
				for(int j=0; j<n; j++) {
					if(i==j || j==k) continue;
					map[i][j] = Math.max(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		int res = 0;
		for(int j=0; j<n; j++) {
			int zeroCnt = 0;
			for(int i=0; i<n; i++) {
				if(map[i][j]==0) zeroCnt++;
				if(zeroCnt>1)continue;
			}
			if(zeroCnt==1) res++;
		}
		
		System.out.println(res);
	}
	
}