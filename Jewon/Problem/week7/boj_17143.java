package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boj_17143 낚시왕 골드 1
 * 
 * @author elder
 *
 */
public class boj_17143 {

	static int R, C;
	static int M;

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r; // row
			this.c = c; // col
			this.s = s; // 속력
			this.d = d; // 이동방향
			this.z = z; // 크기
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

	static Shark[] Sharks;
	static boolean[] live_sharks;
	// 상 하 우 좌
	static int[][] dir = { {},{ -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static long Ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Sharks = new Shark[M];
		live_sharks = new boolean[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			Sharks[i] = new Shark(r, c, s, d, z);
		}
		
		
//		1. 낚시왕이 오른쪽으로 한 칸 이동한다.
		for (int i = 0; i < C; i++) {
			print();
			
			int targerIdx = -1;
			int target_row = Integer.MAX_VALUE;
			
//		2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
			for (int j = 0; j < Sharks.length; j++) {
				if(i == Sharks[j].c && !live_sharks[j]) {
					if(target_row > Sharks[j].r) {
						targerIdx = j;
						target_row = Sharks[j].r;
					}
				}
			}
			
			if(targerIdx == -1) {
				// 못잡음 ㅠㅠ
			}else {
				live_sharks[targerIdx] = true; //죽임 ㅠㅠ
				Ans += Sharks[targerIdx].z;
			}
			
//		3. 상어가 이동한다.
			for (int j = 0; j < Sharks.length; j++) {
				if(!live_sharks[j]) {
					move(Sharks[j]);
				}
			}
			
//		4. 같은 칸에 있는 상어 처리
			int map[][] = new int[R][C];
			for (int j = 0; j < map.length; j++) {
				Arrays.fill(map[j], -1);
			}
			
			for (int j = 0; j < M; j++) {
				if(!live_sharks[j]) {
					int r = Sharks[j].r;
					int c = Sharks[j].c;
					
					if(map[r][c] == -1) {
						map[r][c] = j;
					}else {
						if(Sharks[map[r][c]].z < Sharks[j].z) {
							live_sharks[map[r][c]] = true;
							map[r][c] = j;
						}else {
							live_sharks[j] = true;
						}
					}
				}
			}
			
			
//			for (int j = 0; j < M-1; j++) {
//				for (int jj = j+1; jj < M ; jj++) {
//					if(!live_sharks[j] && !live_sharks[jj]) { //둘이 살아 있어야함
//						if(Sharks[j].r == Sharks[jj].r && Sharks[j].c == Sharks[jj].c) { // 같은 곳에 있으면
//							if(Sharks[j].z < Sharks[jj].z ) {
//								live_sharks[j] = true;
//							}else {
//								live_sharks[jj] = true;
//							}
//						}
//					}
//				}
//			}
			
		}
		
		System.out.println(Ans);
	}
	
	private static void print() {
		int[][] map = new int[R][C];
		for (int j = 0; j < M; j++) {
			if(!live_sharks[j]) {
				int r = Sharks[j].r;
				int c = Sharks[j].c;
				map[r][c] = j;
			}
		}
	}

	private static void move(Shark shark) {
//		shark.r += dir[shark.d][0] * shark.s;
//		shark.c += dir[shark.d][1] * shark.s;
		for (int i = 0; i < shark.s; i++) {
			switch(shark.d) {
			case 1: // 상
				if(shark.r == 0) {
					shark.d = 2;
					shark.r += dir[shark.d][0];
				}else {
					shark.r += dir[shark.d][0];
				}
				break;
			case 2: // 하
				if(shark.r == R-1) {
					shark.d = 1;
					shark.r += dir[shark.d][0];
				}else {
					shark.r += dir[shark.d][0];
				}
				break;
			case 3: // 우
				if(shark.c == C-1) {
					shark.d = 4;
					shark.c += dir[shark.d][1];
				}else {
					shark.c += dir[shark.d][1];
				}
				break;
			case 4: // 좌
				if(shark.c == 0) {
					shark.d = 3;
					shark.c += dir[shark.d][1];
				}else {
					shark.c += dir[shark.d][1];
				}
				break;
			}
		}
	}

}
