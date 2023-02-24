package algorithm.week3.fri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 백준 10026 적록색약
 */
public class fri_baek_10026 {

	static class point{
		int i, j;

		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int n, res1, res2;
	static char map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		boolean[][] v = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!v[i][j]) {
					isBlind(i, j, v, false);
					res1++;
				}
			}
		}
		
		v = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!v[i][j]) {
					isBlind(i, j, v, true);
					res2++;
				}
			}
		}
		
		System.out.println(res1 +" "+ res2);

	}
	
	private static void isBlind(int i, int j, boolean[][] v, boolean flag) {
		Queue<point> q = new LinkedList<>();
		v[i][j] = true;
		q.add(new point(i, j));
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int dr=0; dr<4; dr++) {
                int ci = p.i+di[dr];
                int cj = p.j+dj[dr];
                if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj]) {
                	if(!flag) {
                		if(map[ci][cj] == map[p.i][p.j]) {
                    		v[ci][cj] = true;
                    		q.add(new point(ci, cj));
                    	}
                	}
                	else {
                		if(map[ci][cj] == map[p.i][p.j]) {
                    		v[ci][cj] = true;
                    		q.add(new point(ci, cj));
                    	}
                		else if((map[ci][cj] == 'R' && map[p.i][p.j] == 'G') ||
                				(map[ci][cj] == 'G' && map[p.i][p.j] == 'R')) {
                			v[ci][cj] = true;
                    		q.add(new point(ci, cj));
                		}
                	}
                	
                }
            }
		}
	}

}
