import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int n, m, hi, hj, res;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		hi = -1;
		hj = -1;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'O') {
					hi = i;
					hj = j;
				}
			}
		}
		res = 11;
		solve(0, 5);
		System.out.println(res);
	}
	
	//백트래킹
	private static void solve(int cnt, int dir) {
		if(cnt == 10) {
			for (char[] is : map) {
				System.out.println(Arrays.toString(map));
			};
			return;
		}
		
		int ri=0, rj=0, bi=0, bj=0;
		char[][] tmp = new char[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tmp[i][j] = map[i][j];
				if(map[i][j]=='R') {
					ri = i;
					rj = j;
				}
				if(map[i][j]=='B') {
					bi = i;
					bj = j;
				}
			}
		}
		
		for(int d=0; d<4; d++) {
			if(d == dir) continue;
			
			int state = moveBall(ri, rj, bi, bj, d);
			if(state==0) continue;
			if(state==1) res = Math.min(state, res);
			if(state==2) return;
			if(state==3) return;
			solve(cnt+1, d);
			for(int i=0; i<n; i++) {
				map[i] = tmp[i].clone();
			}
		}
		
	}
	
	private static int moveBall(int ri, int rj, int bi, int bj, int d) {
		
		int cri = ri, crj = rj, cbi = bi, cbj = bj;
		boolean redCheck = false, blueCheck = false;
		boolean redGo = true, blueGo = true;
		while(redGo || blueGo) {
			int nri = cri+di[d];
			int nrj = crj+di[d];
			if(nri>0 && nri<n-1 && nrj>0 && nrj<m-1) {
				if(map[nri][nrj] == 'O') {
					map[cri][crj] = '.';
					redCheck = true;
					redGo = false;
				}
				else if(map[nri][nrj] == '.') {
					map[cri][crj] = '.';
					map[nri][nrj] = 'R';
					cri = nri;
					crj = nrj;
					redGo = true;
				}
				else {
					redGo = false;
				}
			}
			

			int nbi = cbi+di[d];
			int nbj = cbj+di[d];
			if(nbi>0 && nbi<n-1 && nbj>0 && nbj<m-1) {
				if(map[nbi][nbj] == 'O') {
					map[cbi][cbj] = '.';
					blueCheck = true;
					blueGo = false;
				}
				else if(map[nbi][nbj] == '.') {
					map[cbi][cbj] = '.';
					map[nbi][nbj] = 'B';
					cbi = nbi;
					cbj = nbj;
					blueGo = true;
				}
				else {
					blueGo = false;
				}
			}
		}
		
		if(redCheck && blueCheck) return 3;
		if(!redCheck && blueCheck) return 2;
		if(redCheck && !blueCheck) return 1;
		return 0;
	}
}

