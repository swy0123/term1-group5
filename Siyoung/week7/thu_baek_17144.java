package algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 17144 미세먼지 안녕!
 */
public class thu_baek_17144 {
	
	static class point{
		int i, j;

		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	
	static int[] ui = {-1, 0, 1, 0};
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, 1, 0, -1};

	static int r, c, t, map[][];
	static ArrayList<point> cleaner;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		cleaner = new ArrayList<>();
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) cleaner.add(new point(i, j));
			}
		}
		
		for(int i=0; i<t; i++) {
			spread();
			clean();
		}
		int sum = 0;
		for (int[] is : map) {
			for (int it : is) {
				if(it!=-1 && it!=0) {
					sum+=it;
				}
			}
		}
		System.out.println(sum);

	}
	
	//미세먼지 퍼지기
	private static void spread(){
		int[][] tmp = new int[r][c];
		
		int ci, cj, ccnt;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j] != 0) {
					ccnt = 0;
					for(int d=0; d<4; d++) {
						ci = i+ui[d];
						cj = j+dj[d];
						if(ci>=0 && ci<r && cj>=0 && cj<c && map[ci][cj]!=-1) {
							tmp[ci][cj] += (map[i][j]/5);
							ccnt++;
						}
					}
					tmp[i][j] -= ccnt*(map[i][j]/5);
				}
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j] += tmp[i][j];
			}
		}
	}
	
	//공기 청정기 배열 돌리기
	private static void clean() {
		//위 아래 각각 좌표
		point p1 = cleaner.get(0);
		point p2 = cleaner.get(1);
		
		int i = p1.i, j = p1.j, idx = 0;
		while(idx<4) {
			int ci = i+ui[idx];
			int cj = j+dj[idx];
			if(ci>=0 && ci<=p1.i && cj>=0 && cj<c) {
				if(map[i][j] == -1) {
					i = ci;
					j = cj;
					continue;
				}
				if(map[ci][cj] == -1) {
					map[i][j] = 0;
					break;
				}
				map[i][j] = map[ci][cj];
				i = ci;
				j = cj;
			}
			else {
				idx++;
			}
		}
		i = p2.i;
		j = p2.j;
		idx = 0;
		while(idx<4) {
			int ci = i+di[idx];
			int cj = j+dj[idx];
			if(ci>=p2.i && ci<r && cj>=0 && cj<c) {
				if(map[i][j] == -1) {
					i = ci;
					j = cj;
					continue;
				}
				if(map[ci][cj] == -1) {
					map[i][j] = 0;
					break;
				}
				map[i][j] = map[ci][cj];
				i = ci;
				j = cj;
			}
			else {
				idx++;
			}
		}
		
	}

}
