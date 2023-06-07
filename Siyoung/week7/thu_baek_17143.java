package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 17143 낚시왕
 */
public class thu_baek_17143 {
	
	static class shark{
		int i, j, speed, dir, size;

		public shark(int i, int j, int speed, int dir, int size) {
			super();
			this.i = i;
			this.j = j;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
	
	static int[] di = {0, -1, 1, 0, 0};
	static int[] dj = {0, 0, 0, 1, -1};
	
	static int r, c, n, map[][];
	static long sum;
	static ArrayList<shark> s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j] = -1;
			}
		}
		
		s = new ArrayList<>();
		int i, j, speed, dir, size;
		for(int k=0; k<n; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken())-1;
			j = Integer.parseInt(st.nextToken())-1;
			speed = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			size = Integer.parseInt(st.nextToken());
			s.add(new shark(i, j, speed, dir, size));
			map[i][j] = k;
		}
		
		sum = 0;
		for(int k=0; k<c; k++) {
			fishing(k);
			moving();
		}
		System.out.println(sum);
		
	}
	
	private static void fishing(int w) {
		for(int i=0; i<r; i++) {
			if(map[i][w] != -1) {
				sum += s.get(map[i][w]).size;
				map[i][w] = -1;
				return;
			}
		}
	}
	
	//상어 이동 + 상어 포식
	private static void moving() {
		int[][] tmap = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				tmap[i][j] = -1;
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j] != -1) {
					shark tmp = s.get(map[i][j]);
					int ci = i+di[tmp.dir]*tmp.speed;
					int cj = j+dj[tmp.dir]*tmp.speed;
					if(ci<0 || ci>=r) {
						while(!(ci>=0 && ci<r)) {
							if(ci<0) {
								ci = -ci;
								tmp.dir = 2;
							}
							else if(ci>=r){
								ci = (r-1)*2 - ci;
								tmp.dir = 1;
							}
						}
					}
					if(cj<0 || cj>=c) {
						while(!(cj>=0 && cj<c)) {
							if(cj<0) {
								cj = -cj;
								tmp.dir = 3;
							}
							else if(cj>=c){
								cj = (c-1)*2 - cj;
								tmp.dir = 4;
							}
						}
					}
					if(tmap[ci][cj] == -1) {
						tmap[ci][cj] = map[i][j];
					}
					else {
						if(tmp.size < s.get(tmap[ci][cj]).size){
							continue;
						}
						else {
							tmap[ci][cj] = map[i][j];
						}
					}
					
				}
			}
		}
		
		for(int i=0; i<r; i++) {
			map[i] = tmap[i].clone();
		}
		
	}

}
